package domain;

//the chosen game category by the player

public class CategoryBlock {
    public Category categories[] ;
    public CategoryBlock(int diceSides) {
        init(diceSides);
    }

    private void init(int diceSides) {
        if(diceSides == 6) {
            this.categories = new Category[13];
        }else {
            this.categories = new Category[16];
        }

        int i = 0;
        categories[i++] = new Aces();
        categories[i++] = new Twos();
        categories[i++] = new Threes();
        categories[i++] = new Fours();
        categories[i++] = new Fives();
        categories[i++] = new Sixes();

        if(diceSides == 8) {
            categories[i++] = new Sevens();
            categories[i++] = new Eights();
            categories[i++] = new R2D2();
        }

        categories[i++] = new ThreeOf_A_Kind();
        categories[i++] = new FourOf_A_Kind();
        categories[i++] = new FullHouse();
        categories[i++] = new SmallStraight();
        categories[i++] = new LargeStraight();
        categories[i++] = new Yahtzee();
        categories[i++] = new Chance();
    }

    public boolean canChooseCategory(int index) {
        return categories[index - 1].canChooseCategory();
    }

    public int blockScore() {
        int sum = 0;
        for(int i = 0; i < categories.length; i++) {
            sum += categories[i].getPlayerScore();
        }
        return sum;
    }

    /**
     * show information about the chosen cateogry
     * @param i the index of category
     * @return
     */
    public String chosenCategory(int i) {
        return this.categories[i - 1].toString();
    }

    @Override
    public String toString() {
        String text = "";
        for(int i = 0; i < categories.length; i++) {
            text += (i+1);
            text += categories[i];
            text += "\n";
        }
        return text;
    }

    public String toStringWithScore() {
        String text = "";
        for(int i = 0; i < categories.length; i++) {
            text += (i+1);
            text += "- ";
            text += categories[i].toStringWithScore();
            text += "\n";
        }
        return text;
    }

    public void updateScoreOfCategory(int index, int dices[]) {
        index--;
        checkForBonus(dices);
        categories[index].score(dices);
    }

    private void checkForBonus(int dices[]) {
        int yatzeeIndex = 11;
        if(categories.length == 16) {
            yatzeeIndex = 14;
        }
        if(categories[yatzeeIndex].getPlayerScore() == 50) {
            int first = dices[0];
            for(int i = 1; i < dices.length; i++) {
                if(first != dices[i]) {
                    return;
                }
            }
            categories[yatzeeIndex].setPlayerScore(100);
        }

    }

    public boolean blockClosed() {
        boolean closed = true;
        for(int i = 0 ; i < this.categories.length; i++) {
            closed = closed && this.categories[i].isChosen();
        }
        return closed;
    }




}
