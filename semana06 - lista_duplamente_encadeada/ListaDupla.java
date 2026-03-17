public class ListaDupla{
    private NoDuplo primeiro; // referencia para a primeira posicao da lista
    private NoDuplo ultimo; // referencia para a ultima posicao da lista

    // utilizaremos o construtor padrão do java

    // 1- método que insere um novo elemento no inicio
    public void insereInicio(int elemento){
        NoDuplo novo = new NoDuplo(elemento); // novo.info = elemento, novo.anterior = novo.proximo = null

        // [2] [3] [5]
        // insereInicio(7)
        if(listaVazia()){ // se a lista esta vazia
            ultimo = novo;
        }else{ // se a lista não esta vazia
            novo.setProximo(primeiro); // [7].setProximo([2])
            primeiro.setAnterior(novo); // [2].setAnterior([7]), Lista Atualizada: [7] > [2] > [3] > [5]
        }
        primeiro = novo;
    }

    // 2- método que insere um novo elemento no final
    public void insereFim(int elemento){
        NoDuplo novo = new NoDuplo(elemento);

        // [2] [3] [5]
        // insereFim(7)
        if(listaVazia()){ // se a lista vazia, novo é o primeiro e ultimo pois passar a ser o único nó da lista
            primeiro = novo;
        }else{ // se a lista não esta vazia
            novo.setAnterior(ultimo); // [7].setAnterior([5])
            ultimo.setProximo(novo); // [5].setProximo([7]), Lista Atualizada: [2] > [3] > [5] > [7]
        }
        ultimo = novo; // ultimo = [7]
    }

    // 3- método que remove um elemento do inicio da lista
    public int removeInicio(){
        if(listaVazia()) throw new RuntimeException("lista vazia, não existem nós para remover.");

        int elemento = primeiro.getInfo();

        if(primeiro == ultimo){ // se existe somente um nó na lista
            primeiro = null;
            ultimo = null;
        }else{ // existem pelo menos dois nós na lista
            // lista inicial: [2] [3] [5], o nó que será removido é o primeiro que é o [2]
            primeiro = primeiro.getProximo(); // sobrepor o nó [2] pelo nó [3], então primeiro passa ser igual a [3]
            primeiro.setAnterior(null); // agora que [3] é o primeiro da lista, seu atributo anterior deve ser nulo
        }
        return elemento;
    }

    // 4- método que remove um elemento do final da lista
    public int removeFim(){
        if(listaVazia()) throw new RuntimeException("lista vazia, nao existem nos para remover.");
        
        int elemento = ultimo.getInfo();

        if(primeiro == ultimo){ // se existe somente um nó na lista
            primeiro = null;
            ultimo = null;
        }else{ // existem pelo menos dois nós na lista
            ultimo = ultimo.getAnterior(); // sobrescreve o ultimo pelo penultimo da lista; o penultimo se torna o novo ultimo
            ultimo.setProximo(null); // para indicar que o novo ultimo esta ao final da lista, seu atributo proximo deve ser nulo
        }
        return elemento;
    }

    // 5- classe de teste para testar a ListaDupla

    // getters
    public NoDuplo getPrimeiro(){
        return primeiro;
    }
    public NoDuplo getUltimo(){
        return ultimo;
    }
    // setters
    public void setPrimeiro(NoDuplo primeiro){
        this.primeiro = primeiro;
    }
    public void setUltimo(NoDuplo ultimo){
        this.ultimo = ultimo;
    }

    // retorna true se a lista estiver vazia
    public boolean listaVazia(){
        return primeiro == null;
    }

    // define a representação textual de objetos da classe ListaDupla
    @Override
    public String toString(){
        if(listaVazia()) return "lista vazia \n";

        String s = "";

        // runner inicialmente referencia a primeira posicao da lista
        for(NoDuplo runner = primeiro; runner != null; runner = runner.getProximo()){
            s += runner + " ";
        }
        return s + "\n";
    }
}