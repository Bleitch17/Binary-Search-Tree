package BinarySearchTree;

import BinarySearchTree.BST;
import BinarySearchTree.EmptyBST;

public class FilledBST implements BST {
    private int value;
    private BST leftChild;
    private BST rightChild;

    public FilledBST(int value) {
        this.value = value;
        this.leftChild = EmptyBST.emptyBST();
        this.rightChild = EmptyBST.emptyBST();
    }

    public boolean isEmpty() {
        return false;
    }

    public int getValue() {
        return this.value;
    }

    public BST put(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            this.leftChild = leftChild.put(value);
        } else {
            this.rightChild = rightChild.put(value);
        }
        return this;
    }

    public BST get(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            return leftChild.get(value);
        } else {
            return rightChild.get(value);
        }
    }

    public BST delete(int value) {
        if (value < this.value) {
            this.leftChild = this.leftChild.delete(value);
        }
        else if (value > this.value) {
            this.rightChild = this.rightChild.delete(value);
        }
        else {
            if (this.leftChild.isEmpty() && this.rightChild.isEmpty()) {
                return EmptyBST.emptyBST();
            }
            else if (this.leftChild.isEmpty()) {
                return this.rightChild;
            }
            else if (this.rightChild.isEmpty()) {
                return this.leftChild;
            }
            else {
                this.value = this.rightChild.minValue();
                this.rightChild = this.rightChild.delete(this.value);
                return this;
            }
        }
        return this;
    }

    public int minValue() {
        if (this.leftChild.isEmpty()) {
            return this.value;
        } else {
            return this.leftChild.minValue();
        }
    }

    public int maxValue() {
        if (this.rightChild.isEmpty()) {
            return this.value;
        } else {
            return this.rightChild.maxValue();
        }
    }

    public int countValidNodes() {
        return 1 + this.leftChild.countValidNodes() + this.rightChild.countValidNodes();
    }

    public int depth() {
        return 1 + Math.max(this.leftChild.depth(), this.rightChild.depth());
    }

    public void printTree(int spaceShift) {
        boolean lExists = false;
        boolean rExists = false;
        int leftNodes = 0;
        int rightNodes = 0;

        if (!this.leftChild.isEmpty()) {
            lExists = true;
            leftNodes = this.leftChild.countValidNodes();
        }
        if (!this.rightChild.isEmpty()) {
            rExists = true;
            rightNodes = this.rightChild.countValidNodes();
        }

        String emptySpaces = new String(new char[spaceShift + leftNodes + 1]).replace('\0', ' ');
        System.out.println(emptySpaces + this.value);

        String connections = new String(new char[leftNodes + spaceShift]).replace('\0', ' ');
        if (lExists) {
            connections += "/";
        }
        connections += new String(new char[rightNodes]).replace('\0', ' ');
        if (rExists) {
            connections += "\\";
        }
        System.out.println(connections);

        if (lExists) {
            this.leftChild.printTree(spaceShift);
        }

        if (rExists) {
            this.rightChild.printTree(spaceShift + leftNodes + 1);
        }

    }
}
