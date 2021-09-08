package com.delosreyesjeremiah;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player saber = new Player(1, "Saber", 72);
        Player archer = new Player(2, "Archer", 98);
        Player berserker = new Player (3, "Berserker", 60);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(saber);
        playerLinkedList.addToFront(archer);
        playerLinkedList.addToFront(berserker);

        playerLinkedList.printList();
        System.out.println("Player Linked List contains " + playerLinkedList.size() + " element/s.");

        System.out.println("Containing " + saber.getName() + "? " + playerLinkedList.contains(saber));
        System.out.println("Index: " + playerLinkedList.indexOf(saber));

        while (playerLinkedList.size() > 0) {
            System.out.print("\n");
            playerLinkedList.removeFrontElement();
            playerLinkedList.printList();
            System.out.println("Player Linked List contains " + playerLinkedList.size() + " element/s.");
        }
    }
}
