public class Fila{
    private No primeiro;
    private No ultimo;

    // construtor padrão

    // verifica se a fila esta vazia
    public boolean filaVazia(){
        return primeiro == null;
    }

    // FIFO = First In, First Out
    // inserir na última posição = enfileira()
    // 4 - 7 - 8 - 19, primeiro = 4 e ultimo = 19
    // enfileira(12), novo = [12] e deve ser inserido ao final da fila
    // ultimo.setProximo(novo) = próximo do ultimo (19) é o novo (12)
    public void enfileira(int e){
        No novo = new No(e); // info = e; proximo = null
        if(filaVazia()){ // quer dizer que a fila passará a ter um único elemento
            primeiro = novo;
        }else{ // se a fila não está vazia
            ultimo.setProximo(novo); // 4 - 7 - 8 - 19 - 12, ultimo = 19, ainda não foi atualizado
        }
        ultimo = novo; // ultimo é atualizado, ultimo = 12
    }

    // remove no início = desinfileira()
    public int desinfileira(){
        if(filaVazia()) throw new RuntimeException("Fila Vazia");

        int temp = primeiro.getInfo();
        primeiro = primeiro.getProximo(); // sobrescreve primeiro pelo segundo

        if(primeiro == null) // fila esta vazia
            ultimo = null;

        return temp;
    }

    // representação textual para objetos da classe Fila
    public String toString(){
        if(filaVazia()) return "Fila Vazia";

        String s = "";
        No runner = primeiro;

        // percorrer a fila
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

    // inicializa o atributo info
    public No(int info){
        this.info = info;
        //proximo = null;
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

    //@Override
    public String toString(){
        return "[" + info + "]";
    }
}