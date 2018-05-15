package avl;

/**
 * Instances of implementing classes provide (a reduced set of) functionality
 * similar to the java-standard-library collection {@link java.util.SortedMap}.
 * 
 * @param <V>
 *
 * @param <K>
 *            the key type.
 * @param <V>
 *            the value type.
 * @param <K>
 */
public interface SortedMap<V, K> extends Iterable<V> {

    /**
     * Checks if the map is empty.
     * 
     * @return {@code true} if the map is empty, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Clears the map, removing all entries.
     * 
     */
    void clear();

    /**
     * Checks if the map contains an entry for the given key.
     * 
     * @param key
     *            the key to search for.
     * @return {@code true} if the map contains the key, {@code false}
     *         otherwise.
     */
    boolean containsKey(K key);

    /**
     * Gets the value mapped to the given key.
     * 
     * @param key
     *            the key to loop up.
     * @return the value mapped to the given key, or {@code null} if no entry
     *         with the given key exists.
     */
    V get(K key);

    /**
     * Maps the given value to the given key, replacing a previous value mapped
     * to that key, if such a mapping existed.
     * 
     * @param key
     *            the key.
     * @param value
     *            the value.
     * @return the value previously mapped to the key, or {@code null} if no
     *         previous entry with the given key exists.
     */

    V put(K key, V value);

    /**
     * Removes the entry with the given key from the map.
     * 
     * @param key
     *            the key to remove.
     * @return the value mapped to the key, or {@code null} if no entry with the
     *         given key exists.
     */
    V remove(K key);

    @Override
    String toString();
}
