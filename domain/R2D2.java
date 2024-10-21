package domain;

public class R2D2 extends Category {
    public R2D2() {
        super("R2D2", 2, "1 8 2 4 2");
        // TODO Auto-generated constructor stub
    }

    @Override
    public int score(int[] diceValues) {
        setChosen(true);
        if(diceValues[0] != 1) {
            return 0;
        }
        if(diceValues[1] != 8) {
            return 0;
        }
        if(diceValues[2] != 2) {
            return 0;
        }
        if(diceValues[3] != 4) {
            return 0;
        }
        if(diceValues[4] != 2) {
            return 0;
        }
        setPlayerScore(42);
        return 42;
    }


}
