package core.basesyntax;

public class IsoscelesTrapezoid extends Figure {
    private double height;
    private double side;
    private double higherBase;

    public IsoscelesTrapezoid() {
        double defaultSide = 5;
        double defaultHeight = 4;
        height = defaultHeight;
        side = defaultSide;
        higherBase = defaultSide;
    }

    public IsoscelesTrapezoid(String color) {
        super(color);
        height = 4;
        side = 5;
        higherBase = 5;
    }

    public IsoscelesTrapezoid(String color, double height, double side, double higherBase) {
        super(color);
        if (side > height) {
            this.height = height;
            this.side = side;
        } else if (side == height) {
            double forCaseWhenSideEqualsHeigth = 1.0;
            this.height = height;
            this.side = (side + forCaseWhenSideEqualsHeigth);
        } else {
            this.height = side;
            this.side = height;
        }
        this.higherBase = higherBase;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < side) {
            this.height = height;
        }
        else {
            System.out.println("ERROR: height must be smaller than side.");
        }
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side > height) {
            this.side = side;
        }
        else {
            System.out.println("ERROR: side must be larger than height.");
        }
    }

    public double getHigherBase() {
        return higherBase;
    }

    public void setHigherBase(double higherBase) {
        this.higherBase = higherBase;
    }

    public double getLowerBase() {
        return higherBase + (2 * (Math.sqrt((side * side) - (height * height))));
    }

    @Override
    public void draw() {
        System.out.println("" + getColor() + " isosceles trapezoid with area of "
                + area() + " sq.units, lower base of " + getLowerBase() + " units, higher base of "
                + higherBase + " units, height of " + height + " units and sides of " + side + " units");
    }
    @Override
    public double area() {
        return ((getHigherBase() + getLowerBase()) * getHeight()) / 2;
    }
}