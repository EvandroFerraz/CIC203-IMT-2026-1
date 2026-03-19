// herda da classe Object

public class No{
    private int info; // Armazena o valor do nó
    private No proximo; // Referência para o próximo nó da lista

    // Construtor
    public No(int info){
        setInfo(info); // Inicializa o valor do atributo info
        setProximo(null); // Inicializa a referência ao próximo nó como nulo
    }

    // Método que retorna o valor do atributo info
    public int getInfo(){
        return info;
    }

    // Método que atualiza o valor do atributo info
    public void setInfo(int info){
        this.info = info;
    }

    // Método que retorna a referência para o próximo nó
    public No getProximo(){
        return proximo;
    }

    // Método que atualiza a referência para o próximo nó
    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    // Método toString define a representação textual de um objeto da classe No
    @Override
    public String toString(){
        return "["+info+"]";
    }
}