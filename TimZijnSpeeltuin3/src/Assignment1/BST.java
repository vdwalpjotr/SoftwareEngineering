package Assignment1;

public class BST<E> {
	
	protected TreeNode<E> root;
	protected int size = 0;
	
	public BST() {		
	}
	
	public BST(E[] objects) {
		for(int i = 0; i < objects.length; i++) {
			//insert(objects[i]);
		}
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}

}
