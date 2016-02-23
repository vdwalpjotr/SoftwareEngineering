package Assigment14.test;
import Assigment14.classifier.*;
import junit.framework.TestCase;



public class TestClassifier2 extends TestCase {

	public TestClassifier2(String arg0) {
		super(arg0);
	}

    private DecisionTree buildTree(){
		Node root = new Node("TC");
		
		Node c1 = new Node("AC");
		Node c2 = new Node("AC");
		root.addChild("yes",c1);
		root.addChild("no",c2);
		
		Node n1=new Node("ABS");
		Node n2=new Node("ABS");
		Node n3=new Node("ABS");
		Node n4=new Node("ABS");
		c1.addChild("yes",n1);
		c1.addChild("no",n2);

		c2.addChild("yes",n3);
		c2.addChild("no",n4);
		
		// leaves
		Node l1 = new Node("really high");
		Node l2 = new Node("high");
		Node l3 = new Node("high");
		Node l4 = new Node("medium");
		Node l5 = new Node("high");
		Node l6 = new Node("medium");
		Node l7 = new Node("medium");
		Node l8 = new Node("low");

		n1.addChild("yes",l1);
		n1.addChild("no",l2);

		n2.addChild("yes",l3);
		n2.addChild("no",l4);

		n3.addChild("yes",l5);
		n3.addChild("no",l6);

		n4.addChild("yes",l7);
		n4.addChild("no",l8);
		
		return new DecisionTree(root);
    }
	public void testCategory(){
		
		DecisionTree dt = buildTree();

		FeatureType yn = new FeatureType("YesNo"
						,new String[]{"yes","no"});

		Feature[] features = new Feature[]
		{ new Feature("TC","yes",yn),
		  new Feature("AC","yes",yn),
		  new Feature("ABS","yes",yn)
		};
		
		Item item = new Item("car",features);
		
		String category = dt.assignCategory(item);
		assertEquals("really high",category);

		item.setFeatureValue("TC","no");
		category = dt.assignCategory(item);
		assertEquals("high",category);
		
		item.setFeatureValue("AC","no");
		category = dt.assignCategory(item);
		assertEquals("medium",category);

		item.setFeatureValue("ABS","no");
		category = dt.assignCategory(item);
		assertEquals("low",category);
	}
}
