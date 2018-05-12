import java.util.Iterator;


public class AvlNodeIterator<K,  V> implements Iterator<AvlNode<K, V>> {
	AvlNode<K, V> next;
	AvlNode<K, V> last;

	
	public AvlNodeIterator(AvlNode<K, V> min) {
		next=min;
		last=null;
	}
	
	@Override
	public boolean hasNext(){
		//return (current.getLeft()!=null|| current.getRight()!=null);
		return next != null;
	}

	/**
	 * das in next gespeicherte next wird ausgegeben
	 * generates das next für den nächsten next aufruf in der vairale next ab
	 * für den ersten aufruf ist das min schon als next gesetzt
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
