package classifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FileReader {

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
			map.put(input.next(), new FeatureType("01", new String[]{"1","0"}));
		}
		return map;
	}

	public Map<Item, String> readTrainingSet(String pathToFile){
		FeatureType yn = new FeatureType("YesNo"
				,new String[]{"yes","no"});

		Feature[] features = new Feature[]
				{ new Feature("Turbo","yes",yn),
						new Feature("EnginPower","yes",yn),
						new Feature("SportBumper","yes",yn),
						new Feature("SportRing","yes",yn),
						new Feature("CruisControll","yes",yn),
						new Feature("ABS","yes",yn),
						new Feature("AC","yes",yn),
						new Feature("Metalic","yes",yn)
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
			if(stringarray.length == (totalFeatures +2)){
				Item item = new Item(stringarray[0], features);
				for(int i=1; i<totalFeatures;i++){
					if(stringarray[i].equals("0")){
						item.setFeatureValue(features[i].getName(), "no");
						if(stringarray[i].equals("1")){
							item.setFeatureValue(features[i].getName(), "yes");
						}
					}
					map.put(item, stringarray[stringarray.length-1]);
				}
			}
		}
		if(totalItems == (count)){
			return map;
		}else{
			System.out.println("Error, number of lines not equal ");
		}


		return null;}
}
