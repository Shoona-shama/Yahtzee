package domain;

import java.util.Random;

public class Dices {

    private static int values[] = new int[5];
    public static int sides = 6;
    public Dices(int sides) {
        Dices.sides =sides;
    }

    public static int[] dicesValues() {
        Random random = new Random();
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(sides) + 1;
        }
        return values;
    }


}
