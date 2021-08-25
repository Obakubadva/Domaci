package domaciNedelja5Sreda;

public class Circle extends Shape{
    private double r;


    public Circle(String name, double r) {
        super(name);
        this.r = r;
    }

    public double getR() {
        return r;
    }
    @Override
    public double area() {
        return Math.PI*r*r;
    }

    @Override
    public double circumference() {
        return 2*r*Math.PI;
    }
    /*Constructor*/

    /*Methods*/
    //Todo:

    @Override
    public String toString() {
        return super.toString();
    }
}
