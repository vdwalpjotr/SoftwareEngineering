
package boom;

import javax.swing.JTree;
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
		System.out.println(parent.getChildAt(1));
	}
	public static void main(String[] args){
		Tree tree = new Tree();
		
	}
}

