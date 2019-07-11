package br.uff.qet.cardgame;

public class Card {
    private Suit suit;
    private Level value;

    public Card(Level value) {
        this.value = value;
        this.suit = Suit.CLUBS;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Level getType() {
        return value;
    }

    public int getValue() {
        return value.getValue();
    }
}
