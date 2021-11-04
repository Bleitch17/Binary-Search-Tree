package BinarySearchTree;

public interface BST {
    boolean isEmpty();
    BST put(int value);
    BST get(int value);
    BST delete(int value);
    int minValue();
    int maxValue();
    int countValidNodes();
    int depth();
    // below method for debugging purposes
    void printTree(int spaceShift);
}
