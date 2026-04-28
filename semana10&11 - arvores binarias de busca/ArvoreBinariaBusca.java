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

    public void insereRec(No novo, No atual){
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

    // método de inserção que não insere valores repetidos na árvore
    public void insereRepeticao(int info){
        NoRepeticao novo = new NoRepeticao(info);
        if(arvoreVazia()) raiz = novo;
        else insereRepeticaoRec(novo, raiz);
    }

    public void insereRepeticaoRec(No novo, No atual){
        // comando de cast
        NoRepeticao noAtualRepeticao = (NoRepeticao)atual;

        // Caso1: info de novo já existe na árvore, então
        // incrementamos o valor de ocorrencias do nó atual
        if(atual.getInfo() == novo.getInfo()){
            noAtualRepeticao.setOcorrencias(noAtualRepeticao.getOcorrencias() + 1);
        }
        // Caso2: novo é maior que atual, seguimos pela subárvore direita
        else if(novo.getInfo() > atual.getInfo()){
            if(atual.getDireita() == null){ // existe espaço a direita do atual
                atual.setDireita(novo); // então inserimos novo a direita do atual
            }else{ // já existe um nó a direita do atual
                // descemos um nivel na arvore agora comparando novo com a direita do atual
                insereRepeticaoRec(novo, atual.getDireita());
            }
        }
        // Caso3: novo é menor do que o atual, seguimos pela subárvore esquerda
        else{
            if(atual.getEsquerda() == null){ // existe espaço a esquerda do atual
                atual.setEsquerda(novo); // então inserimos novo a esquerda do atual
            }else{ // já existe um nó a esquerda do atual
                // descemos um nivel na arvore agora comparando novo com a esquerda do atual
                insereRepeticaoRec(novo, atual.getEsquerda());
            }
        }
    }

    // método recursivo para percorrer a árvore e inserir novo na posição correta
    
    // Percorre e imprime os nós da árvore (sobrescrita do método toString())
    //@Override
    public String toString(){
        if(arvoreVazia()) return "arvore vazia";
        return stringEmOrdemRec(raiz);
    }
    // Percorrer Em Ordem
    String stringEmOrdemRec(No atual){
        String s = "";
        // 1- Acessa a Esquerda
        if(atual.getEsquerda() != null) // se existe um nó a esquerda do atual
            s += stringEmOrdemRec(atual.getEsquerda());
        // 2- Acessa o Atual
        s += atual;
        // 3- Acessa a Direita
        if(atual.getDireita() != null) // se existe um nó a direita do atual
            s += stringEmOrdemRec(atual.getDireita());
        return s;
    }
}