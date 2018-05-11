import java.util.Comparator;
import java.util.Iterator;

public class AvlTreeMap<K, V> implements SortedMap {
	
	AvlNode<K,V> root;
	Comparator <K> comp;
	
	public AvlTreeMap (Comparator<K> comp){
		this.root = new AvlNode<K,V>();
		root.value=null;
		root.parent=null;
		this.comp=comp;
	}
	
	public AvlNode<K, V> findMax(){
		AvlNode<K, V> current=root;
		while(current.getRight()!=null){
			current=current.getRight();
		}
		return current;
		
	}
	
	public AvlNode<K, V> findMin(){
		AvlNode<K, V> current=root;
		while(current.getLeft()!=null){
			current=current.getLeft();
		}
		return current;
	}
	
	
	
	public boolean hasLeft(AvlNode<K,V> node){
		return node.left!=null;
		
	}
	
	public boolean hasRight(AvlNode<K,V> node){
		return node.right!=null;
	}
	
	public AvlNode<K,V> getLeft(AvlNode<K,V> node){
		return node.left.get();
	}
	
	public AvlNode<K, V> getRight(AvlNode<K,V> node){
		return node.right.get();
	}
	
	public AvlNode<K,V> PreOrder (AvlNode<K,V> node){
		if (node.hasChildre()==false){
			System.out.println("Error!");
		} else { 
			AvlNodeIterator myIterator=new AvlNodeIterator();
			for (AvlNode<K,V> n: myIterator){
				System.out.println(node.get());
				PreOrder(node.left);
				PreOrder(node.right);
			}
		} 
	}
	
	public boolean hasChildren(AvlNode<K,V> currentNode){
		return currentNode.hasNext();
	}

	@Override
	public Iterator<V> iterator() {
		return new AvlNodeIterator<V>();
	}

	@Override
	public boolean isEmpty() {
		if (this.get()!=null){
		return true;
		}
	}

	@Override
	public void clear() {
		root=null;
		}
	
		
	}

	@Override
	public boolean containsKey(Object key) {
		
		return false;
	}

	@Override
	public Object get(Object key) {
		return ;
	
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private AvlNode<K.V> findNode(K key){
		
	public static <K extends Comparalble<K>, V> SortedMap <K,V> create (){
		return create (K::compareTo);
	}

}
