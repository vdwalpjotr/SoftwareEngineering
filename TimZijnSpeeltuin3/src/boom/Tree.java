
package boom;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;


public class Tree {
	private DefaultMutableTreeNode root = null;
	//	private JTree tree;
	public Tree(){
		root = new DefaultMutableTreeNode("person");
		createNodes(root);		
	}
	public DefaultMutableTreeNode getRoot(){
		return root;
	}
	private void createNodes(DefaultMutableTreeNode root){
		DefaultMutableTreeNode parent = null;
		DefaultMutableTreeNode child = null;
		parent = new DefaultMutableTreeNode("Employee");
		root.insert(parent, 0);
		child = new DefaultMutableTreeNode("sales_rep");
		parent.insert(child, 0);
		child = new DefaultMutableTreeNode("engineer");
		parent.insert(child, 1);
		parent = new DefaultMutableTreeNode("customer");
		root.insert(parent, 1);
		child = new DefaultMutableTreeNode("us_customer");
		parent.insert(child, 0);
		child = new DefaultMutableTreeNode("non_us_customer");
		parent.insert(child, 1);
		//Get "us_customer"
		parent = parent.getFirstLeaf();
		child = new DefaultMutableTreeNode("local_customer");
		parent.insert(child, 0);
		child = new DefaultMutableTreeNode("regional_customer");
		parent.insert(child, 1);
	}
	
	public void postOrder() {
		Enumeration e = root.postorderEnumeration();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
	
	public void preOrder() {
		Enumeration e = root.preorderEnumeration();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
	
	public void bOrder() {
		Enumeration e = root.breadthFirstEnumeration();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
	
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.bOrder();
		System.out.println();
		tree.preOrder();
		System.out.println();
		tree.postOrder();
	}
}

