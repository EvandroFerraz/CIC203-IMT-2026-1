// herda o método toString() de Object
public class NoDuplo{

    private int info; // atributo que guarda a informação daquele nó
    private NoDuplo anterior; // referencia para o nó anterior
    private NoDuplo proximo; // referencia para o proximo nó

    // Construtor que inicializa somente o atributo info
    // anterior e proximo serão inicialmente nulos
    public NoDuplo(int info){
        this.info = info;
    }
    
    // getters = método que retorna o valor da atributo
    public int getInfo(){
        return info;
    }
    public NoDuplo getAnterior(){
        return anterior;
    }
    public NoDuplo getProximo(){
        return proximo;
    }
    // setters = método que atualiza o valor do atributo
    public void setInfo(int info){
        this.info = info;
    }
    public void setAnterior(NoDuplo anterior){
        this.anterior = anterior;
    }
    public void setProximo(NoDuplo proximo){
        this.proximo = proximo;
    }

    // Sobrescrever o método toString()
    // NoDuplo n = new NoDuplo(2); System.out.println(n);
    // Por padrão o toString() mostra o endereço de memória de onde o objeto esta
    @Override
    public String toString(){
        // define a forma textual de como o objeto será representado
        return "["+info+"]";
    }
}