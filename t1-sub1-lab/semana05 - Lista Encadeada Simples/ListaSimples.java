public class ListaSimples{

    private No primeiro; // Referência ao primeiro nó da lista
    private No ultimo; // Referência ao último nó da lista

    // 1- Método que verifica se a lista está vazia
    public boolean estaVazia(){
        return primeiro == null; // Retorna true se a lista não possuir nenhum Nó
    }

    // 2- Método que insere um novo elemento (Nó) no início da lista (primeira posição)
    public void insereInicio(int elemento){
        // Teste de Mesa = |4|5|, primeiro = |4| e ultimo = |5|
        // novo elemento = 6
        No novo = new No(elemento); // Cria um novo nó com o valor fornecido
        // novo = |6|
        if(estaVazia()){ // Se a lista estiver vazia
            ultimo = novo;
        }else{ // A lista não esta vazia
            novo.setProximo(primeiro);
            // atributo proximo do novo = |4|
            // Lista atualizada: |6| > |4| > |5|
        }
        primeiro = novo;
    }

    // 3- Método que remove o elemento (Nó) que esta no início da lista.
    public int removeInicio(){
        // tentar remover de uma lista
        if(estaVazia()) 
            throw new RuntimeException("Lista vazia, não tem o que remover");
        
        int removido = primeiro.getInfo(); // Obtém o valor do primeiro nó
        primeiro = primeiro.getProximo(); // O segundo nó se torna o primeiro

        return removido;

        // Teste de Mesa: |6| > |4| > |5|, primeiro = |6|
        // removido = primeiro.getInfo(), ou seja, removido = 6
        // |6| = |4|, Lista Atualizada: |4| > |5|, ou seja, substituimos o |6| pelo |4|
        // return 6
    }


}