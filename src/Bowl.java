public class Bowl {
    private int countFood;


    public int getCountFood() {
        return countFood;
    }

    public void setCountFood(int countFood) {
        if (countFood > 0) {
            this.countFood = countFood;
        }
    }

    public boolean eatFromBowl(int eatenFood) {
        if (eatenFood > this.countFood) {
            return false;
        }
        this.countFood = this.countFood - eatenFood;
        return true;
    }

    public void addFood(int addedFood) {
        if (addedFood > 0) {
            this.countFood = this.countFood + addedFood;
        }
    }
}
