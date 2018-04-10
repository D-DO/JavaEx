package deepjava.l2.AbstractInterface;

abstract public class Animal {
    private int weight;

    public Animal(int weight) {
        this.weight = weight;
    }

    public boolean isDangerous() {
        return isPredator() || weight > 15;
    }

    public int getWeight() {
        return weight;
    }

    abstract boolean isPredator();
}
