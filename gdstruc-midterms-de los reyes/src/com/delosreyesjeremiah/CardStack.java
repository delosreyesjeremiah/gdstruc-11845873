package com.delosreyesjeremiah;

import java.util.EmptyStackException;

public class CardStack {
    private Card[] stack;
    private int top;

    public CardStack(int capacity) {
        stack = new Card[capacity];
    }

    public Card[] getStack() {
        return stack;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(Card card) {
        // if stack is full, resize the stack
        if (top == stack.length) {
            Card[] newStack = new Card[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = card;
    }

    public Card pop() {
        // if stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Card poppedCard = stack[--top];
        stack[top] = null;
        return poppedCard;
    }

    public Card peek() {
        // if stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int remaining() {
        int count = 0;
        for (int i = 0; i < getStack().length; i++) {
            if (getStack()[i] != null)
                count++;
        }
        return count;
    }
}
