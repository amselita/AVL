package avl;

import java.util.Iterator;

public class AvlNodeIterator<K, V> implements Iterator<V> {
    AvlNode<K, V> next;

    public AvlNodeIterator(AvlNode<K, V> min) {
        next = min;
    }

    /**
     * checks weather or not a node has a next element in the logically given order of the tree
     * @return (true) if the node has a next node, (false if not
     */
    @Override
    public boolean hasNext() {
        // return (current.getLeft()!=null|| current.getRight()!=null);
        return next != null;
    }

    /**
     * returns the value of the logically next element of the trees order 
     * the recursive order is: left node, parent, right node
     *@return V the value of the logically next element of the trees order
     */
    @Override
    public V next() {
        AvlNode<K, V> current = next;

        if (current.getRight() != null) {
            next = current.getRight().findMin();
        } else {
            AvlNode<K, V> pointer = current;

            if (pointer.getParent().getLeft() == pointer) {
                next = pointer.getParent();
            } else {
                while (pointer.getParent() != null && pointer.getParent().getRight() == pointer) {
                    pointer = pointer.getParent();
                }

                next = pointer.getParent();
            }
        }
        return current.getValue();
    }
}
