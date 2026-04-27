public class ArvoreBinariaBusca{

    private No raiz; // referencia ao nó raiz da árvore

    // construtor padrão do java

    // verifica se a árvore está vazia
    public boolean arvoreVazia(){
        return raiz == null;
    }

    // inserir um nó na árvore
    public void insere(int info){
        No novo = new No(info);
        if(arvoreVazia()) raiz = novo;
        else // já existe pelo menos um nó
            insereRec(novo,raiz); // começamos a percorrer a árvore comparando o novo com a raiz      
    }
    public void insereRec(No novo, No atual){
        // Caso1: novo > atual
        if(novo.getInfo() > atual.getInfo()){ // vamos para a subarvore direita
            if(atual.getDireita() == null)
                // se existe espaço a direita do atual, inserimos o novo ali
                atual.setDireita(novo);
            else // se não existe espaço a direita do atual
            // chamamos o método recursivo para descer mais um nível na árvore,
            // agora comparando o novo com a direita do atual
            insereRec(novo, atual.getDireita());
        }else{ // Caso2: novo <= atual; vamos para a subarvore esquerda
            if(atual.getEsquerda() == null)
                atual.setEsquerda(novo);
            else
                insereRec(novo, atual.getEsquerda());
        }
    }

    // percorrer a árvore e imprimir os valores presentes nela
    public String toString(){
        if(arvoreVazia()) return "arvore vazia";
        return stringEmOrdemRec(raiz); // percorrer recursivamente a partir da raiz
    }

    // Percorrer Em Ordem
    String stringEmOrdemRec(No atual){
        String s = "";
        //1 - Acessa a Esquerda, menores
        if(atual.getEsquerda() != null) // se existe um nó a esquerda do atual
            s += stringEmOrdemRec(atual.getEsquerda());
        //2 - Acessa o Atual, próprio valor do nó
        s += atual;
        //3 - Acessa a Direita, maiores
        if(atual.getDireita() != null) // se existe um nó a direita do atual
            s += stringEmOrdemRec(atual.getDireita());
        return s;
    }
}