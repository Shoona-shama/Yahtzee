package domain;

public class LargeStraight extends Category{
    //the category is also custom

    public LargeStraight() {
        super("Large Straight", 5, "Five sequential dice\r"
                + "(1-2-3-4-5 or 2-3-4-5-6)");
        // TODO Auto-generated constructor stub
    }

    @Override
    public int score(int[] diceValues) {
        setChosen(true);
        if(diceValues[0] == 1 ||
                diceValues[0] == 2) {
            int next = diceValues[0] + 1;
            int j = 1;
            boolean valid = true;
            for(int i = 2; i <= 5; i++) {
                if(diceValues[j++] == next) {
                    next++;
                }else {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                setPlayerScore(40);
                return 40;
            }
        }

        setPlayerScore(0);
        return 0;
    }

}
