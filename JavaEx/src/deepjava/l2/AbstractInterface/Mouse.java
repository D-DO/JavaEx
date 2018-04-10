package deepjava.l2.AbstractInterface;

public class Mouse extends Animal implements Jumpable {
    private boolean canJump = true;
   // private boolean isPredator = false;

    public Mouse() {
        super(1);
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
