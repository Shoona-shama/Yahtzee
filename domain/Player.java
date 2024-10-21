package domain;

import java.time.LocalDate;

public class Player {

    private String name;
    private int score;
    private LocalDate date;
    private CategoryBlock block;

    public Player(String name, int diceSides) {
        score = 0;
        this.name = name;
        block = new CategoryBlock(diceSides);
    }

    public boolean canChooseCategory(int index) {
        return block.canChooseCategory(index);
    }

    public String playerTryDices(int values[], int category) {
        block.updateScoreOfCategory(category, values);
        updateScore();
        return block.categories[category-1].toStringWithScore();
    }

    public int categoryResult(int category) {
        return block.categories[category-1].getPlayerScore();
    }

    public void updateScore() {
        this.score = block.blockScore();
        this.date = LocalDate.now();
    }

    public String totalScore() {
        return "Total Score: "
                + this.score;
    }

    //public String toString
    @Override
    public String toString() {
        String text = name
                + "\n******\n"
                + block.toStringWithScore();
        return text;
    }

    public boolean blockClosed() {
        return this.block.blockClosed();
    }

    public CategoryBlock getBlock() {
        return block;
    }
    public void setBlock(CategoryBlock block) {
        this.block = block;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }



}
