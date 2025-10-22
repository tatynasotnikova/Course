public class Circle extends AbstractShape{

    double radius;

    public Circle(double paramRadius, String paramBorderColour, String paramFillColour, String paramName) {
        this.radius = paramRadius;
        super.borderColour = paramBorderColour;
        super.fillColour = paramFillColour;
        super.name = paramName;
    }



    @Override
    public double getArea() {
        return 2 * radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
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
