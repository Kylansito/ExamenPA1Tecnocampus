public class Plataforma {
        private class NodeAny {
            NodeProd inf;
            int any;
            NodeAny seg;
            public NodeAny(int any) {
                inf = null;
                seg = null;
                this.any = any;
            }
        } // fi classe

        private class NodeProd {
            Produccio inf;
            NodeProd seg;
            public NodeProd(Produccio p, NodeProd aux) {
                inf = p;
                seg = aux;
            }
        } // fi classe


    private NodeAny prod;

    public Plataforma() {
        prod = null;
    }
    private static boolean hiEs(Produccio o, NodeProd p) {
        while(p != null){
            if(p.inf.compareTo(o) == 0){
                return true;
            }
            p = p.seg;
        }
        return false;
    }
    private NodeAny onEs(int any) {
        NodeAny aux = prod;

        while(aux != null){
            if(aux.any == any){
                return aux;
            }
            aux = aux.seg;
        }
        return null;
    }
    public void afegirProduccio(Produccio p) throws ExcepcioPlataforma {
        //Jo afegeixo darrere, la Lina afegeix davant.

        NodeAny aux = onEs(p.getAny());
        if(aux != null){
            if(hiEs(p, aux.inf)){
                throw new ExcepcioPlataforma("Ja hi es");
            }
            NodeProd aux2 = aux.inf;
            while(aux2.seg != null){
                aux2 = aux2.seg;
            }
            aux2.seg = new NodeProd(p, null);
        }else{
            aux = prod;
            while(aux.seg != null){
                aux = aux.seg;
            }
            aux.seg = new NodeAny(p.getAny());
            aux.seg.inf = new NodeProd(p, null);
        }
    }
    public int eliminarProduccio(int any) {

        NodeAny aux = onEs(any);
        int ret = 0;
        while(aux != null){
            ret++;
            aux = aux.seg;
        }

        if(prod.any == any){
            prod = prod.seg;
            return ret;
        }
        aux = prod;
        while(aux.seg.any != any){
         aux = aux.seg;
        }
        aux.seg = aux.seg.seg;
        return ret;

    }
    public String trobaTitol(int any, int durada) throws ExcepcioPlataforma {
    /* Retorna el títol d'un capítol d’una de les series de la productora que ha
    estat produïda l'any indicat en el primer paràmetre i que té una durada igual a
    la donada en el segon paràmetre. Llança una excepció si no hi ha cap*/

        NodeAny aux = prod;
        while(aux != null){
            if(aux.any == any){
                NodeProd auxP = aux.inf;
                while(auxP != null){
                    if(auxP.inf instanceof Serie){
                        try{
                            return ((Serie) auxP.inf).comesDiu(durada);
                        }catch (Exception e){
                        }
                    }
                    auxP = auxP.seg;
                }
                throw new ExcepcioPlataforma("No hi ha cap pelicula amb durada: " + durada);
            }

            aux = aux.seg;
        }
        throw new ExcepcioPlataforma("No hi ha l'any " + any + " en aquesta plataforma");

    }
}