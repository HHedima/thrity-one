package edu.guilford;

import java.util.ArrayList;

public class ThirtyOne {
    // instance variables
    private Deck deck;
    private ArrayList<Player> players;
    private int round;
    private Deck discardPile = new Deck();

    // constructor
    public ThirtyOne(int numPlayers) {
        players = new ArrayList<>();
        deck = new Deck();
        deck.shuffle();
        round = 0;
        discardPile.clear();
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player("Player " + (i + 1));
            for (int j = 0; j < 3; j++) {
                player.addCard(deck.deal());
            }
            players.add(player);
        }
    }

    // getters
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getRound() {
        return round;
    }

    public Deck getDeck() {
        return deck;
    }

    public Deck getDiscardPile() {
        return discardPile;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    

    // toString method
    public String toString() {
        String str = "";
        for (int i = 0; i < players.size(); i++) {
            str += "Player " + (i + 1) + ": " + players.get(i) + "\n";
        }
        return str;
    }

}
