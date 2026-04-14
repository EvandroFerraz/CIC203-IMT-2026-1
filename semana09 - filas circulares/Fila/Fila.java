public class Fila{
    // atributos
    private No primeiro;
    private No ultimo;

    // construtor padrão
    // não precisamos controlar a capacidade na fila "padrão" (não circular)

    // verifica se a fila esta vazia
    public boolean filaVazia(){
        return primeiro == null;
    }

    // FIFO = first in, first out
    // insere na ultima posição = enfileira()
    // 4 - 7 - 8 - 19, primeiro = 4 e ultimo = 19
    // enfileira(12), novo = [12] e deve ser inserido no fim
    // ultimo.setProximo(novo) = próximo do [19] é o [12], ou seja,
    // [12] agora é o último.
    public void enfileira(int e){
        No novo = new No(e); // proximo = null
        if(filaVazia()){ // quer dizer que a lista passará a ter um único elemento
            primeiro = novo;
        }else{ // se a fila não está vazia
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    // remove no inicio = desinfileira()
    public int desinfileira(){
        if(filaVazia()) throw new RuntimeException("Falha na remoção - fila vazia");

        int temp = primeiro.getInfo();
        // sobrescrevo a primeira posição da fila com a segunda
        // fila = [2], primeiro = [2] e ultimo = [2], proximo de [2] é nulo
        primeiro = primeiro.getProximo(); // sobrescreve [2] com null
        // primeiro = null, ultimo = [2]
        if(primeiro == null)  // se esvaziou a fila
            ultimo = null; // retirando a referência para liberar memória
        
        return temp;
    }

    // representação textual para objetos da classe Fila
    public String toString(){
        if(filaVazia()) return "fila vazia";
        
        String s = "";
        No runner = primeiro;

        while(runner != null){
            s += runner + "->";
            runner = runner.getProximo();
        }
        return s;
    }
}


class No{
    private int info;
    private No proximo;

    // construtor
    public No(int info){
        this.info = info;
        proximo = null;
    }

    //getters/setters
    public int getInfo(){
        return info;
    }
    public No getProximo(){
        return proximo;
    }
    public void setInfo(int info){
        this.info = info;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    // sobrescrita toString()
    // @Override
    public String toString(){
        return "[" + info + "]";
    }
}