package avl;
import java.util.Comparator;
import java.util.Iterator;

public class AvlTreeMap<K, V> implements SortedMap<V, K> {
	
	public static void main(String...strings) {
		Comparator<String> stringComparator = new Comparator<String>() {
			@Override
			public int compare(String eins, String zwei) {
				return eins.compareTo(zwei) * -1;
			}
		};
		AvlTreeMap<String, Body> treeMap = new AvlTreeMap<String, Body>(stringComparator);
	}
	
	//TODO: private
	public AvlNode<K,V> root;
	public Comparator <K> comp;
	
	public AvlTreeMap (Comparator<K> comp){
		this.root = new AvlNode<K,V>();
		root.value=null;
		root.parent=null;
		this.comp=comp;
	}
	
	public AvlNode<K, V> findMax(){
		return root.findMax();
		
	}
	
	public AvlNode<K, V> findMin(){
		return root.findMin();
	}
	
	
//	public AvlNode<K,V> getLeft(AvlNode<K,V> node){
//		return node.left.get();
//	}
//	
//	public AvlNode<K, V> getRight(AvlNode<K,V> node){
//		return node.right.get();
//	}
	
//	public AvlNode<K,V> PreOrder (AvlNode<K,V> node){
//		if (node.hasChildre()==false){
//			System.out.println("Error!");
//		} else { 
//			AvlNodeIterator myIterator=new AvlNodeIterator();
//			for (AvlNode<K,V> n: myIterator){
//				System.out.println(node.get());
//				PreOrder(node.left);
//				PreOrder(node.right);
//			}
//		} 
//	}
	
//	public boolean hasChildren(AvlNode<K,V> currentNode){
//		return currentNode.hasNext();
//	}

	@Override
	public Iterator<V> iterator() {
		return new AvlNodeIterator<K, V>(findMin());
	}

	@Override
	public boolean isEmpty() {
		return (root.getLeft()==null && root.getRight()==null);
	}

	@Override
	public void clear() {
		root=null;
	}

	@Override
	public boolean containsKey(K key){
		return contains(root,key);
		
	}

	@Override
	public V get(Object key) {
		return null;
		//TODO: TOD TOD TOD
	}
	
	/**
	 * utility method for finding the height of to integers
	 * @param a
	 * @param b
	 * @return
	 */
	
	public int max(int a, int b) {
        return (a > b) ? a : b;
	}
	
	public int height(AvlNode<K, V> N) {
	        if (N == null)
	            return 0;
	 
	        return N.height;
	    }
	 
	//    // node is by 2 higher than its sibling=anderer subtree-> Übergewicht links, Höhe linker subtree=2
	//node ist die Node mit Balancefacotr 2
	private void rotateLL(AvlNode<K, V> node){
		//u.getParent().setRight(u.getParent().getParent());
		//oder
		node.getLeft().setRight(node);
		
	}
	// node is the node with balancefactor 2, 2 higher then sbiing subtree
	private void rotateRR (AvlNode<K, V> node){
		node.getRight().setLeft(node);
		
		node.height= 1 + max(height(node.left),
                height(node.right));
	}

	@Override
	public V put(K key, V value) {
		return insert(root, key, value);
	}
		
	public V insert (AvlNode<K, V> current, K key, V value){
		if (current==null){
			current=new AvlNode<>(key, value, null);
			return null;
		} else if (current.getKey()==key){
			current=new AvlNode<>(key, value, null);
			return current.getValue();
		}
	
		int compared = comp.compare(key, current.getKey());
	
		if (compared==0){
			current.setKey(key);
		}
		else if(compared<0){
			current=current.getLeft();
			insert(current,key, value);
		}
		else{
			current=current.getRight();
			insert(current,key, value);
		}
		return null;
		
	}
		
		
		
//		while (current.getRight()!=null || current.getLeft()!=null){
//			if ((comp.compare(toput.getKey(),current.getKey())==-1){//key < current.getKey(){
//				current=current.getLeft();
//			} else current=current.getRight();
//		}
//		toput.setParent(current);
//		if ((comp.compare(current.getKey(),toput.getKey())==-1){
//			current.setLeft(toput);
//		} else current.setRight(toput);
//			
//		toput.height = 1 + max(height(toput.left),
//                height(toput.right));
//		current=toput; //??
//		
//		while (current.hasNext()==true){
//			current.height = max(height(current.left),
//	                height(current.right));
//					current=current.next();
//		}
//		
//		
//		return null;
//	}
//	

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//current ist start/wo man sich befindet, key der zu suchenden node
	private boolean contains (AvlNode<K,V> current, K key){
		
		
		if (key==null) return false;
		
		int compared = comp.compare(current.getKey(), key);
		
		if (compared < 0) {
			current=current.getLeft();
			return contains(current, key);
		}
		if (compared > 0){
			current=current.getRight();
			return contains(current, key);
		}
		return true;
	}
//		
//	public static <K extends Comparalble<K>, V> SortedMap <K,V> create (){
//		return create (K::compareTo);
//	}

}
