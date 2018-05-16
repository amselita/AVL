package avl;
/**
 * 
 *A Node in a tree.
 * @param <K> the key, which is of generic type
 * @param <V> the value, which is of generic type
 */
public class AvlNode<K,V> {
    
    /**
     * pointer to the parent node
     */
    AvlNode<K,V> parent;
    
    /**
     * pointer to the left node or left subtree
     */
    AvlNode<K,V> left;
    
    /**
     * pointer to the right node or right subtree
     */
    AvlNode<K,V> right;
    
    /**
     * the varialbe storing the key
     */
    K key;
    
    /**
     * the variable storing value
     */
    V value;
    
    /**
     * the variable storing the balance of the node
     */
    int balance;
   
    /**
     * Node constructor creating a node an given node as parents, no children, the
     * given key and value and a default balance of
     * @param key of the node
     * @param value of the key
     * @param parent of the node
     */
    public AvlNode(K key, V value, AvlNode<K,V> parent) {
        this.parent = parent;
        left = null;
        right = null;
        this.key = key;
        this.value = value;
        this.balance = 0;
    }

    public void setParent(AvlNode<K,V> parent) {
        this.parent = parent;
    }

    public AvlNode<K,V> getParent() {
        return parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setLeft(AvlNode<K,V> left) {
        this.left = left;
    }

    public AvlNode<K,V> getLeft() {
        return left;
    }

    public void setRight(AvlNode<K,V> right) {
        this.right = right;
    }

    public AvlNode<K,V> getRight() {
        return right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;

    }

    /**
     * Returns the maximum node sorted by lexicographical order
     * @return the lexicographically biggest node
     */
    public AvlNode<K,V> findMax() {
        AvlNode<K,V> current = this;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;

    }

    /**
     * Returns the minumum node sorted by lexicographical order
     * @return the lexicographically smallest node
     */
    public AvlNode<K,V> findMin() {
        AvlNode<K,V> current = this;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
}
