package avl;

public class AvlNode <K, V> {
	AvlNode <K,V> parent;
	AvlNode <K, V> left;
	AvlNode <K, V> right;
	K key;
	V value;
	int balance;
	int height;
	
	public AvlNode(){
		this.value=null;
	}
	
	public AvlNode (K key, V value, AvlNode <K, V> parent){
		this.parent = parent;
		left = null;
		right = null;
		this.key=key;
		this.value=value;
		this.balance=0;
	}
	
	public void setParent (AvlNode <K, V> parent){
		this.parent=parent;
	}
	
	public AvlNode <K, V> getParent (){
		return parent;
	}
	
	public void setBalance(int balance){
		this.balance=balance;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void setLeft(AvlNode<K, V> left){
		this.left=left;
	}
	
	public AvlNode<K, V> getLeft(){
		return left;
	}
	
	public void setRight(AvlNode<K, V> right){
		this.right=right;
	}
	
	public AvlNode<K, V> getRight(){
		return right;
	}
	
	public boolean hasLeft(AvlNode<K,V> node){
		return node.left!=null;
		
	}
	
	public boolean hasRight(AvlNode<K,V> node){
		return node.right!=null;
	}
	
	public K getKey(){
		return key;
	}
	
	public void setKey(K key){
		this.key=key;
	}
	
	public V getValue(){
		return value;
	}
	
	public void setValue(V value){
		this.value=value;
		
	}
	
	public AvlNode<K, V> findMax(){
		AvlNode<K, V> current=this;
		while(current.getRight()!=null){
			current=current.getRight();
		}
		return current;
		
	}
	
	public AvlNode<K, V> findMin(){
		AvlNode<K, V> current=this;
		while(current.getLeft()!=null){
			current=current.getLeft();
		}
		return current;
	}
}
 