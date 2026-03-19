public class ListaDupla{
    private NoDuplo primeiro; // referencia ao nó que é a primeira posicao da lista
    private NoDuplo ultimo; // referencia ao nó que é a ultima posicao da lista

    // verifica se a lista esta vazia
    public boolean listaVazia(){
        return primeiro == null;
    }

    // Método para inserir um novo nó no inicio da lista
    public void insereInicio(int info){
        NoDuplo novo = new NoDuplo(info);
        if(listaVazia()){
            ultimo = novo;
        }else{ // se a lista não esta vazia
            // lista inicial: [5] [6] [8] [2]
            // insereInicio(7), novo = [7] e primeiro = [5]
            novo.setProximo(primeiro); // o proximo de [7] é [5]
            primeiro.setAnterior(novo); // o anterior de [5] é [7]
        } // lista atualizada: [7] [5] [6] [8] [2] 
        primeiro = novo; // primeiro = [7]
    }
    
    // Método para inserir um novo nó no fim da lista
    public void insereFim(int info){
        NoDuplo novo = new NoDuplo(info);
        if(listaVazia()){
            primeiro = novo;
        }else{ // se a lista não esta vazia
            // lista inicial: [5] [6] [8] [2]
            // insereInicio(7), novo = [7] e ultimo = [2]
            novo.setAnterior(ultimo); // o anterior de [7] é [2]
            ultimo.setProximo(novo); // o proximo de [2] é [7]
        } // lista atualizada: [5] [6] [8] [2] [7]
        ultimo = novo; // ultimo = [7]
    }

    public int removeInicio(){
        if(listaVazia()) throw new RuntimeException("lista vazia, nao existem nos para remover.");
        int info = primeiro.getInfo();
        if(primeiro == ultimo){ // se existe somente um nó, atribuimos nulo para "primeiro" e "ultimo" esvaziando a lista
            primeiro = null;
            ultimo = null;
        }else{ // existe mais de um nó
            // lista inicial: [2] [3] [5], o nó que será removido será o [2]
            // sobrepoe o primeiro nó com o segundo nó
            primeiro = (NoDuplo)primeiro.getProximo(); // sobrepoe [2] com o [3]
            primeiro.setAnterior(null); // agora que o [3] é o primeiro da lista, seu atributo anterior deve ser nulo
        }
        return info;
    }

    public int removeFim(){
        if(listaVazia()) throw new RuntimeException("lista vazia, nao existem nos para remover");
        int info = ultimo.getInfo();
        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;
        }else{ // existe mais de um nó
            // lista inicial: [2] [3] [5], o nó que será removido será o [5]
            // sobrepoe o ultimo nó com o penultimo nó
            ultimo = (NoDuplo)ultimo.getAnterior(); // sobrepoe o [5] com o [3]
            ultimo.setProximo(null); // agora que o [3] é o ultimo da lista, seu atributo proximo deve ser nulo
        }
        return info;
    }

    @Override
    public String toString(){
        if(listaVazia()) return "lista vazia \n";

        String s = "";
        for(NoDuplo runner = primeiro; runner != null; runner = (NoDuplo)runner.getProximo()){
            s += runner + " ";
        }
        return s + "\n";
    }
}