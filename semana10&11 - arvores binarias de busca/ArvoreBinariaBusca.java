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

    //1 - calcula a altura da arvore
    // Altura da Arvore: O numero de niveis no caminho mais longo da raiz ate as folhas.
    public int altura(){
        // Se a arvore está vazia ou se a raiz é um folha (sem filhos, raiz é o único nó), a altura é 0
        if(arvoreVazia() || (raiz.getEsquerda() == null && raiz.getDireita() == null))
            return 0;
        
        // Caso contrário, chama o método recursivo para calcular a altura a partir da raiz
        return alturaRec(raiz);
    }
    private int alturaRec(No atual){
        // Caso Base (critério de parada): se o no for uma folha, retorna 0
        if(atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;
        
        // Incializa variáveis para armazenar as alturas das subárvores direita e esquerda
        int alturaEsquerda=0, alturaDireita=0;

        // Se existe uma subárvore esquerda, chamamos o método recursivo para ela
        if(atual.getEsquerda() != null)
            alturaEsquerda = alturaRec(atual.getEsquerda());
        
        // Se existe uma subárvore direita, chamamos o método recursivo para ela
        if(atual.getDireita() != null)
            alturaDireita = alturaRec(atual.getDireita());

        // Retorna a maior altura entre a esquerda e a direita do nó atual, incrementando a altura em + 1 (nível do nó atual)
        // Note que altura de um nó é igual a maior altura entre seus filhos, incrementada em +1
        return alturaDireita > alturaEsquerda ? alturaDireita + 1 : alturaEsquerda + 1;    
    }


    //2- conta quantos nós a arvore tem
    public int contaNos(){
        if(arvoreVazia()) return 0; // Se a árvore está vazia, então não possui nós

        return contaNosRec(raiz);
    }

    private int contaNosRec(No atual){
        int nos = 0; // guarda o número de nós atual

        // Percorre primeiro as subárvores esquerdas e depois as direitas
        if(atual.getEsquerda() != null) // se existe um filho a esquerda
            nos += contaNosRec(atual.getEsquerda());
        
        if(atual.getDireita() != null)
            nos += contaNosRec(atual.getDireita());

        // Para cada chamada recursiva, que teremos uma para cada nó, incrementamos a variável nos em +1
        return nos + 1;

        /**
         *        8
         *       /
         *      5
         *     / \   
         *    2   6
         * 1 chamada: contaNosRec(8), chamada recursiva para o filho esquerdo: contaNosRec(5)
         * 2 chamada: contaNosRec(5), chamada recursiva para os 2 filhos: 3 chamada: contaNosRec(2) e 4 chamada: contaNosRec(6)
         * temos entao 4 chamadas recursivas empilhadas, voltamos resolvendo em ordem decrescente:
         * 4 chamada é resolvida: contaNosRec(6), retorna 1 para a chamada 2
         * 3 chamada é resolvida: contaNosRec(2), retorna 1 para a chamada 2
         * 2 chamada é resolvida: recebe 2 (da 3 e 4 chamada) e retorna esse valor + 1, retorna 3 para a 1 chamada
         * 1 chamada é resolvida: recebe 3 (da 2 chamada) e retorna esse valor + 1, retorna 4, sendo o numero de nos da arvore
         */
    }

    //3- remover um nó da árvore
    
}
