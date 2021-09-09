package com.delosreyesjeremiah;

import java.util.EmptyStackException;

public class CardStack {
    private Card[] deck;
    private Card[] graveyard;
    private Card[] hand;
    private int topDeck = 0;
    private int topGraveyard = 0;
    private int topHand = 0;
    private int deckCards = 0;
    private int graveyardCards = 0;
    private int handCards = 0;

    public CardStack(int capacity) {
        deck = new Card[capacity];
        graveyard = new Card[capacity];
        hand = new Card[capacity];
    }

    public Card[] getDeck() {
        return deck;
    }

    public Card[] getGraveyard() {
        return graveyard;
    }

    public Card[] getHand() {
        return hand;
    }

    public boolean isEmptyDeck() {
        return topDeck == 0;
    }

    public boolean isEmptyGraveyard() {
        return topGraveyard == 0;
    }

    public boolean isEmptyHand() {
        return topHand == 0;
    }

    public void pushDeck(Card card) {
        deck[topDeck++] = card;
        deckCards++;
    }

    public Card popDeck() {
        if (isEmptyDeck()) {
            throw new EmptyStackException();
        }

        Card poppedCard = deck[--topDeck];
        deck[topDeck] = null;
        deckCards--;
        return poppedCard;
    }

    public Card peekDeck() {
        if (isEmptyDeck()) {
            throw new EmptyStackException();
        }

        return deck[topDeck - 1];
    }

    public void pushGraveyard(Card card) {
        graveyard[topGraveyard++] = card;
        graveyardCards++;
    }

    public Card popGraveyard() {
        if (isEmptyGraveyard()) {
            throw new EmptyStackException();
        }

        Card poppedCard = graveyard[--topGraveyard];
        graveyard[topGraveyard] = null;
        graveyardCards--;
        return poppedCard;
    }

    public Card peekGraveyard() {
        if (isEmptyGraveyard()) {
            throw new EmptyStackException();
        }

        return graveyard[topGraveyard - 1];
    }

    public void pushHand(Card card) {
        hand[topHand++] = card;
        handCards++;
    }

    public Card popHand() {
        if (isEmptyHand()) {
            throw new EmptyStackException();
        }

        Card poppedCard = hand[--topHand];
        hand[topHand] = null;
        handCards--;
        return poppedCard;
    }

    public Card peekHand() {
        if (isEmptyHand()) {
            throw new EmptyStackException();
        }

        return hand[topHand - 1];
    }

    public void draw(int numberOfDraws) {
        for (int i = 0; i < numberOfDraws; i++) {
            if (isEmptyDeck()) {
                System.out.println("Unable to draw... Deck is empty.");
                return;
            }

            Card drawCard = peekDeck();
            popDeck();
            pushHand(drawCard);
            System.out.println("Drawn " + drawCard.getName());
        }
    }

    public void discard(int numberOfDiscards) {
        for (int i = 0; i < numberOfDiscards; i++) {
            if (isEmptyHand()) {
                System.out.println("Unable to discard... Hand is empty.");
                return;
            }

            Card discardCard = peekHand();
            popHand();
            pushGraveyard(discardCard);
            System.out.println("Discarded " + discardCard.getName());
        }
    }

    public void retrieve(int numberOfRetrieves) {
        for (int i = 0; i < numberOfRetrieves; i++) {
            if (isEmptyGraveyard()) {
                System.out.println("Unable to retrieve... Graveyard is empty.");
                return;
            }

            Card retrieveCard = peekGraveyard();
            popGraveyard();
            pushHand(retrieveCard);
            System.out.println("Retrieved " + retrieveCard.getName());
        }
    }

    public int cardsInDeck() {
        return deckCards;
    }

    public int cardsInGraveyard() {
        return graveyardCards;
    }

    public int cardsInHand() {
        return handCards;
    }
}
