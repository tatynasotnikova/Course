public class Dog extends Animal {

    public static int dogCount;

    public Dog(String name) {
        super.name = name;
        super.swimLim = 10;
        super.runLim = 500;
        dogCount++;
    }
}