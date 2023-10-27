public class Main {
    public static void main(String[] args) {
        SymbolTable<Symbol> st = new HashTable<>();

        st.add("x", new Symbol("x", "identifier", "INT"));
        st.add("y", new Symbol("y", "identifier", "REAL"));
        st.add("5", new Symbol("5", "constant", "INT"));
        st.add("x", new Symbol("x", "identifier", "REAL"));

        System.out.println(st.get("x"));
        System.out.println(st.get("y"));
        System.out.println(st.get("5"));

        System.out.println(st.find("x"));
        System.out.println(st.find("5"));
        System.out.println(st.find("15"));
    }

    public static class Symbol {
        private String name;
        private String type;
        private String dataType;

        public Symbol(String name, String type, String dataType) {
            this.name = name;
            this.type = type;
            this.dataType = dataType;
        }

        @Override
        public String toString() {
            return "Symbol{name='" + name + "', type='" + type + "', dataType='" + dataType + "'}";
        }
    }
}
