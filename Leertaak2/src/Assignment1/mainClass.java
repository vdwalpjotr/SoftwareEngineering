package Assignment1;

import java.util.Stack;

public class mainClass {
	
	public static void main(String[] args) {
		
	}
	
	public void InOrder(BST<String> bst) {		
		// INORDER
		TreeNode<String> current = bst.getRoot();
		Stack<TreeNode<String>> st = new Stack<TreeNode<String>>();
		
		while(current != null || !st.empty()) {
			if(current != null) {
				st.push(current);
				current = current.left;
			} 
			else {
				current = st.pop();
				System.out.println(current.toString());
				current = current.right;
			}
		}
	}
	
	public void PreOrder(BST<String> bst) {
		// PREORDER
		TreeNode<String> current = bst.getRoot();
		Stack<TreeNode<String>> st = new Stack<TreeNode<String>>();
		
		while(current != null || !st.empty()) {
			if(current != null) {
				System.out.println(current.toString());
				st.push(current);
				current = current.left;
				
			}
			else {
				current = st.pop();
				current = current.right;
			}
		}
	}
	
	public void PostOrder(BST<String> bst) {
		// POSTORDER
		TreeNode<String> current = bst.getRoot();
		Stack<TreeNode<String>> st = new Stack<TreeNode<String>>();
		
		while(current != null || !st.empty()) {
			if(current != null) {
				st.push(current);
				current = current.left;
			} 
			else {
				current = st.pop();
				if(current.secondPop){
					st.push(current);
					current = current.right;
				} 
				else {
					System.out.println(current.toString());
					current.secondPop = true;
					current = st.pop();
				}
			}
		}
	}
	
}
