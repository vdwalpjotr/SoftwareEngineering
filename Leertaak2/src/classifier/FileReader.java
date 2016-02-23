package classifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FileReader {
	public FeatureType yn = new FeatureType("01"
			,new String[]{"0","1"});
	private Scanner input;
	public FileReader(){}

	public Map<String, FeatureType> readFeatures(String pathToFile){
		java.io.File file = new java.io.File(pathToFile);
		Map<String, FeatureType> map = new HashMap<String, FeatureType>();
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		while(input.hasNext()){
			map.put(input.next(), yn);
		}
		return map;
	}

	public Map<Item, String> readTrainingSet(String pathToFile){
		

		Feature[] features = new Feature[]
				{ new Feature("Turbo","0",yn),
						new Feature("EnginPower","0",yn),
						new Feature("SportBumper","0",yn),
						new Feature("SportRing","0",yn),
						new Feature("CruisControll","0",yn),
						new Feature("ABS","0",yn),
						new Feature("AC","0",yn),
						new Feature("Metalic","0",yn)
				};

		File file = new File(pathToFile);
		Map<Item, String> map = new HashMap<Item, String>();
		try{
			input = new Scanner(file);
		} catch(FileNotFoundException e){
			System.out.println("File not found: "+pathToFile);
			e.printStackTrace();
		}
		String firstLine=input.nextLine();
		String[] totalFeat = firstLine.split(";");
		String totalFeatures1 = totalFeat[1].trim();
		int totalFeatures = Integer.parseInt(totalFeatures1);
		String[] totalItem = input.nextLine().split(";");
		int totalItems = Integer.parseInt(totalItem[1].trim());
		System.out.println(totalItems);
		int count = 0;
		while(input.hasNextLine()){
			count++;
			String line = input.nextLine();
			String[] stringarray = line.split(";");
			
				Item item = new Item(stringarray[0], features);
				for(int i=1; i<totalFeatures;i++){
						item.setFeatureValue(features[i].getName(), stringarray[i]);
						
				}
				item.getFeatureValue("AC");
				map.put(item, stringarray[stringarray.length-1]);
			
		}


		return map;}
}
