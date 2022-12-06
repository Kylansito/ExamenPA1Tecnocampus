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

    public int temporadaMesCapitols() {
     /* Troba la temporada de la sèrie que té més capítols, en cas de
    coincidència és irrellevant el valor retornat. Valors possibles
    de retorn: 1, 2, 3, .... quantesTemporades */
        int ret = 0;
        int quants = 0;

        for(int i = 0; i < quantesTemporades; i++){
            int res = temporades[i].quantsCapitols();

            if(res > quants){
                ret = i;
                quants = res;
            }
        }
        return ret + 1;
    }

    public int teCapitol(int quina, String titol) throws Exception{

        if(!temporades[quina-1].Membre(new Capitol(0, titol))){
            throw new Exception("No hi es");
        }
        return temporades[quina-1].quin(new Capitol(0, titol)).getDurada();

    }

    public String comesDiu(int durada) throws Exception {
        for(int i = 0; i < quantesTemporades; i++){
            try{
                return temporades[i].titolDe(durada);
            } catch (Exception e) {
            }
        }
        throw new Exception("No hi es");
    }


}