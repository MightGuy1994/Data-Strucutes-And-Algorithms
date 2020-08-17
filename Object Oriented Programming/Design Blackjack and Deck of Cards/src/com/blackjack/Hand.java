package com.blackjack;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
    private List<BlackJackCard> cards;
    Hand(BlackJackCard card1,BlackJackCard card2){
        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
    }

    public void addCard(BlackJackCard card){
        cards.add(card);
    }

    public List<Integer> getScore(){
        List<Integer> totals = new ArrayList<>();
        totals.add(0);
        for(BlackJackCard card : cards){
            List<Integer> newTotals = new ArrayList<>();
            for(int score : totals){
                newTotals.add(card.getId()+score);
                if(card.getId() == 1){
                    newTotals.add(11+score);
                }
            }
            totals = newTotals;
        }
        return totals;
    }

    public int resolveScore(){
        List<Integer> scores = getScore();
        int bestScore = 0;
        for(int score : scores){
            if(score<=21 && score > bestScore){
                bestScore = score;
            }
        }
        return bestScore;
    }

    public BlackJackCard randomCardValue(){
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }
}
