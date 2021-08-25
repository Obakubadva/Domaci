package domaciNedelja5Sreda;

public class Square extends Shape{
    private int i;
    private int i1;

    public Square(String name, int i, int i1) {
        super(name);
        this.i = i;
        this.i1 = i1;
    }

    public int getI() {
        return i;
    }

    public int getI1() {
        return i1;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double circumference() {
        return 2*(i+i1);
    }

    @Override
    public double area() {
        return i*i1;
    }
    /*Constructor*/

    /*Methods*/
    //TODO


    @Override
    public String toString() {
        return super.toString();
    }
}
