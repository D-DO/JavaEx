public class OuterNested {

    static String out = "out";
    private static String outerName = "outerName";

    public OuterNested() {
    }

    public OuterNested(String name) {
        outerName = name;
        Nested.nst = "nst" + name;
    }

    public  String getName() {
        return outerName;
    }

    public  String getStnst() {
        return Nested.stnst;
    }

    // nested Class Nested
    static class Nested {
        private String nestedName;
        static String nst = "nst";
        private static String stnst = "stnst";

        public Nested(String name){
            nestedName = name;
            outerName = "OUT" + nestedName;
        }

        public void setName(String name) {
            nestedName = name;
        }

        public String getName() {
            return nestedName;
        }


        public String getOuterName() {
            return outerName;
        }
    }
}
