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


//		//if (last != null) {// schauen ob ich beim min/start bin
//			last = next; // last wird dem dem gespeicherten Wert vom vorherigen
//							// Current belegt
//			// neues current
//			// wenn ich im lnken Knpten war ist kmein neues current der parent
//			if (current.getParent().getLeft() == last) {
//				next = next.getParent();
//
//				// wenn ich einen rechten Subtree habe ist das neue current das
//				// Minimum davon
//			} else if (current.getParent().getRight() != null) {
//				next = current.getParent().getRight().findMin();
//
//				// und sonst wenn ich links schon hab und mein last der parnent
//				// ist und es keinen rechten Subtree gibt
//
//			} else if (current.getRight() == last && current.getParent() != null) {
//				next = current.getParent();
//			} else {
//				next = null;
//			}
////		} else {
////			last = next;
////		}

	}
}
