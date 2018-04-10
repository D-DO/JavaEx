package deepjava.l2.Generics;

public class OwnGenericClass<T> {
    private T value;

    public OwnGenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {

        OwnGenericClass<Integer> intObject = new OwnGenericClass<>(1);
        Integer integer = intObject.getValue();
        System.out.println(integer);

        OwnGenericClass<String> stringObject = new OwnGenericClass<>("word");
        String string = stringObject.getValue();
        System.out.println(string);

        short i = 0;
        Short in = i;
        String st = in.toString();
    }
}
