package com.blackjack;

public class Card {
    private SUIT suit;
    private Integer id;

    Card(SUIT suit,Integer id){
        this.id = id;
        this.suit = suit;
    }

    public SUIT getSuit() {
        return suit;
    }

    public Integer getId() {
        return id;
    }
}
