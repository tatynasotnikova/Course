public class Cat extends Animal {
    public static int catCount;
    public boolean fullness;

    public Cat(String name ) {
        super.name = name;
        super.swimLim = 0;
        super.runLim = 200;
        fullness = false;
        catCount++;
    }

    public Cat(String name, boolean fullness) {
        super.name = name;
        this.fullness = fullness;
    }
    public void eatFood(Bowl bowl, int eatenFood) {
        if (this.fullness) return;
        this.fullness = bowl.eatFromBowl(eatenFood);
    }

}