package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private Integer value;
    private boolean sameInitialCards = false;
    Hand(Card card1,Card card2){
        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        if(card1.getId().equals(card2.getId())){
            sameInitialCards = true;
        }
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public int getScore(){
        for(Card card: cards){
            value += card.getId();
        }
        return value;
    }

    public boolean isSameInitialCards() {
        return sameInitialCards;
    }
}
