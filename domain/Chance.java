package domain;

public class Chance extends Category{

    //this category is random

    public Chance() {
        super("Chance", 1, "Any combination");
        // TODO Auto-generated constructor stub
    }

    @Override
    public int score(int[] diceValues) {
        int sum = 0;
        setChosen(true);
        for(int i : diceValues) {
            sum += i;
        }
        setPlayerScore(sum);
        return sum;
    }
}
