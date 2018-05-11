import java.util.Iterator;

//Iterator über Werte, nur V

public class AvlNodeIterator<K,  V> implements Iterator<AvlNode<K, V>> {
	AvlNode<K, V> current=root;
	
	
		@Override
		public boolean hasNext(AvlNode<K, V> node){
			if (current.hasLeft()==true|| current.hasRight()==true)
			return true;
		}
		@Override
			public AvlNode<K, V> next(){
			
			return 
		}
}
