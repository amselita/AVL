import java.util.Iterator;

public class AvlTreeMap<K, V> implements SortedMap {
	
	AVLNode <K,V> parent;
	AVLNode <K, V> left;
	AVLNode <K, V> right;
	AVLNode <K,V> root;
	K key;
	V value;
	int balance;
	
	
	public AvlTreeMap (){
		
		
	}
	
	public booblean hasChildren(AVLNode currentNode){
		
	}

	@Override
	public Iterator iterator() {
		AVLNode root=this;
		System.out.println((this.get(root));
		
		if (left.get()!=null){
			// while (i=0; this.hasChildren==true){
			
				System.out.println(", "+get(root));
				root.left=root;
				root.iterator();
				
			else {
				if (right.get()!=null){
					right.get()	
					System.out.println(", "+right.get());
					
					}
		
		

				
		}
			
			
			
		return null;
	}

	@Override
	public boolean isEmpty() {
		this.get()=null;
		return true;
	}

	@Override
	public void clear() {
		this.put(key, value){
			value=null;
		}
	
		
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
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

}
