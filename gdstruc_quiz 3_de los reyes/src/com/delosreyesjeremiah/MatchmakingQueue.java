package com.delosreyesjeremiah;

import java.util.NoSuchElementException;

public class MatchmakingQueue {

    private Player[] queue;
    private int front;
    private int back;

    public MatchmakingQueue(int capacity) {
        queue = new Player[capacity];
    }

    public Player[] getQueue() {
        return queue;
    }

    public void add(Player player) {
        if (back ==  queue.length) {
            Player[] newArray = new Player[queue.length * 2];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = player;
        back++;
    }

    public Player remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Player removedPlayer = queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return removedPlayer;
    }

    public Player peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
