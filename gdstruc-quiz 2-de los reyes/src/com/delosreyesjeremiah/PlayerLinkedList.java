package com.delosreyesjeremiah;

import java.util.ArrayList;
import java.util.List;

public class PlayerLinkedList {
    private List<PlayerNode> playerList = new ArrayList<>();
    private PlayerNode head;
    private int counter = 0;

    public void addToFront(Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        playerNode.setIndex(0);
        playerList.add(playerNode);
        if (playerNode.getNextPlayer() != null) {
            for (PlayerNode p : playerList) {
                if (p != playerNode) {
                    p.setIndex(p.getIndex() + 1);
                }
            }
        }
        head = playerNode;
        counter++;
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("HEAD -> ");

        while (current != null) {
            System.out.print(current.getPlayer());
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }

        System.out.println("NULL");
    }

    public void removeFrontElement() {
        System.out.println(head.getPlayer() + " has been removed.");
        playerList.remove(head);
        head = head.getNextPlayer();

        for (PlayerNode p : playerList) {
            p.setIndex(p.getIndex() - 1);
        }

        counter--;
    }

    public int size() {
        return counter;
    }

    public boolean contains(Player player) {
        boolean exists = false;
        for (PlayerNode p : playerList) {
            if (p.getPlayer() == player)
                exists = true;
        }
        return exists;
    }

    public int indexOf(Player player) {
        int index = -1;
        for (PlayerNode p : playerList) {
            if (p.getPlayer() == player)
                index =  p.getIndex();
        }
        return index;
    }
}
