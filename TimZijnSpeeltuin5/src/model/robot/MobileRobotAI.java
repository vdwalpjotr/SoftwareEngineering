package model.robot;

import model.virtualmap.OccupancyMap;

import java.io.*;
import java.util.*;

/**
 * Title : The Mobile Robot Explorer Simulation Environment v2.0 Copyright: GNU
 * General Public License as published by the Free Software Foundation Company :
 * Hanze University of Applied Sciences
 *
 * @author Dustin Meijer (2012)
 * @author Alexander Jeurissen (2012)
 * @author Davide Brugali (2002)
 * @version 2.0
 */

public class MobileRobotAI implements Runnable {

	private static final int MAX_STEP_COUNT = 10;

	private final OccupancyMap map;
	private final MobileRobot robot;

	private double position[] = new double[3];
	private double measures[] = new double[360];
	private double measuresSonar[] = new double[360];

	private int stepCount;

	private PipedInputStream pipeIn;
	private BufferedReader input;
	private PrintWriter output;

	private boolean running;

	double startPosition[] = new double[3];

	public MobileRobotAI(MobileRobot robot, OccupancyMap map) {
		this.map = map;
		this.robot = robot;
		stepCount = 0;

		try {
			pipeIn = new PipedInputStream();
			input = new BufferedReader(new InputStreamReader(pipeIn));
			output = new PrintWriter(new PipedOutputStream(pipeIn), true);
			robot.setOutput(output);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * In this method the gui.controller sends commands to the robot and its
	 * devices. At the moment all the commands are hardcoded. The exercise is to
	 * let the gui.controller make intelligent decisions based on what has been
	 * discovered so far. This information is contained in the OccupancyMap.
	 */
	public void run() {
		String result;
		this.running = true;

		double startPosition[] = new double[] {-1, -1, 0};

		System.out.println("intelligence running");
		while(running) {
			try {
				updatePosition();
				if(startPosition[0] == -1 && startPosition[1] == -1) {
					// set initial starting position
					startPosition = position.clone();
				}

				// Search for wall
				robot.sendCommand("L1.SCAN");
				
				result = input.readLine();
				parseMeasures(result, measures);
				map.drawLaserScan(position, measures);
				robot.sendCommand("S1.SCAN");
				result = input.readLine();
				parseMeasures(result, measuresSonar);
				map.drawLaserScan(position, measuresSonar);

				// Check positions
				double forward = measures[0];
				double right = measures[90];
				
				double forwardSonar = measuresSonar[10];
				double rightSonar = measuresSonar[90];

				System.out.println("Forward: " + forwardSonar);
				System.out.println("Right:" + rightSonar);

				// If wall is near
				if(right < 50 || rightSonar <50) {
					// If wall is to far
					if(forward > 50.0 && forwardSonar > 50.0) {
						System.out.println("move 50");
						robot.sendCommand("P1.MOVEFW " + Math.min((forward - 50), (forwardSonar - 50)));
						result = input.readLine();
					}
					else if(forward > 15.0 && forwardSonar > 15.0) {
						System.out.println("move less");
						robot.sendCommand("P1.MOVEFW " + Math.min((forward - 15.0), (forwardSonar - 15.0)));
						result = input.readLine();
					}
					// If near wall
					else {
						robot.sendCommand("P1.ROTATELEFT 90");
						result = input.readLine();
					}
				}
				// If wall is to far or gone
				else {
					System.out.println("linenumber : 117");
					boolean turn = true;
					System.out.println("forward: " + forward);
					while(measures[125] < 78.0 || measuresSonar[125] < 78.0) {
						System.out.println("Swek");
						if(measures[0] < 25 || measuresSonar[5] <25) {
							turn = false;
							
							//running = false;
							break;
						}
						
						robot.sendCommand("P1.MOVEFW " + 10);
						result = input.readLine();

						// Search for wall
						robot.sendCommand("L1.SCAN");
						result = input.readLine();
						parseMeasures(result, measures);
						
						robot.sendCommand("S1.SCAN");
						result = input.readLine();
						parseMeasures(result, measuresSonar);
					}
					if(turn == true) {
						robot.sendCommand("P1.ROTATERIGHT 90");
						result = input.readLine();						
					}

					// Search for wall
					robot.sendCommand("L1.SCAN");
					result = input.readLine();
					parseMeasures(result, measures);
					

					robot.sendCommand("S1.SCAN");
					result = input.readLine();
					parseMeasures(result, measuresSonar);

					while(measures[90] > 50 && measuresSonar[90] > 50) {
						if(measures[0] < 25 || measuresSonar[5] < 25) {
							running = false;
							break;
						}
						System.out.println("163");
						robot.sendCommand("P1.MOVEFW " + 10);
						result = input.readLine();

						// Search for wall
						robot.sendCommand("L1.SCAN");
						result = input.readLine();
						parseMeasures(result, measures);
						System.out.println(measures[90]);
						robot.sendCommand("S1.SCAN");
						result = input.readLine();
						parseMeasures(result, measuresSonar); 
						System.out.println(measuresSonar[90]);
					}
				}

				// If near starting position after minimal 10 steps park;
				if(stepCount > MAX_STEP_COUNT && Math.abs(position[0] - startPosition[0]) < 30
						&& Math.abs(position[1] - startPosition[1]) < 30) {
					System.out.println("Done exploring");

					robot.sendCommand("P1.ROTATELEFT 90");
					result = input.readLine();

					running = false;
				}
				stepCount++;
				// repeat

			}
			catch(IOException ioe) {
				System.err.println("execution stopped");
				running = false;
			}
		}
	}

	private void updatePosition() throws IOException {
		robot.sendCommand("R1.GETPOS");
		String value = input.readLine();

		int indexInit;
		int indexEnd;
		String parameter;

		indexInit = value.indexOf("X=");
		parameter = value.substring(indexInit + 2);
		indexEnd = parameter.indexOf(' ');
		position[0] = Double.parseDouble(parameter.substring(0, indexEnd));

		indexInit = value.indexOf("Y=");
		parameter = value.substring(indexInit + 2);
		indexEnd = parameter.indexOf(' ');
		position[1] = Double.parseDouble(parameter.substring(0, indexEnd));

		indexInit = value.indexOf("DIR=");
		parameter = value.substring(indexInit + 4);
		position[2] = Double.parseDouble(parameter);
	}

	private void parseMeasures(String value, double measures[]) {
		for(int i = 0; i < 360; i++) {
			measures[i] = 100.0;
		}
		if(value.length() >= 5) {
			value = value.substring(5); // removes the "SCAN " keyword
			//System.out.println(value);
			StringTokenizer tokenizer = new StringTokenizer(value, " ");

			double distance;
			int direction;
			
			while(tokenizer.hasMoreTokens()) {
				distance = Double.parseDouble(tokenizer.nextToken().substring(2));
				direction = (int) Math.round(Math.toDegrees(Double.parseDouble(tokenizer.nextToken().substring(2))));
				
				if(direction == 360) {
					direction = 0;
				}
				measures[direction] = distance;
				// Printing out all the degrees and what it encountered.
				 //System.out.println("direction = " + direction + " distance = "+distance);
				// " + distance);
			}
		}
	}

}
