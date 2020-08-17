package com.blackjack;

public class Dealer {
    private Hand hand;
    Dealer(Hand hand){
        this.hand = hand;
    }
    public int score(){
        return hand.resolveScore();
    }
    public int getInitialScore(){
        return hand.randomCardValue().getId();
    }

    public Hand getHand() {
        return hand;
    }
}
