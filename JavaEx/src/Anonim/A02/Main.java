package Anonim.A02;
class External{
    public External() {
    }
    Object getThis(){
        return this;
    }
    static External aext = new External(){};
}

public class Main {
    public static void main(String[] args){
        External ext = new External();
        System.out.println("Ext.this: "+ ext.getThis());

        External anonimExt = External.aext;
        System.out.println("Anonim.this: "+anonimExt.getThis());
    }
}
//        Ext.this: Anonim.A02.External@7c30a502
//        Anonim.this: Anonim.A02.External$1@49e4cb85