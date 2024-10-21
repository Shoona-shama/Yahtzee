package ui;

import facade.Game;

import java.util.Scanner;
import java.util.Arrays;
public class GameUi {

    public static void main(String[] args) {
        Game gameController;
        String highScore = Game.readHighScoreFromFile();
        if (highScore != null) {
            System.out.println("High Score: " + highScore);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of dice sides");
        int diceSides = 6;
        try {
            diceSides = scanner.nextInt();
            if ((diceSides != 8) && (diceSides != 6)) {
                diceSides = 6;
            }
        } catch (Exception e) {
            System.out.println("Dice sides is 6 as the input is wrong");
            diceSides = 6;
        }
        System.out.println("Enter the number of players");
        int players = 6;
        try {
            players = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("players are 6 as the input is wrong");
            players = 6;
        }

        gameController = new Game(players, diceSides);

        // enter the players names
        for (int i = 0; i < players; i++) {
            System.out.println("Enter name of player " + (i + 1));
            String name = scanner.next();
            gameController.initPlayers(i, name);
        }

        int rounds = 1;
        int roundsCount = 13;
        while (rounds <= roundsCount) {
            for (int playerNr = 0; playerNr < players; playerNr++) {
                System.out.println("\n******\nTurn of player " + (playerNr + 1) );

                int times = 1;
                int categoryNumber = 0;
                do {
                    int dicesValues[] = gameController.playerTryDices();
                    System.out.println("Your dices: " + Arrays.toString(dicesValues));

                    System.out.println("Choose a category");
                    System.out.println(gameController.displayPlayerCategoryBlock(playerNr));
                    int categoriesTimes = 0;
                    do {
                        System.out.println("Choose a category");
                        categoriesTimes++;
                        categoryNumber = scanner.nextInt();
                    } while ((!gameController.playerChooseCategory(playerNr, categoryNumber))&&
                            categoriesTimes != 3);


                    String result = gameController
                            .playerTryDices(playerNr, categoryNumber, dicesValues);

                    System.out.println("Your result: " + result);
                    System.out.println(gameController.playerTotalScore(playerNr));
                    times++;
                }while((gameController
                        .playerResult(playerNr, categoryNumber) == 0)&&
                        (times <= 3));

            }
            if(gameController.playerClosedBlock()) {
                break;
            }

            rounds++;
        }

        System.out.println("All players scores");
        System.out.println(gameController.playersScores());
        System.out.println("Winner is");
        System.out.println(gameController.winner());
        gameController.writeScoresToFile();
    }



}
