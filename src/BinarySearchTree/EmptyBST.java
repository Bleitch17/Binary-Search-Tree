package BinarySearchTree;

public class EmptyBST implements BST {
    private static boolean created = false;
    private static EmptyBST e;

    public static BST emptyBST() {
        if (!created) {
            e = new EmptyBST();
            created = true;
        }
        return e;
    }

    public boolean isEmpty() {
        return true;
    }

    public BST put(int value) {
        return new FilledBST(value);
    }

    public BST get(int value) {
        return null;
    }

    public BST delete(int value) {
        return this;
    }

    public int minValue() {
        throw new UnsupportedOperationException("Can't do this with an empty tree!");
    }

    public int maxValue() {
        throw new UnsupportedOperationException("Can't do this with an empty tree!");
    }

    public int countValidNodes() {
        return 0;
    }

    public int depth() {
        return 0;
    }

    public void printTree(int spaceShift) {
        return;
    }
}
