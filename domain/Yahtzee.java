package domain;

public class Yahtzee extends Category {
    //the category is also custom

    public Yahtzee() {
        super("Yahtzee", 5, "All five dice the same");
        // TODO Auto-generated constructor stub
    }

    @Override
    public int score(int[] diceValues) {
        setChosen(true);
        int first = diceValues[0];
        for(int i = 1; i < diceValues.length; i++) {
            if(diceValues[i] != first) {
                setPlayerScore(0);
                return 0;
            }
        }
        setPlayerScore(50);
        return 50;
    }

}
