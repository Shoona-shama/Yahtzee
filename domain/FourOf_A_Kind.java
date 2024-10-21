package domain;

public class FourOf_A_Kind extends Category{
    public FourOf_A_Kind() {
        super("Four Of A Kind", 4, "At least four dice the same");
        // TODO Auto-generated constructor stub
    }

    @Override
    public int score(int[] diceValues) {
        setChosen(true);
        boolean found4SameValues = false;
        for(int i = 0; i < diceValues.length; i++) {
            int same = 0;
            for(int j = 0; j < diceValues.length; j++) {
                if(diceValues[j] == diceValues[i]) {
                    same++;
                }
            }
            if(same == this.getValue()) {
                found4SameValues = true;
                break;
            }
        }

        if(!found4SameValues) {
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
