package com.delosreyesjeremiah;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CardStack cardStack = new CardStack(30);
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
        createDeck(cards, cardStack);

        System.out.println("Shuffling the deck...");
        shuffleDeck(cardStack.getDeck(), cardStack);

        // Loop until no more cards are left in the deck
        int turn = 1;
        while (cardStack.cardsInDeck() > 0) {
            System.out.print("\n");
            System.out.println("TURN " + turn);
            playRound(cardStack);
            showHand(cardStack);
            printNumberOfCards(cardStack);
            turn++;
        }

        System.out.println("\nDeck is empty...");
    }

    public static void createDeck(List<Card> cards, CardStack cardStack) {
        for (int i = 0; i < cardStack.getDeck().length; i += 10) {
            for (int j = 0; j < cards.size(); j++) {
                cardStack.pushDeck(cards.get(j));
            }
        }
    }

    public static void shuffleDeck(Card[] deck, CardStack cardStack) {
        Random random = new Random();
        for (int i = 0; i < cardStack.cardsInDeck(); i++) {
            Card temp = deck[i];
            int randomIndex = random.nextInt(cardStack.cardsInDeck());
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    public static void showHand(CardStack cardStack) {
        if (cardStack.cardsInHand() == 0) {
            System.out.println("Cards currently holding: N/A");
            return;
        }
        else {
            System.out.println("Cards currently holding: ");
        }

        for (int i = 0; i < cardStack.cardsInHand(); i++) {
            System.out.println("[" + (i + 1) + "] " + cardStack.getHand()[i].getName());
        }
    }

    public static void printNumberOfCards(CardStack cardStack) {
        System.out.println("Deck: " + cardStack.cardsInDeck());
        System.out.println("Hand: " + cardStack.cardsInHand());
        System.out.println("Graveyard: " + cardStack.cardsInGraveyard());
    }

    public static void playRound(CardStack cardStack) {
        Random random = new Random();
        int action = random.nextInt(3);
        int numberOfCards = random.nextInt(5) + 1;
        if (action == 0) {
            System.out.println("Drawing " + numberOfCards + " card/s from the deck...");
            cardStack.draw(numberOfCards);
        } else if (action == 1) {
            System.out.println("Discarding " + numberOfCards + " card/s from the hand...");
            cardStack.discard(numberOfCards);
        } else if (action == 2) {
            System.out.println("Retrieving " + numberOfCards + " card/s from the graveyard...");
            cardStack.retrieve(numberOfCards);
        }
    }
}
