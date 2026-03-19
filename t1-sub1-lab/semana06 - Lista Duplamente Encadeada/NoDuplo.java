// herda os atributos info e proximo de No
// herda os getters, setters e toString de No
public class NoDuplo extends No {

    private No anterior; // referência para o nó anterior da lista

    public NoDuplo(int info) {
        super(info); // executa o construtor da classe mãe, repassando o parâmetro info
    }

    // get = retorna o valor do atributo
    public No getAnterior() {
        return anterior;
    }

    // set = atualiza o valor do atributo
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}