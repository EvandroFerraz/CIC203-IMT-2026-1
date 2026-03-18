public class ListaDupla{
    private NoDuplo primeiro; // referencia ao nó que é a primeira posicao da lista
    private NoDuplo ultimo; // referencia ao nó que é a ultima posicao da lista

    // verifica se a lista esta vazia
    public boolean listaVazia(){
        return primeiro == null;
    }

    // 1- método para inserir um novo nó no inicio da lista
    public void insereInicio(int info){
        NoDuplo novo = new NoDuplo(info);

        // Teste Mesa, Lista de Entrada: [5] [6] [8] [2]
        // insereInicio(7), novo = [7], primeiro = [5]
        if(listaVazia()){ // se a lista esta vazia
            ultimo = novo;
        }else{ // se a lista não esta vazia
            novo.setProximo(primeiro); // o proximo de [7] é [5]
            primeiro.setAnterior(novo); // o anterior de [5] é [7]
            // Lista Atualizada: [7] [5] [6] [8] [2] 
        }
        primeiro = novo; // primeiro = [7]
    } 

    // 2- método para inserir um novo nó no final da lista
    // 3- método para remover o ultimo nó da lista
    // 4- método para remover o primeiro nó da lista
    // 5- classe de teste para testar a ListaDupla

    @Override
    public String toString(){
        if(listaVazia()) return "lista vazia \n";

        String s = "";
        for(NoDuplo runner = primeiro; runner != null; runner = runner.getProximo()){
            s += runner + " ";
        }
        return s + "\n";
    }
}