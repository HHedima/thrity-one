package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class ThirtyOneGame {
    // instance variables
    private Deck deck;
    private ArrayList<Player> players;
    private int round;
    private Deck discardPile = new Deck();
    private Random rand = new Random();
    private boolean gameOver = false;

    // constructor
    public ThirtyOneGame(int numPlayers) {
        players = new ArrayList<>();
        deck = new Deck();
        deck.shuffle();
        round = 0;
        discardPile.clear();
        discardPile.addCard(deck.deal());
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

    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * See who has highest score
     * @return the player with the highest score
     */
    public Player getWinner() {
        Player winner = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getTotalValue() > winner.getTotalValue()) {
                winner = players.get(i);
            }
        }
        return winner;
    }

    /**
     * See who has the lowest score
     * if tied, everyone tied person loses
     * @return the player with the lowest score
     */
    public Player getLoser() {
        Player loser = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getTotalValue() < loser.getTotalValue()) {
                loser = players.get(i);
            }
        }
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getTotalValue() == loser.getTotalValue()) {
                players.get(i).loseLife();
            }
        }
        return loser;
    }

    /**
     * Play a turn for a player
     * if player has 31, they automatically win
     * let the player choose a card from discard pile or deck
     */
    public void playTurn(Player player) {
        if (player.getTotalValue() == 31) {
            player.knock();
            return;
        }
        // find highest value card on top of discard pile or deck
        Card highestCard = discardPile.getCard(0);
        if (deck.getCard(0).compareTo(highestCard) == 1) {
            highestCard = deck.deal();
        } else {
            highestCard = discardPile.deal();
        }
        

        // replace lowest card in hand with highest card
        Card lowCard = player.lowCard();
        player.removeCard(lowCard);
        player.addCard(highestCard);
        discardPile.addCard(lowCard);

        // knock if hand is bigger than 21
        if (round > 1) {
            if (player.getTotalValue() > 21) {
                player.knock();
            }
        }
    }

    // reset the game
    public void reset() {
        deck.clear();
        deck.build();
        deck.shuffle();
        discardPile.clear();
        discardPile.addCard(deck.deal());
        for (Player player : players) {
            player.reset();
            for (int j = 0; j < 3; j++) {
                player.addCard(deck.deal());
            }
        }
        round = 0;
    }
    
    /**
     * Play a round of the game
     * Each player takes a turn
     */
    public String playRound() {
        for (Player player : players) {
            playTurn(player);
            if (player.hasKnocked()) {
                getWinner();
                getLoser();
                gameOver = true;
                return (player.getName() + " has knocked!");
            }
        }
        round++;
        
        return toString();
    }

    // toString method
    public String toString() {
        String str = "";
        for (int i = 0; i < players.size(); i++) {
            str += players.get(i) + "\n";
        }
        return str;
    }

}
