package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Properties:
    1. gameCards : List Of Cards.
    2. noOfDecks : Int
functions:
    1. getCard : Random Card from the shoe.
    2. getHand : Create Hand objects with two cards.
*/
public class Shoe {
    private List<Card> gameCards;
    private Integer noOfDecks;
    Shoe(int noOfDecks){
        this.noOfDecks = noOfDecks;
        gameCards = new ArrayList<Card>();
        for(int i = 0; i < noOfDecks;i++){
            gameCards.addAll(new Deck().getCards());
        }
    }
    public Card getCard(){
        Random random = new Random();
        Card card = gameCards.get(random.nextInt(gameCards.size()));
        gameCards.remove(card);
        return card;
    }
    public Hand getHand(){
        Random random = new Random();
        Card card1 = gameCards.get(random.nextInt(gameCards.size()));
        Card card2 = gameCards.get(random.nextInt(gameCards.size()));
        gameCards.remove(card1);
        gameCards.remove(card2);
        return new Hand(card1,card2);
    }

    public void shuffle(){
    }
}
