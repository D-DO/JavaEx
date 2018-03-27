public class Singl {
    private static Singl ourInstance = new Singl();

    public static Singl getInstance() {
        return ourInstance;
    }

    private Singl() {
    }
}
