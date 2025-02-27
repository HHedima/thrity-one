package edu.guilford;

import java.util.Random;

public class Card implements Comparable<Card>{
    // enum for the suits
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    // enum for the ranks
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
        KING
    }

    // instance variables
    private Suit suit;
    private Rank rank;

    // constructor
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * default constructor
     * creates a random card
     */
    public Card() {
        // random Card
        Random rand = new Random();
        int suit = rand.nextInt(Suit.values().length);
        int rank = rand.nextInt(Rank.values().length);
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }

    // getters
    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    // toString method
    public String toString() {
        return rank + " of " + suit;
    }

    /**
     * compares two cards
     * first compares the ranks
     * if the ranks are the same, compares the suits
     */
    @Override
    public int compareTo(Card otherCard) {
        // compare the ranks first
        if (this.rank.ordinal() > otherCard.rank.ordinal()) {
            return 1;
        }
        else if (this.rank.ordinal() < otherCard.rank.ordinal()) {
            return -1;
        }
        // if the ranks are the same, compare the suits
        else {
            if (this.suit.ordinal() > otherCard.suit.ordinal()) {
                return 1;
            }
            else if (this.suit.ordinal() < otherCard.suit.ordinal()) {
                return -1;
            }
        }
        // if the cards are the same, return 0
        return 0;
    }

    
}