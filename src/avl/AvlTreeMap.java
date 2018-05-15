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
public class AvlTreeMap<K, V> implements SortedMap<V, K> {
    
    /**
     * pointer to the root node
     */
    public AvlNode<K, V> root;
    
    /**
     * a comperator object
     */
    public Comparator<K> comp;
    // TODO private machen

    /**
     * constructor of a new tree-map
     * @param comp a comperator object
     */
    public AvlTreeMap(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    public AvlNode<K, V> findMax() {
        return root.findMax();

    }

    public AvlNode<K, V> findMin() {
        return root.findMin();
    }

    // public AvlNode<K,V> getLeft(AvlNode<K,V> node){
    // return node.left.get();
    // }
    //
    // public AvlNode<K, V> getRight(AvlNode<K,V> node){
    // return node.right.get();
    // }

    // public AvlNode<K,V> PreOrder (AvlNode<K,V> node){
    // if (node.hasChildre()==false){
    // System.out.println("Error!");
    // } else {
    // AvlNodeIterator myIterator=new AvlNodeIterator();
    // for (AvlNode<K,V> n: myIterator){
    // System.out.println(node.get());
    // PreOrder(node.left);
    // PreOrder(node.right);
    // }
    // }
    // }

    // public boolean hasChildren(AvlNode<K,V> currentNode){
    // return currentNode.hasNext();
    // }
    
    /**
     * iterates over the keys of a tree 
     * @return Iterator<V>
     */
    @Override
    public Iterator<V> iterator() {
        return new AvlNodeIterator<K, V>(findMin());
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
        AvlNode<K,V> current;
        current=root;
        find(current, key);
        return current.getValue();
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

    public int height(AvlNode<K, V> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // // node is by 2 higher than its sibling=anderer subtree-> Übergewicht
    // links, Höhe linker subtree=2
    // node ist die Node mit Balancefacotr 2
    private void rotateLL(AvlNode<K, V> node) {
        // u.getParent().setRight(u.getParent().getParent());
        // oder
        node.getLeft().setRight(node);

    }

    // node is the node with balancefactor 2, 2 higher then sbiing subtree
    private void rotateRR(AvlNode<K, V> node) {
        node.getRight().setLeft(node);

        node.height = 1 + max(height(node.left), height(node.right));
    }

    @Override
    public V put(K key, V value) {
        return insert(root, key, value);
    }
    
    /**
     * utility method inserting a node in the order of the tree
     * @param current node from the insertion should start
     * @param key of the node to insert
     * @param value of the node to insert
     * @return V null if the key already existed, the old value if the key already existed
     */
    private V insert(AvlNode<K, V> current, K key, V value) {
        if (isEmpty() == true) {
            root = new AvlNode<K, V>(key, value, null);
            return null;
        }
        int compared = comp.compare(key, current.getKey());
        if (compared == 0) {
            V oldvalue = current.getValue();
            current.setValue(value);
            return oldvalue;
        } else if (compared < 0) {
            if (current.getLeft() != null) {
                current = current.getLeft();
                insert(current, key, value);
            } else {
                current.setLeft(new AvlNode<K, V>(key, value, current));
            }
        } else {
            if (current.getRight() != null) {
                current = current.getRight();
                insert(current, key, value);
            } else {
                current.setRight(new AvlNode<K, V>(key, value, current));
            }
        }
        return null;
    }

    private void updateHeight(AvlNode<K, V> toupdate) {
        toupdate.getParent().setHeight(toupdate.getHeight() + 1);

    }

    //

    /**
     * utility method to check weather a node is the left or the right child of
     * its parent
     */

    /**
     * utility methode checking weather a node is the left or right child of its parent 
     * @param node of which 
     * @return
     */
    private boolean isLeftChild(AvlNode<K, V> node) {
        return node.getParent().getLeft() == node;
    }

    @Override
    public V remove(K key) {
        AvlNode<K, V> toRemove;
        toRemove = find(root, key);

        if (toRemove != null) {
            V value;
            value = toRemove.getValue();
            AvlNode<K, V> parent = toRemove.getParent();
            if (toRemove.getLeft() == null && toRemove.getRight() == null) {
                if (parent == null) {
                    root = null;
                } else if (isLeftChild(toRemove) == true) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
                // return value;
            } else if (toRemove.getLeft() != null && toRemove.getRight() == null) {
                //
                if (parent == null) {
                    root = toRemove.getLeft();
                } else if (isLeftChild(toRemove) == true) {
                    parent.setLeft(toRemove.getLeft());
                    toRemove.getLeft().setParent(parent);
                } else {
                    parent.setRight(toRemove.getRight());
                    toRemove.getRight().setParent(parent);
                }
                // return value;
                // node to be removed has only a right childnode
            } else if (toRemove.getLeft() == null && toRemove.getRight() != null) {
                // the parent of the node to remove is null, which means the
                // node to be deleted
                // is the root node
                if (parent == null) {
                    root = toRemove.getRight().findMin();
                    if (toRemove.getRight().findMin() != toRemove.getRight()) {
                        toRemove.getRight().findMin().getParent().setLeft(null);
                    }

                    // the node to be deleted is the left child of its parent
                } else if (isLeftChild(toRemove) == true) {
                    parent.setLeft(toRemove.getRight().findMin());
                    if (toRemove.getRight().findMin() != toRemove.getRight()) {
                        toRemove.getRight().findMin().getParent().setLeft(null);
                    } else {
                        toRemove.getRight().findMin().setParent(parent);
                    }
                    if (toRemove.getRight().findMin().getRight() != null) {
                        toRemove.getRight().findMin().setRight(toRemove.getRight().findMin().getParent());
                    }
                    // toRemove.getRight().findMin().setLeft(toRemove.getLeft());
                    // the node to be deleted is the right child of its parent
                } else {
                    parent.setRight(toRemove.getRight().findMin());
                    if (toRemove.getRight().findMin() != toRemove.getRight()) {
                        toRemove.getRight().findMin().getParent().setLeft(null);
                    } else {
                        toRemove.getRight().findMin().setParent(parent);
                    }
                    if (toRemove.getRight().findMin().getRight() != null) {
                        toRemove.getRight().findMin().setRight(toRemove.getRight().findMin().getParent());
                    }
                }
                // return value;
            } else if (toRemove.getLeft() != null && toRemove.getRight() != null) {
                if (parent == null) {
                    AvlNode<K, V> oldRoot = root;
                    root = toRemove.getRight().findMin();
                    if (toRemove.getRight().findMin() != toRemove.getRight()) {
                        toRemove.getRight().findMin().getParent().setLeft(null);
                    } else {
                        toRemove.getRight().findMin().setParent(null);
                    }
                    if (toRemove.getRight().findMin().getRight() != null) {
                        toRemove.getRight().findMin().setRight(toRemove.getRight().findMin().getRight());
                    }
                    toRemove.getRight().findMin().setLeft(oldRoot.getLeft());

                    // root.getLeft().setParent(toremove.getRight().findMin());
                } else if (isLeftChild(toRemove) == true) {
                    parent.setLeft(toRemove.getRight().findMin());
                    if (toRemove.getRight().findMin() != toRemove.getRight()) {
                        toRemove.getRight().findMin().getParent().setLeft(null);
                    } else {
                        toRemove.getRight().findMin().setLeft(toRemove.getLeft());
                    }
                    if (toRemove.getRight().findMin().getRight() != null) {
                        toRemove.getRight().findMin().setRight(toRemove.getRight().findMin().getParent());
                    }
                } else {
                    parent.setRight(toRemove.getRight().findMin());
                    if (toRemove.getRight().findMin() != toRemove.getRight()) {
                        toRemove.getRight().findMin().getParent().setLeft(null);
                    } else {
                        toRemove.getRight().findMin().setParent(parent);
                    }
                    if (toRemove.getRight().findMin().getRight() != null) {
                        toRemove.getRight().findMin().setRight(toRemove.getRight().findMin().getParent());
                    }
                }
                // return value;
            }
            return value;
        } else { // key not found
            return null;
        }
    }

    private AvlNode<K, V> find(AvlNode<K, V> current, K key) {
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

    // node is the node that has been inserted
//    private void rebalenceAfterInsert (AvlNode<K, V> node){
//		AvlNode<K, V> parent = node.getParent();
//		if (parent != null) {
//			if (parent.parent.getBalance() == 0) { // parent has no right child
//				if (isLeftChild(node) == true) {
//					parent.setBalance(-1);
//				} else {
//					parent.setBalance(1);
//				}
//			} else if (parent.parent.getBalance() == -1) {
//					if (isLeftChild(node)==true){
//					parent.parent.setBalance(-2);
//					} else {
//					}
//			} else if (parent.parent.getBalance() == 1) {
//					parent.parent.setBalance(2);
//			}
//				parent.rebalenceAfterInsert();
//			}
//		}
//
//    if(parent.getParent().getBalance()==-1)
//
//    {// node is left child of a left child (with no right)
//
//    }}
//
//   
//    String input = "c";
//
//    List<String> bodyTypes = Array.asList("cuboid", "Cylinder", "Sphere", "Pyramid");
//    List<String> matchingBodyTypes = new ArrayList<>();
//    for(String bodyType:bodyTypes) {
//		if (bodyType.startsWith(input)){
//			matchingBodyTypes.add(bodyType);
//		
//			if (matchingBodyTypes.size()==1){
//			System.out.println("Sucess" + matchingBodyTypes.iterator.next());
//			
//			}  else {
//			System.out.println("Error..." + matchingBodyTypes);
//			}
//		}
//    }	
			
			
			
}
