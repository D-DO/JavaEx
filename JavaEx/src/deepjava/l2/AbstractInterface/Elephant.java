package deepjava.l2.AbstractInterface;

public class Elephant extends Animal implements Jumpable {
    private boolean canJump = false;
    //private boolean isPredator = false;

    public Elephant() {
        super(200);
    }

    @Override
    boolean isPredator() {
        return false;
    }

    @Override
    public boolean canJump() {
        return canJump;
    }
}
