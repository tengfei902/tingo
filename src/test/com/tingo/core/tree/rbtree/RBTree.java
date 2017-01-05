package tingo.core.tree.rbtree;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by user on 17/1/5.
 */
public class RBTree<T extends Comparable<T>> {
    private final RBTreeNode<T> root;
    private AtomicLong size = new AtomicLong(0);
    private volatile boolean overrideMode=true;

    public RBTree() {
        this.root = new RBTreeNode<T>();
    }

    public RBTree(boolean overrideMode) {
        this();
        this.overrideMode = overrideMode;
    }

    public boolean isOverrideMode() {
        return overrideMode;
    }

    public long getSize() {
        return size.get();
    }

    private RBTreeNode<T> getRoot() {
        return root.getLeft();
    }

    public T addNode(T value) {
        RBTreeNode<T> t = new RBTreeNode<T>(value);
        return addNode(t);
    }

    public T find(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        while(dataRoot!=null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if(cmp<0) {
                dataRoot = dataRoot.getRight();
            } else if(cmp>0) {
                dataRoot = dataRoot.getLeft();
            } else {
                return dataRoot.getValue();
            }
        }
        return null;
    }

    public T remove(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        RBTreeNode<T> parent = root;

        while (dataRoot != null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if(cmp<0) {
                parent = dataRoot;
                dataRoot = dataRoot.getRight();
            } else if(cmp>0) {
                parent = dataRoot;
                dataRoot = dataRoot.getLeft();
            } else {
                if(dataRoot.getRight()!=null) {
                    RBTreeNode<T> min = removeMin(dataRoot.getRight());
                    RBTreeNode<T> x = min.getRight()==null?min.getParent():min.getRight();
                    boolean isParent = min.getRight()==null;

                }
            }
        }
    }
}
