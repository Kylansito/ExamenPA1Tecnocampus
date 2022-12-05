public class Produccio implements Comparable<Produccio>{
    public static final int pelicula = 0;
    public static final int documental = 1;
    public static final int concert = 2;
    public static final int serie = 3;
    private String titol; //és identificatiu
    private int tipus;
    private int any;
    public Produccio(String titol, int tipus, int any) throws IllegalArgumentException{
        /*Crea la producció quan tots els paràmetres tenen un valor correcte.
         * Si no ho són llança una excepció
         */
    }
    public int getAny() {
        return any;
    }
    public int compareTo(Produccio o) {
        return titol.compareTo(o.titol);
    }
}