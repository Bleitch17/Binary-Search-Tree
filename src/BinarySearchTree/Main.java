package BinarySearchTree;

import BinarySearchTree.BST;
import BinarySearchTree.FilledBST;

class Main {
    public static void main(String[] args) {

        BST tree = new FilledBST(7);
        tree.put(3);
        tree.put(11);
        tree.put(5);
        tree.put(2);
        tree.put(4);
        tree.put(9);
        tree.put(15);
        tree.put(10);
        tree.put(17);
        tree.put(18);
        tree.put(16);
        tree.put(13);

        tree.printTree(0);
        System.out.println("--------------------------------------------");

        tree.delete(20);
        tree.printTree(0);

        int[] searchValues = new int[]{5,9,0};

        for (int searchValue : searchValues) {
            if (tree.get(searchValue) == null) {
                System.out.println(searchValue + " not in the tree");
            } else {
                System.out.println(searchValue + " found");
            }
        }

        System.out.println("Min value: " + tree.minValue());
        System.out.println("Max value: " + tree.maxValue());
        System.out.println("Node count: " + tree.countValidNodes());
        System.out.println("Depth: " + tree.depth());

    }
}
