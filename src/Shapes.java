public interface Shapes {
    String getFillColor();
    String getBorderColor();
    double getPerimeter();
    double getArea();
    String getName();

    default void info() {
        System.out.println(getName());
        System.out.println("Периметр " + getPerimeter());
        System.out.println("Площадь " + getArea());
        System.out.println("Цвет заливки " + getFillColor());
        System.out.println("Цвет границы " + getBorderColor() +"\n");
    }
}
