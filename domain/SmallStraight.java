package domain;

public class SmallStraight extends Category {
    //the category is also custom

    public SmallStraight() {
        super("Small Straight", 1, "Four sequential dice\r"
                + "(1-2-3-4, 2-3-4-5, or 3-4-5-6)");
        // TODO Auto-generated constructor stub
    }

    @Override
    public int score(int[] diceValues) {
        setChosen(true);
        if(diceValues[0] == 1 ||
                diceValues[0] == 2 ||
                diceValues[0] == 3) {
            int next = diceValues[0] + 1;
            int j = 1;
            boolean valid = true;
            for(int i = 2; i <= 4; i++) {
                if(diceValues[j++] == next) {
                    next++;
                }else {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                setPlayerScore(30);
                return 30;
            }
        }

        setPlayerScore(0);
        return 0;
    }

}
