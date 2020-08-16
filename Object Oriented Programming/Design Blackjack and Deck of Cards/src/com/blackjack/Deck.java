package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<BlackJackCard> cards;
    Deck() {
        this.cards = new ArrayList<>();
        for (SUIT suit : SUIT.values()) {
            for (int i = 1; i < 13; i++) {
                cards.add(new BlackJackCard(suit, i));
            }
        }
    }

    public List<BlackJackCard> getCards() {
        return cards;
    }
}
