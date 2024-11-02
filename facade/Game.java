package facade;

import domain.Dices;
import domain.Player;

import java.io.*;
import java.util.Arrays;

public class Game {

    //this is the game functionality
    private final String fileName = "scores.txt";
    Player players[];
    Dices dices;

    public Game(int playersCount, int diceSides) {
        this.players = new Player[playersCount];
        this.dices = new Dices(diceSides);
    }

    public void initPlayers(int index, String name) {
        players[index] = new Player(name, dices.sides);
    }

    public boolean playerChooseCategory(int index, int category) {
        return players[index].canChooseCategory(category);
    }

    public boolean playerClosedBlock() {
        for(int i = 0; i < this.players.length; i++) {
            if(players[i].blockClosed()) {
                return true;
            }
        }
        return false;
    }

    public int [] playerTryDices() {
        int values[] = Dices.dicesValues();
        return values;
    }

    public String playerTryDices(int index, int category, int [] values) {
        String text = Arrays.toString(values);
        text += "\n";
        text += players[index].playerTryDices(values, category);
        return text;
    }

    public String playerTryDices(int index, int category) {
        int values[] = this.dices.dicesValues();
        String text = Arrays.toString(values);
        text += "\n";
        text += players[index].playerTryDices(values, category);
        return text;
    }

    public int playerResult(int player, int category) {
        return players[player].categoryResult(category);
    }

    public String playerTotalScore(int player) {
        return players[player].totalScore();
    }

    public String dicesValuesToString() {
        return Arrays.toString(this.dices.dicesValues());
    }

    public String displayPlayerCategoryBlock(int index) {
        return players[index].toString();
    }

    public String playersScores() {
        int[] scores = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            scores[i] = players[i].getScore();
        }

        return Arrays.toString(scores);
    }

    public String winner() {
        int max = -1;
        Player winner = null;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() > max) {
                max = players[i].getScore();
                winner = players[i];
            }
        }

        return winner.getName() + "****" + winner.totalScore();
    }

    public void writeScoresToFile() {

        int max = -1;
        Player winner = null;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() > max) {
                max = players[i].getScore();
                winner = players[i];
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(winner.getName() + " " + winner.getScore() + " -> " + winner.getDate().toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block

        }

    }

    public static String readHighScoreFromFile() {
        String file = "scores.txt";
        String text = null;
        try {
            BufferedReader reader = new BufferedReader
                    (new FileReader(file));
            text = reader.readLine();
            reader.close();
        }catch(IOException e) {

        }
        return text;
    }



}
