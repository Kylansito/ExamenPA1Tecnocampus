public class Serie extends Produccio {
    private int quantesTemporades;
    private AcbEnll temporades[];

    public Serie(String titol, int any, int temporades) throws IllegalArgumentException{
        super(titol, Produccio.serie, any);

        if(temporades > 0) {
            this.temporades = new AcbEnll<>[temporades];
            for(int i = 0; i<temporades;i++){
                this.temporades[i] = new AcbEnll();
            }
            this.quantesTemporades = temporades;
        }else{throw new IllegalArgumentException("Temporades invalides");}
    }

    public int getQuantesTemporades() {
        return this.quantesTemporades;
    }

    public boolean afegirCapitol(int temporada, Capitol ca) {
        try {
            temporades[temporada-1].Inserir(ca);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarCapitol(Capitol ca) {
        for(AcbEnll a : temporades){
            try{
                a.Esborrar(ca);
                return true;
            }catch (Exception e){
            }
        }
        return false;
    }

}