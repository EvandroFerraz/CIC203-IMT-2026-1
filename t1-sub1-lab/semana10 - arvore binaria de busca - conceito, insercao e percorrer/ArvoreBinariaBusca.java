public class ArvoreBinariaBusca{
    private No raiz; // guarda o nó raiz da árvore

    // construtor padrão do java

    // verifica se a árvore está vazia
    public boolean arvoreVazia(){
        return raiz == null;
    }

    // insere um novo nó na árvore
    public void insere(int info){
        No novo = new No(info);
        if(arvoreVazia())
            raiz = novo;
        else // já existe pelo menos um nó, então precisamos percorrer a árvore recursivamente
            insereRec(novo, raiz);
    }

    public insereRec(No novo, No atual){
        if(novo.getInfo() > atual.getInfo()){ // iriamos para subarvore direita
            if(atual.getDireita() == null)
                // se existe espaço a direita do atual, inserimos o novo ali
                atual.setDireita(novo);
            else 
                // se não existe espaço,
                // chamamos o método recursivo atualizando o No atual
                insereRec(novo, atual.getDireita());
        }else{ // novo.getInfo() <= atual.getInfo(); iriamos para a subarvore esquerda
            if(atual.getEsquerda() == null)
                atual.setEsquerda(novo);
            else
                insereRec(novo, atual.getEsquerda());
        }
    }
    
    // percorre e imprime os nós da árvore (sobrescrita do método toString())
}