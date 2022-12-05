import org.w3c.dom.Node;

public class AcbEnll<Capitol extends Comparable<Capitol>> implements Acb{

    private class NodeA {
        Capitol inf; //La classe Capitol la trobaràs més endavant
        NodeA esq, dret;
        public NodeA(Capitol m, NodeA e, NodeA d) {
            inf = m;
            esq = e;
            dret = d;
        }

        public NodeA(Capitol m){
            this(m, null, null);
        }

        public void inserirRecursiu(Capitol e ) throws Exception{
            if(inf.compareTo(e) > 0){
                if(esq != null){
                    esq.inserirRecursiu(e);
                }else{
                    esq = new NodeA(e);
                }
            }else if(inf.compareTo(e) < 0){
                if(dret != null){
                    dret.inserirRecursiu(e);
                }else{
                    dret = new NodeA(e);
                }
            }else{throw new Exception("L'element ja hi es");}
        }

        public boolean membreRecursiu(Capitol e){
            if(inf.compareTo(e) < 0){
                if(this.esq != null){
                    return esq.membreRecursiu(e);
                }else{
                    return false;
                }
            }else if(inf.compareTo(e)> 0){
                if(this.dret != null){
                    return dret.membreRecursiu(e);
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    private NodeA arrel;
    public AcbEnll() { arrel = null;}

    public AcbEnll(NodeA a){arrel = a;}

    @Override
    public void Inserir(Comparable e) throws Exception {
        arrel.inserirRecursiu((Capitol)e);
    }

    @Override
    public void Esborrar(Comparable e) throws Exception {

    }

    @Override
    public boolean Membre(Comparable e) {
        return arrel.membreRecursiu((Capitol) e);
    }

    @Override
    public Comparable Arrel() throws Exception {
        if (arrel == null){
            throw new Exception("Arrel nula");
        }
        return arrel.inf;
    }

    @Override
    public Acb FillEsquerre() {
        if(this != null && arrel.esq != null){
            return new AcbEnll<>(arrel.esq);
        }
        return new AcbEnll<>();
    }

    @Override
    public Acb FillDret() {
        if(this != null && arrel.dret != null){
            return new AcbEnll<>(arrel.dret);
        }
        return new AcbEnll<>();
    }

    @Override
    public boolean ArbreBuit() {
        return arrel == null;
    }

    @Override
    public void Buidar() {
        this.arrel = null;
    }
}
