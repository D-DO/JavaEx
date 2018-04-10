package deepjava.l2.AbstractInterface;

public class Main {
    public static void main(String[] args) {
//        deepjava.l2.AbstractInterface.Animal animal = new deepjava.l2.AbstractInterface.Animal();  Mistake


        Elephant elephant =  new Elephant();
        boolean isDangerous = elephant.isDangerous();
        boolean isPredator = elephant.isPredator();
        boolean isJump = elephant.canJump();
        if (elephant.canJump()){
            jump(elephant);
        }


        Jumpable mouse = new Mouse();
//         isDangerous = jumpable.isDangerous();
//         isPredator = jumpable.isPredator();
           isJump = mouse.canJump();
        if (mouse.canJump()){
            jump(mouse);
        }


    }

    public static void jump(Jumpable object){
//        deepjava.l2.AbstractInterface.Mouse mouse = object;
//        boolean isDangerous = object.isDangerous();

        if (object.canJump()) {
            ///
        }

    }
}
