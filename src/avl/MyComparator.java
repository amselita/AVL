package avl;
import java.util.Comparator;

public class MyComparator implements Comparator<String> {
	
	@Override
	public int compare(String key1, String key2) {
		return key1.compareTo(key2);	
	}

}
