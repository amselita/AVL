package avl;

import java.util.Comparator;

/**
 *initializes a string comperator independent of the case
 */
public class MyComparator implements Comparator<String> {
    
    /**
     * compares key1 to key2 lexicographically
     * @return integer -1 if key1 is lexicographically smaller than key2,
     *              0 if key1 and key2 are lexicographically the same
     *              1 if key1 is lexicographically bigger than key 2
     * @param String key1 which is compared to key2        
     * @param String key2 which is compared by key1     
     */
    @Override
    public int compare(String key1, String key2) {
        return key1.compareToIgnoreCase(key2);
    }

}
