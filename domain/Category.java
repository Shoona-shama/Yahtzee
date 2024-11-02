package domain;

public class Category {

    //the category structure in itself

    private String name;

    private int value;
    private String description;
    private boolean chosen;
    private int playerScore;

    public Category(String name, int value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.chosen = false;
        playerScore = 0;
    }

    public int score(int diceValues[]) {
        chosen = true;
        int sum = 0;
        for (int i : diceValues) {
            if (i == this.getValue()) {
                sum += this.getValue();
            }
        }
        this.playerScore = sum;
        return sum;
    }



    /**
     * check if the player can choose this category the category is available if it
     * is not chosen before
     *
     * @return
     */
    public boolean canChooseCategory() {
        return !chosen;
    }

    @Override
    public String toString() {
        return this.name
                + ": "
                + this.description;
    }

    public String toStringWithScore() {
        String status = "";
        if(chosen) {
            status = "XX closed";
        }
        return this.name
                + ": "
                + this.description
                + " score = "
                + playerScore
                + " "
                + status;
    }


    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
