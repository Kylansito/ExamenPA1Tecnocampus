public class Capitol implements Comparable<Capitol> {
    private int durada; //mesurat en minuts
    private String titol; // Identificador: no poden haver repetits encara que
    // siguin de temporades diferents
    public Capitol(int durada, String titol){
        this.durada=durada;
        this.titol=titol;
    }
    public int compareTo(Capitol o) {
        return titol.compareTo(o.titol);
    }
    public String getTitol(){return titol;}
    public int getDurada(){return durada;}
}