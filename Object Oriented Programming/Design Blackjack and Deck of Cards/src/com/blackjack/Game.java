package com.blackjack;

import java.util.Scanner;

public class Game {
    private Shoe shoe;
    private Player player;
    private Dealer dealer;

    Game(){
        shoe = new Shoe(2);
    }

    public void start(){
        System.out.println("Game starting......");
        System.out.println("Initializing dealer and Player....");
        player = new Player(shoe.getHand());
        dealer = new Dealer(shoe.getHand());
        System.out.println("Player Score : "+player.score());
        System.out.println("Dealer Score: "+dealer.getInitialScore());
        if(player.score() == 21){
            System.out.println("BlackJack Player WIN");
        }
        else if(dealer.score() == 21){
            System.out.println("Dealer Score : "+dealer.score());
            System.out.println("Dealer WINS");
        }
        else {
            while(player.score() <21) {
                if(player.score()==0){
                    System.out.println("Player Lost");
                    break;
                }
                System.out.println("Hit Or Stand?");
                Scanner sc = new Scanner(System.in);
                String response = sc.nextLine().toLowerCase();
                if (response.equals("stand")) {
                    stand();
                    break;
                }
                hit();
            }
        }
    }
    public void hit(){
        BlackJackCard card = shoe.getCard();
        player.getHand().addCard(card);
        System.out.println("Player Score : "+player.score());
        if(player.score()==21) {
            System.out.println("Player Wins");
        }
        else if(player.score()>21){
            System.out.println("Dealer Wins");
        }
    }
    public void stand(){
        //System.out.println("Player Score : "+player.score());
        //System.out.println("Dealer Score : "+dealer.score());
        System.out.println("-------------------------------");
        if(dealer.score() >16){
            System.out.println("Player Score : "+player.score());
            System.out.println("Dealer Score : "+dealer.score());
            if(player.score() > dealer.score()){
                System.out.println("Player WINS");
            }
            else if(player.score() < dealer.score()){
                System.out.println("Dealer WINS");
            }
            else {
                System.out.println("NO WIN");
            }
        }
        else{
            while(dealer.score()<21){
                BlackJackCard card = shoe.getCard();
                dealer.getHand().addCard(card);
                System.out.println("dealer Score : "+dealer.score());
                if(dealer.score()==0){
                    System.out.println("dealer Lost");
                    break;
                }
                if(dealer.score() ==21){
                    System.out.println("Dealer wins");
                    break;
                }
                else if(dealer.score()>21){
                    System.out.println("Player wins");
                    break;
                }
            }
        }
    }
}
