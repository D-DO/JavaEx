public class Rectangle {
    public int sideA;
    public int sideB;

    public Rectangle(int x, int y) {
        super();
        sideA = x;
        sideB = y;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle))
            return false;
        Rectangle ref = (Rectangle) obj;
        return (((this.sideA == ref.sideA) && (this.sideB == ref.sideB)) ||
                (this.sideA == ref.sideB) && (this.sideB == ref.sideA));
    }


    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(10, 10);
        Rectangle r3 = new Rectangle(20, 10);
        System.out.println("r1.equals(r1) == " + r1.equals(r1));
        System.out.println("r1.equals(r2) == " + r1.equals(r2));
        System.out.println("r1.equals(r3) == " + r1.equals(r3));
        System.out.println("r2.equals(r3) == " + r2.equals(r3));
        System.out.println("r1.equals(null) == " + r1.equals(null));
    }
}

//        r1.equals(r1) == true
//        r1.equals(r2) == false
//        r1.equals(r3) == true
//        r2.equals(r3) == false
//        r1.equals(null) == false
