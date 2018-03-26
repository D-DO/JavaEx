package Anonim.A01;


interface Iout {
    void interfPrint();
}

class External {
    String str = "External";

    void extPrint() {
        System.out.println("ExtPrint");
    }
}

public class Outer {
    String str = "Outer";

    void outPrint(){
        Iout iout = new Iout() {
            @Override
            public void interfPrint() {
                System.out.println("interfPrint");
            }
        };
        iout.interfPrint();
    }

    void extPint(){
        External ext = new External(){
            String str = "Anonimouse";
            void extPrint(){
                System.out.println();
                System.out.println("AnonimousePrint");
                super.extPrint();
                System.out.println("AnonimStr:"+ str);
                System.out.println("super str:"+ super.str);
                System.out.println("Outer.this str: "+ Outer.this.str);
            }
        };
        ext.extPrint();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outPrint();
        outer.extPint();
    }
}

//            interfPrint
//
//            AnonimousePrint
//            ExtPrint
//            AnonimStr:Anonimouse
//            super str:External
//            Outer.this str: Outer

