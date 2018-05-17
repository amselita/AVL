package avl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * a map of key and a value stored in an avl-tree
 *
 * @param <K> the key
 * @param <V> the value
 */
public class AvlTreeMap<K,V> implements avl.SortedMap<V,K> {
    
    /**
     * pointer to the root node
     */
    private AvlNode<K,V> root;
    
    /**
     * a comperator object
     */
    private Comparator<K> comp;

    /**
     * constructor of a new tree-map
     * @param comp a comperator object
     */
    public AvlTreeMap(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    public AvlNode<K,V> findMax() {
        return root.findMax();
    }

    public AvlNode<K,V> findMin() {
        if(root==null){
            return null;
        } else {
           return root.findMin();
        }
    }
    
    /**
     * iterates over the keys of a tree 
     * @return Iterator<V>
     */
    @Override
    public Iterator<V> iterator() {
        return new AvlNodeIterator<K,V>(findMin());
    }

    @Override
    public boolean isEmpty() {
        return root == null;

    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return find(root, key) != null;

    }
    
    /**
     * finds the value of a key
     * @param K the key which value is wanted
     * @returm V the value of the given key
     */
    @Override
    public V get(K key) {
        AvlNode<K,V> current=find(root, key);
        if(current!=null){
            return current.getValue();
        } else {
            return null;
        }
    }

    /**
     * utility method for finding the height of to integers
     * 
     * @param a
     * @param b
     * @return
     */

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

//    public int height(AvlNode<K,V> N) {
//        if (N == null)
//            return 0;
//
//        return N.height;
//    }

    // // node is by 2 higher than its sibling=anderer subtree-> Übergewicht
    // links, Höhe linker subtree=2
    // node ist die Node mit Balancefacotr 2
//    private void rotateLL(AvlNode<K,V> node) {
//        // u.getParent().setRight(u.getParent().getParent());
//        // oder
//        node.getLeft().setRight(node);
//
//    }

    // node is the node with balancefactor 2, 2 higher then sbiing subtree
//    private void rotateRR(AvlNode<K,V> node) {
//        node.getRight().setLeft(node);
//
//        node.height = 1 + max(height(node.left), height(node.right));
//    }

    private void updateBalance(AvlNode<K, V> current){
        AvlNode<K,V> parent=current.getParent();
//        current.setBalance(0); in insert machen
           if(parent.getBalance()==0){
               if(isLeftChild(current)){
                   parent.setBalance(-1);
               }else {
                   parent.setBalance(1);
               }
           } else if(parent.getBalance()==1 || parent.getBalance()==-1){
                parent.setBalance(0);
           }
        current=parent;
        if (parent.getParent() != null){
            updateBalance(parent);        
        }
    }      
    
 private void updateBalanceAfterRemove(){
     AvlNode<K, V> current=root.findMin();
     AvlNode<K,V> maximum=root.findMax();
     while(current!=maximum){
         updateBalance(current);
     }
    }
    
    @Override
    public V put(K key, V value) {
        return insert(root, key, value);
    }
    
    /**
     * utility method inserting a node in the order of the tree by
     * using a comparator, which returns null if the inserted key 
     * is equal compared to the current key, a value smaller than 0 
     * if the inserted node is smaller compared to the current
     *  node and a value bigger than 0 if the inserted key is 
     *  bigger compared to the current key
     * @param current node from the insertion should start
     * @param key of the node to insert
     * @param value of the node to insert
     * @return V null if the key already existed, the old value if the key already existed
     */
    private V insert(AvlNode<K,V> current, K key, V value) {
        AvlNode< K, V> insertedNode=new AvlNode<K,V>(key, value, root);
        //check if tree is empty, if yes, inserted node becomes root
        if (isEmpty() == true) {
            root = new AvlNode<K,V>(key, value, null);
            //root.setBalance(0);
            return null;
        }
        int compared = comp.compare(key, current.getKey());
        //key to insert is equal compared to the current key, current value is 
        //replaced by the value to insert
        if (compared == 0) {
            V oldvalue = current.getValue();
            current.setValue(value);
            return oldvalue;
         //key to insert is smaller compared to the current key,
         //the left child of current becomes the new current node
        } else if (compared < 0) {
            if (current.getLeft() != null) {
                current = current.getLeft();
                insert(current, key, value);
            } else {
                current.setLeft(new AvlNode<K,V>(key, value, current));
            }
         //key to insert is bigger compared to the current key,
         //the right child of current becomes the new current node
        } else {
            if (current.getRight() != null) {
                current = current.getRight();
                insert(current, key,value);
            } else {
                current.setRight(new AvlNode<K,V>(key, value, current));
            }
        }
        current.setBalance(0);
        updateBalance(insertedNode);
        return null;
    }
    
   

//    private void updateHeight(AvlNode<K,V> toUpdate) {
//        toUpdate.getParent().setHeight(toUpdate.getHeight() + 1);
//
//    }

    /**
     * utility method checking weather a node is the left or right child of its parent 
     * @param node of which should be checked
     * @return boolean {@code true} if the node is the left child of its parent
     *                 {@code no} if the node is the right child of its parent
     */
    private boolean isLeftChild(AvlNode<K,V> node) {
        return node.getParent().getLeft() == node;
    }

    @Override
    public V remove(K key) {
        AvlNode<K,V> toRemove;
        toRemove=find(root, key);
        AvlNode<K,V> left=toRemove.getLeft();
        AvlNode<K,V> right = toRemove.getRight();
        if (toRemove != null) {
            V value;
            value = toRemove.getValue();
            AvlNode<K,V> parent = toRemove.getParent();
            if (left == null && right == null) {
                //node has no children
                if (parent == null) {
                    //node is root
                    root = null;
                } else if (isLeftChild(toRemove)) {
                    //node is a left child
                    parent.setLeft(null);
                } else {
                    //node is a right child
                    parent.setRight(null);
                }
            } else if (left != null && right == null) {
                //node has only a left child
                if (parent == null) {
                    //node is root 
                    root = left;
                    left.setParent(null);
                } else if (isLeftChild(toRemove) == true) {
                    //node is left child
                    parent.setLeft(left);
                    left.setParent(parent);
                } else {
                    //node is right child
                    parent.setRight(left);
                    left.setParent(parent);
                   // right.setParent(parent);
                }
            } else if (left == null && right != null) {
                // node to be removed has only a right child  
                AvlNode<K,V> minimumRight;
                minimumRight=toRemove.getRight().findMin();
                // node is the root 
                if (parent == null) {
                    root = minimumRight;
                    if ((minimumRight != right && minimumRight.getRight() != null )){
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(minimumRight.getRight());
                        minimumRight.getRight().setParent(minimumRight.getParent());
                        
                    } else if (minimumRight==right && minimumRight.getRight() == null ){
                        minimumRight.setRight(null);
                    } else {
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(null);
                    }
                   // node is left child
                } else if (isLeftChild(toRemove)) {
                    parent.setLeft(minimumRight);
                    minimumRight.setParent(parent);
                    //minimum has a right child
                    //minimum has no right child and is itself the
                    if ((minimumRight != right && minimumRight.getRight() != null )){ 
                        //right child of the node
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(minimumRight.getRight());
                        minimumRight.getRight().setParent(minimumRight.getParent());
                        
                    } else if (minimumRight==right && minimumRight.getRight() == null ){
                        minimumRight.setRight(null);
                    } else {
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(null);
                    }
                } else {
                    // node is left child
                    parent.setRight(minimumRight);
                    if ((minimumRight != right && minimumRight.getRight() != null )){
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(minimumRight.getRight());
                        minimumRight.getRight().setParent(minimumRight.getParent());
                        
                    } else if (minimumRight==right && minimumRight.getRight() == null ){
                        minimumRight.setRight(null);
                    } else {
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(null);
                    }
                }
            } else if (left != null && right != null) {
                //node has a left child and a right child
                AvlNode<K,V> minimumRight;
                minimumRight=toRemove.getRight().findMin();
                if (parent == null) {
                    //node is the root
                    AvlNode<K,V> oldRoot = root;
                    root = minimumRight;
                    //minimum has a right child
                    if ((minimumRight != right && minimumRight.getRight() != null )){
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(minimumRight.getRight());
                        minimumRight.getRight().setParent(minimumRight.getParent());
                        
                    } else if (minimumRight==right && minimumRight.getRight() == null ){
                        minimumRight.setRight(null);
                    } else if(minimumRight!=right && minimumRight.getRight()==null){
                        minimumRight.setRight(right);
                        right.setParent(minimumRight);
                        minimumRight.getParent().setLeft(null);
                    }
                    minimumRight.setLeft(oldRoot.getLeft());
                    oldRoot.getLeft().setParent(minimumRight);
                    minimumRight.setParent(null);
                } else if (isLeftChild(toRemove)) {
                    //node is a left child
                    parent.setLeft(minimumRight);
                    minimumRight.setLeft(left);
                    if ((minimumRight != right && minimumRight.getRight() != null )){
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(minimumRight.getRight());
                        minimumRight.getRight().setParent(minimumRight.getParent());
                        
                    } else if (minimumRight==right && minimumRight.getRight() == null ){
                        minimumRight.setRight(null);
                    } else {
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(null);
                    }
                } else {
                    //node is a right child
                    parent.setRight(minimumRight);
                    minimumRight.setLeft(left);
                    if ((minimumRight != right && minimumRight.getRight() != null )){
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(minimumRight.getRight());
                        minimumRight.getRight().setParent(minimumRight.getParent());
                    } else if (minimumRight==right && minimumRight.getRight() == null ){
                        minimumRight.setRight(null);
                    } else {
                        minimumRight.setRight(right);
                        minimumRight.getParent().setLeft(null);
                    }
                }
            }
            //TODO
            toRemove.setLeft(null);
            toRemove.setRight(null);
            toRemove.setParent(null);
            // updateBalance();
            return value;
        } else {
            // key not found
            return null;
        }
 }

    public AvlNode<K,V> find(AvlNode<K,V> current, K key) {
        if (current == null) {
            return null;
        }

        int compared = comp.compare(key, current.getKey());

        if (compared < 0) {
            current = current.getLeft();
            return find(current, key);
        } else if (compared > 0) {
            current = current.getRight();
            return find(current, key);
        } else {
            return current;
        }
    }
   
    private boolean hasOnlyLeftChild(AvlNode<K, V> node){
        return (node.getLeft()!=null && node.getRight()==null);
    }
    
    private boolean hasOnlyRightChild(AvlNode<K, V> node){
        return (node.getLeft()==null && node.getRight()!=null);
    }
    
    @Override
    public String toString(){
        return toStringHelper(root);
        
    }
    private String toStringHelper(AvlNode<K,V> current){    
        //AvlNodeIterator<K,V> iterator= new AvlNodeIterator<>(current);
        String string = "";
        // last node to print is reached
        //tree is empty
        if (current == null){
            string="()";
        } else { 
            string="(["+current.getBalance()+"] "+
                    current.getKey()+"="+current.getValue().toString()+" "+toStringHelper(current.getLeft())
                    +" "+toStringHelper(current.getRight())+")";
        }
        return string;
    }				
}
