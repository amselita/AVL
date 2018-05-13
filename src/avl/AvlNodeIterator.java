package avl;
import java.util.Iterator;


public class AvlNodeIterator<K,  V> implements Iterator<AvlNode<K, V>> {
	AvlNode<K, V> next;

	
	public AvlNodeIterator(AvlNode<K, V> min) {
		next=min;
	}
	
	@Override
	public boolean hasNext(){
		//return (current.getLeft()!=null|| current.getRight()!=null);
		return next != null;
	}

	/**
	 * holt logisch nächstes Element in der Reihenfolge des trees
	 * 
	 */
	@Override
	public AvlNode<K, V> next() {
		AvlNode<K, V> current = next;
		
		if (current.getRight()!=null){
			next=current.getRight().findMin();
		}
		else { 
			AvlNode<K, V> pointer=current;
			
			if ( pointer.getParent().getLeft()==pointer){
				next=pointer.getParent();
			} 
			else {
				while (pointer.getParent()!=null && pointer.getParent().getRight()==pointer){
					pointer=pointer.getParent();
				}
				
				next=pointer.getParent();
			}
		}
		return current;
	}
}
