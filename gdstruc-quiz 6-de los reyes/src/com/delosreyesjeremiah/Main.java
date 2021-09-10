package com.delosreyesjeremiah;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(68);
        tree.insert(55);

        System.out.println("\nTraversing the tree In-Order Descending...");
        tree.traverseInOrderDescending();

        System.out.println("\nGetting a node with a value of 29 from the tree...");
        System.out.println(tree.get(29));

        System.out.println("\nGetting a node with a value of 999 from the tree...");
        System.out.println(tree.get(999));

        System.out.println("\nFetching the node with the least value in the tree...");
        System.out.println(tree.getMin());

        System.out.println("\nFetching the node with the maximum value in the tree...");
        System.out.println(tree.getMax());
    }
}
