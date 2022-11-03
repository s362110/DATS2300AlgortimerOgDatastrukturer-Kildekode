package Uke42_BinæreTrær;

import java.util.ArrayDeque;

public class BinaryTree {

    static class BinaryTreeNode {
        char value;
        BinaryTreeNode left_child;
        BinaryTreeNode right_child;

        BinaryTreeNode(char value) {
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        BinaryTreeNode addLeftChild(char value) {
            this.left_child = new BinaryTreeNode(value);
            return this.left_child;
        }

        BinaryTreeNode addRightChild(char value) {
            this.right_child = new BinaryTreeNode(value);
            return this.right_child;
        }
    }

    static void printLevelOrder(BinaryTreeNode root){
        ArrayDeque<BinaryTreeNode> queve = new ArrayDeque<BinaryTreeNode>();

        // Legg til rot-noden
        queve.addLast(root);

        while (!queve.isEmpty()){
            // Ta ut første fra køen
            BinaryTreeNode current = queve.removeFirst();

            // Legg til current sine to barn til køen
            if (current.left_child != null){
                queve.addLast(current.left_child);
            }

            if (current.right_child != null){
                queve.addLast(current.right_child);
            }

            // 3. Skriv ut
            System.out.println(current.value + " ");
        }
    }

    public static void main(String[] args){
        // Lager rot-noden
        BinaryTreeNode root = new BinaryTreeNode('A');

        // Legg inn resterende noder på nivå 1
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');

        // Legg inn alle noder på nivå 2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = d.addRightChild('G');

        // Kall funksjonen vår
        printLevelOrder(root);


    }
}