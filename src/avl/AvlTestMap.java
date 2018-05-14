package avl;
import java.util.Iterator;

public class AvlTestMap extends AvlTreeMap<String, Integer> {
	public AvlTestMap (){
		super(new MyComparator());
		
		root = new AvlNode<String, Integer>("Grashalm", 5, null);
		AvlNode<String, Integer> left = new AvlNode<String, Integer>("blume", 4, root);
		root.setLeft(left);
		AvlNode<String, Integer> right = new AvlNode<String, Integer>("stein", 6, root);
		root.setRight(right);
		
		
	}

	public static void main(String[] args) {
		// generate test map
		AvlTestMap testMap = new AvlTestMap();
		
		// print keys
		Iterator<Integer> iterator = testMap.iterator();
		testMap.put("Grashalm", 11);
		System.out.println(testMap.containsKey("ast"));
		System.out.println(testMap.containsKey("blume"));
		while(iterator.hasNext() == true) {
			System.out.println("Value: " + iterator.next());
		
		}
	}

}
