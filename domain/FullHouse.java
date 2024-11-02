package domain;

public class FullHouse extends Category {

    //the category is also custom
    public FullHouse() {
        super("Full House", 3, "Three of one number and two of another");
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
                // search for the rest 2 dices
                int firstDice = 0;
                int secondDice = 0;
                for(int index = 0; index < diceValues.length; index++) {
                    if(firstDice == 0 && diceValues[index] != diceValues[i]) {
                        firstDice = diceValues[index];
                        continue;
                    }

                    if(diceValues[index] != diceValues[i]) {
                        secondDice = diceValues[index];
                        break;
                    }
                }
                if(firstDice == secondDice)
                    found3SameValues = true;

            }
        }

        if(!found3SameValues) {
            setPlayerScore(0);
            return 0;
        }

        setPlayerScore(25);
        return 25;
    }


}
