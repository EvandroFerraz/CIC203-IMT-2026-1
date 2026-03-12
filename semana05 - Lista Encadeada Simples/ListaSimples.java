public class ListaSimples{

    private No primeiro; // Referência ao primeiro nó da lista
    private No ultimo; // Referência ao último nó da lista

    // Método que verifica se a lista está vazia
    public boolean estaVazia(){
        return primeiro == null; // Retorna true se a lista não possuir nenhum Nó
    }

    // Método que insere um Nó no início da lista (primeira posição)
    public void insereInicio(int elemento){
        No novo = new No(elemento); // Cria um novo nó com o valor fornecido
        if(estaVazia()){ // Se a lista estiver vazia
            ultimo = novo;
        }else{ // Se a lista não esta vazia
            novo.setProximo(primeiro);
        }
        primeiro = novo;

        // Teste de Mesa = |4|5|, primeiro = |4| e ultimo = |5|
        // elemento = 6, novo = |6|
        // A lista não está vazia, então:
        //      novo.setProximo(primeiro), tem-se que proximo de |6| é |4|
        // Lista atualizada: |6| > |4| > |5|
    }

    // Método que remove o Nó que esta no início da lista
    public int removeInicio(){
        // Se tentar remover de uma lista vazia, geramos um tratamento de exceção
        if(estaVazia()) 
            throw new RuntimeException("Lista vazia, não tem o que remover.");
        
        int removido = primeiro.getInfo(); // Obtém o valor no primeiro nó da lista, que será removido
        primeiro = primeiro.getProximo(); // O segundo nó sobrescreve o primeiro

        return removido;

        // Teste de Mesa: |6| > |4| > |5|, primeiro = |6|
        // removido = primeiro.getInfo(), ou seja, removido = 6
        // primeiro = primeiro.getProximo(); |6| é sobrescrito por |4|
        // Lista Atualizada: |4| > |5|, ou seja, substituimos o |6| pelo |4|
        // return removido = 6
    }

    // Método para inserir um nó no fim da lista
    public void insereFim (int elemento) {
        No novo = new No(elemento); // Cria um novo nó com o valor fornecido
        if (estaVazia()) { // Se a lista estiver vazia
            primeiro = novo; // O novo nó se torna o primeiro nó
        }
        else { // Caso contrário
            ultimo.setProximo(novo); // O antigo último nó aponta para o novo nó
        }
        ultimo = novo; // O novo nó se torna o último nó da lista

        // Teste de Mesa = |4|5|, primeiro = |4| e ultimo = |5|
        // elemento = 6, novo = |6|
        // A lista não está vazia, então:
        //      ultimo.setProximo(novo), tem-se que proximo de |5| é |6|
        // Lista atualizada: |4| > |5| > |6|
    }

     // Método para remover um nó do fim da lista
    public int removeFim () {
        if (estaVazia()) throw new RuntimeException("Lista vazia, não tem o que remover."); // Lança exceção se a lista estiver vazia
        
        int removido = ultimo.getInfo(); // Obtém o valor do último nó
        if (primeiro == ultimo) { // Se houver apenas um nó na lista
            primeiro = null; // A lista se torna vazia
            ultimo = null;
        }
        else { // Caso a lista tenha mais de um nó
            No runner = primeiro; // Começa pelo primeiro nó
            while (runner.getProximo() != ultimo) // Percorre até o penúltimo nó
                runner = runner.getProximo();
            
            runner.setProximo(null); // O penúltimo nó não aponta mais para o último
            ultimo = runner; // O penúltimo nó se torna o novo último nó
        }
        return removido; // Retorna o valor removido

        //Teste de Mesa: |6| > |4| > |5|, primeiro = |6| e ultimo = |5|
        // removido = ultimo.getInfo() = 5
        // No runner = primeiro = |6|
        // while(runner.getProximo() != ultimo)
        //     1 iteracao: |4| != |5|? verdadeiro, runner = |4|
        //     2 iteracao: |5| != |5|? falso, o laço encerra
        // saimos do laço com runner = |4|, que é o penúltimo nó da lista
        // runner.setProximo(null) = |4| > null, O penúltimo nó não aponta mais para o último
        // ultimo = |4|, O penúltimo nó se torna o novo último nó
        // Lista Atualizada: |6| > |4|
    }

     // Método para representar a lista como uma string
    @Override
    public String toString() {
        String s = "lista: ";
        if (estaVazia()) {
            s = s + "vazia"; // Caso a lista esteja vazia, retorna "lista: vazia"
        }
        else {
            No runner = primeiro; // Começa pelo primeiro nó
            while (runner != null) { // Percorre até o final da lista
                s = s + runner + "->"; // Adiciona cada nó à string
                runner = runner.getProximo(); // Avança para o próximo nó
            }
            s = s + runner + " \\\\"; // Indica o final da lista
        }
        return s + "\n"; // Retorna a string completa
    }
}