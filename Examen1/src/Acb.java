public interface Acb {
    void Inserir(Comparable e) throws Exception;
    // excepció si l’element a inserir ja està a l’arbre
    void Esborrar(Comparable e) throws Exception;
    // excepció si l’element a esborrar no està a l’arbre
    boolean Membre(Comparable e);
    // true si l’element està a l’arbre, fals en cas contrari
    Comparable Arrel() throws Exception;
    // Si no és buit, retorna el contingut de l’arrel, en cas
    // contrari llança una excepció
    Acb FillEsquerre();
    // tant si l’arbre this està buit com si no té fill esquerra retorna un arbre
    // buit, en cas contrari retorna el subarbre esquerra
    Acb FillDret();
    // tant si l’arbre this està buit com si no té fill dret retorna un arbre
    // buit, en cas contrari retorna el subarbre dret
    boolean ArbreBuit();
    void Buidar();

}
