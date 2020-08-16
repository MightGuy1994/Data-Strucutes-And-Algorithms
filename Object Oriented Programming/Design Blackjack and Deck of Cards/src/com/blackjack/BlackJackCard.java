package com.blackjack;

public class BlackJackCard extends Card{
    private Integer cardValue;
    BlackJackCard(SUIT suit, Integer id) {
        super(suit, id);
        this.cardValue = id;
        if (id > 10) {
            cardValue = 10;
        }
    }

    public Integer getCardValue() {
        return cardValue;
    }
}
