package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // instance variables
    private Random rand = new Random();
    private ArrayList<Card> deck = new ArrayList<Card>();

    // constructor
    public Deck() {
        build();
    }

    // getters
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    public void clear() {
        deck.clear();
    }

    /**
     * builds a deck of 52 cards
     * 13 cards of each suit (hearts, diamonds, clubs, spades)
     * 4 suits (hearts, diamonds, clubs, spades)
     */
    public void build() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * shuffles the deck
     * creates a new deck and randomly selects cards from the original deck to populate the new deck
     */
    public void shuffle() {
        // clone the deck
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        while (deck.size() > 0) {
            // pick a random card from the deck
            int loc = rand.nextInt(deck.size());
            tempDeck.add(deck.get(loc));
            // remove the card from the deck to avoid duplicates
            deck.remove(loc);
        }
        deck = tempDeck;
    }

    
    /**
     * Picks a card from the deck at the specified index.
     *
     * @param i the index of the card to be picked
     * @return the card that was picked from the deck
     */
    public Card pick(int i) {
        Card picked = deck.remove(i);
        return picked;
    }

    /**
     * Deals a card from the top of the deck.
     *
     * @return the card that was dealt from the deck
     */
    public Card deal() {
        return deck.remove(0);
    }

    public int size() {
        return deck.size();
    }

    // returns a string representation of the deck
    public String toString() {
        String deckString = "";
        for (Card card : deck) {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
}
