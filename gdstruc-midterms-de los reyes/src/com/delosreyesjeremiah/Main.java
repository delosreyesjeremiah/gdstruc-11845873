package com.delosreyesjeremiah;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CardStack deck = new CardStack(30);
        CardStack hand = new CardStack(30);
        CardStack graveyard = new CardStack(30);

        List<Card> cards = new ArrayList<>(10);

        cards.add(new Card("DARK MAGICIAN"));
        cards.add(new Card("DARK MAGICIAN GIRL"));
        cards.add(new Card("EXODIA THE FORBIDDEN ONE"));
        cards.add(new Card("LEFT ARM OF THE FORBIDDEN ONE"));
        cards.add(new Card("RIGHT ARM OF THE FORBIDDEN ONE"));
        cards.add(new Card("LEFT LEG OF THE FORBIDDEN ONE"));
        cards.add(new Card("RIGHT LEG OF THE FORBIDDEN ONE"));
        cards.add(new Card("OBELISK THE TORMENTOR"));
        cards.add(new Card("THE WINGED DRAGON OF RA"));
        cards.add(new Card("SLIFER THE SKY DRAGON"));

        System.out.println("\nCreating the deck...");
        create(cards, deck);

        System.out.println("Shuffling the deck...");
        shuffle(deck);

        // Loop until no more cards are left in the deck
        int turn = 1;
        while (!deck.isEmpty()) {
            System.out.print("\n");
            System.out.println("TURN " + turn);
            playRound(deck, hand, graveyard);
            System.out.print("\n");
            show(hand);
            System.out.print("\n");
            print(deck, hand, graveyard);
            turn++;
        }

        System.out.println("\nDeck is empty...");
    }

    public enum Action {
        DRAW, DISCARD, RETRIEVE;

        public static Action random() {
            Action[] values = Action.values();
            return values[new Random().nextInt(values.length)];
        }
    }

    public static void create(List<Card> cards, CardStack stack) {
        for (int i = 0; i < stack.getStack().length; i += 10) {
            for (Card card : cards) {
                stack.push(card);
            }
        }
    }

    public static void shuffle(CardStack stack) {
        Random random = new Random();
        for (int i = 0; i < stack.getStack().length; i++) {
            Card temp = stack.getStack()[i];
            int randomIndex = random.nextInt(stack.getStack().length);
            stack.getStack()[i] = stack.getStack()[randomIndex];
            stack.getStack()[randomIndex] = temp;
        }
    }

    public static void show(CardStack stack) {
        if (stack.isEmpty()) {
            System.out.println("Cards currently holding: N/A");
            return;
        }
        else {
            System.out.println("Cards currently holding: ");
        }

        for (int i = 0; i < stack.getStack().length; i++) {
            // if card is null, return
            if (stack.getStack()[i] == null)
                return;

            System.out.println("[" + (i + 1) + "] " + stack.getStack()[i].getName());
        }
    }

    public static void print(CardStack deck, CardStack hand, CardStack graveyard) {
        System.out.println("Deck: " + deck.remaining());
        System.out.println("Hand: " + hand.remaining());
        System.out.println("Graveyard: " + graveyard.remaining());
    }

    public static void playRound(CardStack deck, CardStack hand, CardStack graveyard) {
        Random random = new Random();
        Action action = Action.random();
        int numberOfCards = random.nextInt(5) + 1;
        switch(action) {
            case DRAW:
                if (deck.remaining() == 0) {
                    System.out.println("Unable to draw... Deck is empty.");
                }
                else if (numberOfCards > deck.remaining()) {
                    int newNumber = deck.remaining();
                    System.out.println("Unable to draw " + numberOfCards + " cards from the deck... " +
                                        "Drawing " + newNumber + " card/s instead...");
                    cardAction(deck, hand, newNumber, action);
                }
                else {
                    System.out.println("Drawing " + numberOfCards + " card/s from the deck...");
                    cardAction(deck, hand, numberOfCards, action);
                }
                break;
            case DISCARD:
                if (hand.remaining() == 0) {
                    System.out.println("Unable to discard... Hand is empty.");
                }
                else if (numberOfCards > hand.remaining()) {
                    int newNumber = hand.remaining();
                    System.out.println("Unable to discard " + numberOfCards + " cards from the hand... " +
                                        "Discarding " + newNumber + " card/s instead...");
                    cardAction(hand, graveyard, newNumber, action);
                }
                else {
                    System.out.println("Discarding " + numberOfCards + " card/s from the hand...");
                    cardAction(hand, graveyard, numberOfCards, action);
                }
                break;
            case RETRIEVE:
                if (graveyard.remaining() == 0) {
                    System.out.println("Unable to retrieve... Graveyard is empty.");
                }
                else if (numberOfCards > graveyard.remaining()) {
                    int newNumber = graveyard.remaining();
                    System.out.println("Unable to retrieve " + numberOfCards + " cards from the graveyard... " +
                                        "Retrieving " + newNumber + " card/s instead...");
                    cardAction(graveyard, hand, newNumber, action);
                }
                else {
                    System.out.println("Retrieving " + numberOfCards + " card/s from the graveyard...");
                    cardAction(graveyard, hand, numberOfCards, action);
                }
                break;
        }
    }

    public static void cardAction(CardStack stack1, CardStack stack2, int numberOfCards, Action action) {
        for (int i = 0; i < numberOfCards; i++) {
            Card card = stack1.peek();
            stack1.pop();
            stack2.push(card);

            switch(action) {
                case DRAW:
                    System.out.println("Drawn " + card.getName());
                    break;
                case DISCARD:
                    System.out.println("Discarded " + card.getName());
                    break;
                case RETRIEVE:
                    System.out.println("Retrieved " + card.getName());
                    break;
            }
        }
    }
}
