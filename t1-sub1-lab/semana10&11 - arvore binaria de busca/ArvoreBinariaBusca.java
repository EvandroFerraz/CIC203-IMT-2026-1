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

    // 1- calcular a altura da árvore
    // Altura: o número de níveis no caminho mais longo da raiz até uma folha
    public int altura(){
        // Se a árvore está vazia ou se existe um único nó, altura = 0
        if(arvoreVazia() || (raiz.getEsquerda() == null && raiz.getDireita() == null))
            return 0;

        // Caso contrário, chama o método recursivo para calcular a altura a partir da raiz
        return alturaRec(raiz);
    }
    private int alturaRec(No atual){
        // Caso Base (critério de parada): Se o nó atual é uma folha, retorna 0
        if(atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;
        
        // Incializa variáveis para armazenar as alturas da subárvore esquerda e direita
        int alturaEsquerda = 0, alturaDireita = 0;

        // Se existe uma subárvore à esquerda, chamamos o método recursivo para ela
        if(atual.getEsquerda() != null)
            alturaEsquerda = alturaRec(atual.getEsquerda());

        // Se existe uma subárvore à direita, chamamos o método recursivo para ela
        if(atual.getDireita() != null)
            alturaDireita = alturaRec(atual.getDireita());

        // Retorna a maior altura entre os filhos esquerdo e direito, incrementada
        // em +1 (nível do nó atual)
        return alturaDireita > alturaEsquerda ? alturaDireita + 1 : alturaEsquerda + 1;
    }
    // 2- contar quantos nós a árvore tem
    /* Teste de Mesa
            8
           / 
          5
        /  \ 
       2     7 
       1ª chamada recursiva: contaNosRec(8), gera a 2ª chamada
       2ª chamada recursiva: contaNosRec(5), gera a 3ª chamada e 4ª chamada
       3ª chamada recursiva: contaNosRec(2), não tem filhos então retorna 1.
       4ª chamada recursiva: contaNosRec(7), não tem filhos então retorna 1.
       Com o resultado da 3ª e 4ª chamada, voltamos resolvendo a pilha de recursão
       - resolve a 2ª chamada: contaNosRec(5), recebe 1 como retorno da 3ª e 4ª chamada e incrementa esses valores na variável "nos", retornando o valor incrementado. Então, retorna 3.
       - resolve a 1ª chamada: contaNosRec(8), recebe o 3 como retorno da 2ª chamada e incrementa esse valor na variável "nos", retornando o valor incrementado. Então, retorna 4.
    */

    public int contaNos(){  
        if(arvoreVazia()) return 0;
        return contaNosRec(raiz); // primeira chamada = raiz da árvore
    }
    public int contaNosRec(No atual){
         int nos = 0; // guarda o número de nós atual

         // Percorremos primeiro as subárvores esquerda e depois as direitas
         if(atual.getEsquerda() != null){
            nos += contaNosRec(atual.getEsquerda());
         }
         if(atual.getDireita() != null){
            nos += contaNosRec(atual.getDireita());
         }
         return nos + 1;
    }

    // 3- remover um nó da árvore
    public boolean remove(int info){
        if(arvoreVazia()) return false;

        // Queremos remover um nó na raiz
        if(info == raiz.getInfo()){
            // Caso1: raiz não tem filhos
            if(raiz.getEsquerda() == null && raiz.getDireita() == null){ 
                raiz = null;
                return true;
            }
            // Caso2: raiz só tem filho direito
            if(raiz.getEsquerda() == null){
                raiz = raiz.getDireita(); // sobrescrevemos o nó na raiz pelo seu filho direito
                return true;
            }
            // Caso3: raiz só tem filho esquerdo
            if(raiz.getDireita() == null){
                raiz = raiz.getEsquerda(); // sobrescrevemos o nó na raiz pelo seu filho esquerdo
                return true;
            }
            // Caso4: raiz possui os 2 filhos
            No suc = sucessor(raiz);
            suc.setEsquerda(raiz.getEsquerda());
            raiz = suc;
            return true;
        }else{ // nó para remoção não é raiz, então percorremos a árvore
            if(info > raiz.getInfo()) // percorre a subárvore direita
                return removeRec(info, raiz.getDireita(), raiz, true);
            return removeRec(info, raiz.getEsquerda(), raiz, false); // percorre a subárvore esquerda
        }
    }    

    private No sucessor(No atual){
        No pai = atual;
        No suc = atual.getDireita();
        No runner = suc.getEsquerda();

        while(runner != null){
            pai = suc;
            suc = runner;
            runner = runner.getEsquerda();
        }

        if(suc != atual.getDireita()){
            pai.setEsquerda(suc.getDireita());
            suc.setDireita(atual.getDireita());
        }
        return suc;
    }

    private boolean removeRec(int info, No atual, No pai, boolean eFilhoDireita){
        if(atual == null) return false;

        // Se atual é o nó a ser removido
        if(info == atual.getInfo()){
            // Caso1: atual não tem filhos
            if (atual.getDireita() == null && atual.getEsquerda() == null){
                if(eFilhoDireita) // atual é subárvore direita
                    pai.setDireita(null); // removemos o atual atribuindo nulo à subárvore direita de seu pai
                else
                    pai.setEsquerda(null); // removemos o atual atribuindo nulo à subárvore esquerda de seu pai
                return true;
            }
            // Caso2: atual só tem um filho esquerdo
            if(atual.getDireita() == null){ // atual só tem filho esquerdo
                if(eFilhoDireita) // atual é subárvore direita
                    pai.setDireita(atual.getEsquerda()) // removemos o atual atribuindo seu filho esquerdo à direita de seu pai
                else
                    pai.setEsquerda(atual.getEsquerda()) // removemos o atual atribuindo seu filho esquerdo à esquerda de seu pai
                return true;
            }
            // Caso3: atual só tem um filho direito
            if(atual.getEsquerda() == null){
                if(eFilhoDireita)
                    pai.setDireita(atual.getDireita()); // removemos o atual atribuindo seu filho direito à direita de seu pai
                else
                    pai.setEsquerda(atual.getDireita()); // removemos o atual atribuindo seu filho direito à esquerda de seu pai
                return true;
            }
            // Caso4: atual tem os dois filhos
            No suc = sucessor(atual);
            suc.setEsquerda(atual.getEsquerda());
            if(eFilhoDireita)
                pai.setDireita(suc);
            else
                pai.setEsquerda(suc);
            return true;
        }
        // chegamos na linha 250 somente se o nó atual não é o nó que queremos remover
        if(info > atual.getInfo())
            return removeRec(info, atual.getDireita(), atual, true);
        return removeRec(info, atual.getEsquerda(), atual, false);
    }
}
