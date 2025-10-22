public class Triangle extends AbstractShape {
    double a;
    double b;
    double c;

    public Triangle(double paramA, double paramB, double paramC, String paramBorderColour, String paramFillColour, String paramName) {
        this.a = paramA;
        this.b = paramB;
        this.c = paramC;
        super.borderColour = paramBorderColour;
        super.fillColour = paramFillColour;
        super.name = paramName;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
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