public class Main {
    public static void main(String[] args) {
        Dog booblik = new Dog("Бублик");
        Cat gav = new Cat("Гав");
        Cat neGav = new Cat("неГав");

        booblik.run(400);
        booblik.run(600);
        booblik.swim(10);
        booblik.swim(22);

        gav.run(150);
        gav.run(600);
        gav.swim(10);
        gav.swim(2);

        Cat[] cats = new Cat[] {gav, neGav};
        Bowl miska = new Bowl();
        miska.addFood(1000);

        for (Cat c : cats) {
          c.eatFood(miska, 100);
            System.out.println(c.fullness);
            System.out.println(c.name);
        }

        Circle cool = new Circle(6, "blue", "red", "Михаил");
        cool.info();

        Rectangle great = new Rectangle(10,16, "Green", "White", "Stenly");
        great.info();

        Triangle love = new Triangle(10, 5,7, "Brown", "Green", "Nick");
        love.info();
    }
}
