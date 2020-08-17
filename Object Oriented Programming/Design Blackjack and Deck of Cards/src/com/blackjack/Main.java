package com.blackjack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean value = true;
        do{
            System.out.println("Welcome to Black Jack Game");
            Game game = new Game();
            game.start();
            System.out.println("wanna play again?(true/false)");
            Scanner sc = new Scanner(System.in);
            value = sc.nextBoolean();
        }while(value);

    }
}
