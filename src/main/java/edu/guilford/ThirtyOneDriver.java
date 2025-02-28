package edu.guilford;

import java.util.Scanner;

public class ThirtyOneDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players are there? (2-16)");
        int n = scanner.nextInt();
        ThirtyOneGame game = new ThirtyOneGame(n);
        System.out.println(game);
        while (game.isGameOver() == false) {
            game.playRound();
            System.out.println(game);
            
        }
        
    }
}
