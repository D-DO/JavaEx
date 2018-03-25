public class NestedMain {
    public static void main(String[] args) {

        OuterNested.Nested nst = new OuterNested.Nested("MyNested");
        System.out.println(nst.getName());
        System.out.println(nst.getOuterName());
        System.out.println(OuterNested.out);
        System.out.println(OuterNested.Nested.nst);

        OuterNested outerNested = new OuterNested();
        System.out.println(outerNested.getName());
        System.out.println(outerNested.getStnst());

    }
}


//            MyNested
//            OUTMyNested
//            out
//            nst
//            OUTMyNested
//            stnst