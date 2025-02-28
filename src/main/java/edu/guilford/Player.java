package edu.guilford;

public class Player extends Hand {
    private boolean knocked;
    private String name;
    private int life = 3;


    public Player(String name) {
        super();
        this.name = name;
        knocked = false;
    }

    public void knock() {
        knocked = true;
    }

    public boolean hasKnocked() {
        return knocked;
    }

    /**
     * calculates the score of the hand
     * The score is based on the rules of thirty-one
     * Highest sum of all cards with the same suit
     * @return the score of the hand
     */
    @Override
    public int getTotalValue() {
        int value = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            int suitValue = 0;
            for (Card card : hand) {
                if (card.getSuit() == suit) {
                    card.getRank();
                    switch (card.getRank()) {
                        case TWO:
                            suitValue += 2;
                            break;
                        case THREE:
                            suitValue += 3;
                            break;
                        case FOUR:
                            suitValue += 4;
                            break;
                        case FIVE:
                            suitValue += 5;
                            break;
                        case SIX:
                            suitValue += 6;
                            break;
                        case SEVEN:
                            suitValue += 7;
                            break;
                        case EIGHT:
                            suitValue += 8;
                            break;
                        case NINE:
                            suitValue += 9;
                            break;
                        case TEN:
                        case JACK:
                        case QUEEN:
                        case KING:
                            suitValue += 10;
                            break;
                        case ACE:
                            suitValue += 11;
                            break;
                    }
                }
            }

            if (suitValue > value) {
                value = suitValue;
            }
            
        }

        return value;
    }

    public void loseLife() {
        life--;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public Card lowCard() {
        Card lowCard = hand.get(0);
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).compareTo(lowCard) == -1) {
                lowCard = hand.get(i);
            }
        }
        return lowCard;
    }

    // toString method
    @Override
    public String toString() {
        return name + " score: " + getTotalValue() + " lives: " + getLife() + "\n" + super.toString();
    }

}
