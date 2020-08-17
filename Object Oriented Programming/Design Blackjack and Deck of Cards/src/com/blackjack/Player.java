package com.blackjack;

public class Player {
    private Hand hand;
    Player(Hand hand){
        this.hand = hand;
    }
    public int score(){
        return hand.resolveScore();
    }

    public Hand getHand() {
        return hand;
    }
}
