package com.practice.java.ds.tree;

@SuppressWarnings("UnusedReturnValue")
public class BasicBinaryTree<X extends Comparable<X>> {

    private TreeNode<X> rootNode;
    private int totalItems;

    public BasicBinaryTree() {
        totalItems = 0;
    }

    public int size() {
        return totalItems;
    }

    public void add(X item) {
        TreeNode<X> treeNode = new TreeNode<>(item);
        if (rootNode == null) {
            this.rootNode = treeNode;
            this.totalItems++;
            return;
        }
        insert(this.rootNode, treeNode);
    }

    private void insert(TreeNode<X> parent, TreeNode<X> child) {
        if (parent == null || child == null) {
            return;
        }
        if (child.getItem().compareTo(parent.getItem()) <= 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.totalItems++;
                return;
            }
            insert(parent.getLeft(), child);
            return;
        }

        if (parent.getRight() == null) {
            parent.setRight(child);
            child.setParent(parent);
            this.totalItems++;
            return;
        }

        insert(parent.getRight(), child);
    }

    public boolean contains(X item) {
        if (rootNode == null) {
            return false;
        }

        TreeNode<X> treeNode = getNode(item);
        return treeNode != null;
    }

    private TreeNode<X> getNode(X item) {
        TreeNode<X> currentNode = this.rootNode;

        while (currentNode != null) {
            int compareToValue = item.compareTo(currentNode.getItem());
            if (compareToValue == 0) {
                return currentNode;
            } else if (compareToValue < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    public boolean delete(X item) {
        if (this.rootNode == null) {
            return false;
        }
        TreeNode<X> currentNode = getNode(item);
        if (currentNode == null) {
            return false;
        }

        TreeNode<X> currentNodeLeft = currentNode.getLeft();
        TreeNode<X> currentNodeRight = currentNode.getRight();

        if (currentNodeLeft == null && currentNodeRight == null) {
            unlink(currentNode, null);
            return true;
        }

        if (currentNodeLeft == null) {
            unlink(currentNode, currentNodeRight);
            return true;
        }
        if (currentNodeRight == null) {
            unlink(currentNode, currentNodeLeft);
            return true;
        }

        TreeNode<X> child = currentNodeLeft;
        while (child.getRight() != null && child.getLeft() != null) {
            child = child.getRight();
        }

        child.getParent().setRight(null);

        child.setLeft(currentNode.getLeft());
        child.setRight(currentNode.getRight());

        unlink(currentNode, child);
        return true;
    }

    private void unlink(TreeNode<X> currentNode, TreeNode<X> nextNode) {
        totalItems--;
        if (this.rootNode.equals(currentNode)) {
            nextNode.setLeft(currentNode.getLeft());
            nextNode.setRight(currentNode.getRight());
            this.rootNode = nextNode;
            return;
        }

        TreeNode<X> parent = currentNode.getParent();
        if (currentNode.equals(parent.getRight())) {
            parent.setRight(nextNode);
        } else {
            parent.setLeft(nextNode);
        }
    }
}
