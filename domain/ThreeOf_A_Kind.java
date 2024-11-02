package domain;

public class ThreeOf_A_Kind extends Category {

    //the category is also custom

    public ThreeOf_A_Kind() {
        super("Three Of A Kind", 3, "At least three dice the same");
        // TODO Auto-generated constructor stub
    }

    @Override
    public int score(int[] diceValues) {
        setChosen(true);
        boolean found3SameValues = false;
        for(int i = 0; i < diceValues.length; i++) {
            int same = 0;
            for(int j = 0; j < diceValues.length; j++) {
                if(diceValues[j] == diceValues[i]) {
                    same++;
                }
            }
            if(same == this.getValue()) {
                found3SameValues = true;
                break;
            }
        }

        if(!found3SameValues) {
            setPlayerScore(0);
            return 0;
        }

        int sum = 0;
        for(int i : diceValues) {
            sum += i;
        }

        setPlayerScore(sum);
        return sum;
    }


}
