public class Rectangle extends AbstractShape {

    double a;
    double b;

    public Rectangle(double paramA, double paramB, String paramBorderColour, String paramFillColour, String paramName) {
        this.a = paramA;
        this.b = paramB;
        super.borderColour = paramBorderColour;
        super.fillColour = paramFillColour;
        super.name = paramName;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public String getBorderColor() {
        return borderColour;
    }

    @Override
    public String getFillColor() {
        return fillColour;
    }

    @Override
    public String getName() {
        return name;
    }
}
