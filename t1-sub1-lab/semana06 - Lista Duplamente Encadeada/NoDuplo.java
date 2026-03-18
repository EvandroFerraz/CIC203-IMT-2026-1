// herda de Object
public class NoDuplo{

    // encapsulamento
    private int info; // guardar o valor do nó
    private NoDuplo proximo; // referência para o próximo nó da lista
    private NoDuplo anterior; // referência para o nó anterior da lista

    /// construtor que inicializa o atributo info
    public NoDuplo(int info){
        this.info = info;
    }

    // getters = retornam o valor de um atributo
    public int getInfo(){
        return info;
    }
    public NoDuplo getProximo(){
        return proximo;
    }
    public NoDuplo getAnterior(){
        return anterior;
    }
    // setters = atualiza o valor do atributo
    public void setInfo(int info){
        this.info = info;
    }
    public void setProximo(NoDuplo proximo){
        this.proximo = proximo;
    }
    public void setAnterior(NoDuplo anterior){
        this.anterior = anterior;
    }

    @Override // sobrescrita do método toString()
    public String toString(){ // define a representação textual de um objeto da classe
        return "["+info+"]";
    }
}