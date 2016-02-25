package classifier;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FileReader {
	
	public FeatureType yn = new FeatureType("01" ,new String[]{"0","1"});
	
	private Scanner input;
	private DecisionTree tree;
	private Feature[] featureNamen = new Feature[]
			{ new Feature("Turbo","0",yn),
					new Feature("EnginPower","0",yn),
					new Feature("SportBumper","0",yn),
					new Feature("SportRing","0",yn),
					new Feature("CruisControll","0",yn),
					new Feature("ABS","0",yn),
					new Feature("AC","0",yn),
					new Feature("Metalic","0",yn)
			};
	public FileReader(){
		tree = new DecisionTree(readTrainingSet("src/classifier/TestIncompleet.txt"), getMap());
		System.out.println(tree.toString());
	}
	
	public String getCategory(Item item){
		return tree.assignCategory(item);
	}
	
	public Feature[] fillFeatureList(int[] resultList) {
		Feature[] ft = featureNamen;
		
		for(int i = 0; i<ft.length; i++) {
			ft[i].setValue(""+resultList[i]);
		}
		
		return ft;
	}
	

	
//	List<String> featureList = new ArrayList<>();
//	featureList.add("Turbo");
	
	Map<String, FeatureType> mappie = new HashMap<String, FeatureType>();
	
	public Map<String, FeatureType> getMap(){
		mappie.put("Turbo", yn);
		mappie.put("EnginPower", yn);
		mappie.put("SportBumper", yn);
		mappie.put("SportRing", yn);
		mappie.put("CruisControll", yn);
		mappie.put("ABS", yn);
		mappie.put("AC", yn);
		mappie.put("Metalic", yn);
		return mappie;



	}

	public HashMap<Item, String> readTrainingSet(String pathToFile){
		File file = new File(pathToFile);
		HashMap<Item, String> map = new HashMap<Item, String>();
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

			//Item item = new Item(stringarray[0], features);
			
			String itemName = stringarray[0];
			Feature features[] = new Feature[totalFeatures];
			
			for(int i=0; i<totalFeatures;i++){

				features[i] = new Feature(featureNamen[i].getName(),stringarray[i+1], yn);

			//	Item item = new Item("naam", features);

			}
			map.put(new Item(itemName, features), stringarray[stringarray.length-1]);
		}
		return map;
	}
}