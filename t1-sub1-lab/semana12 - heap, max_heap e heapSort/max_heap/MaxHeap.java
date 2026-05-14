// MaxHeap = heap de implementado em vetor com a propriedade: para todo no i diferente da raiz,
//      valores[pai(i)] >= valores[i]
// Logo, o maior elemento esta sempre na raiz (indice 0).
//
// Convencao de indices (base 0, padrao Java):
//   pai(i)            = (i - 1) / 2
//   filhoEsquerdo(i)  = 2*i + 1
//   filhoDireito(i)   = 2*i + 2
//
// Observacao sobre o material em PDF:
// O pseudocodigo do PDF usa base 1 (raiz na posicao 1). Aqui adaptamos para base 0, entao 
// "enquanto 2i <= n" vira "while (2*i + 1 < n)" e "A[1]" (a raiz) corresponde a valores[0].
public class MaxHeap{
    private int[] valores;
    private int ocupacao;

    // construtor com capacidade escolhida pelo usuario
    public MaxHeap(int capacidade){
        this.valores = new int[capacidade];
    }

    // construtor padrao: capacidade = 10
    public MaxHeap(){
        this(10);
    }

    public int getOcupacao(){
        return this.ocupacao;
    }

    public boolean vazio(){
        return ocupacao == 0;
    }
    public boolean cheio(){
        return ocupacao == valores.length;
    }

    public int getPai(int pos){
        return (pos - 1) / 2;
    }
    public int getFilhoEsquerdo(int pos){
        return 2*pos + 1;
    }
    public int getFilhoDireito(int pos){
        return 2*pos + 2;
    }

    // Troca dois elementos do vetor.
    private void trocar(int i, int j){
        int aux = valores[i];
        valores[i] = valores[j];
        valores[j] = aux;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("heap: [");
        for(int i = 0; i < ocupacao; i++){
            s.append(valores[i]);
            if(i < ocupacao - 1) s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

    // Insercao mantendo a propriedade de max-heap
    // Estrategia: anexa no fim e depois faz o valor "subir" enquanto for maior que o pai.
    public boolean inserir(int valor){
        if(cheio()) return false; // heap cheio
        valores[ocupacao++] = valor;
        subirHeap(ocupacao - 1); // restaura a propriedade
        return true;
    }

    // Sobe o elemento da posicao i enquanto for maior que seu pai.
    private void subirHeap(int i){
        while(i > 0){
            int pai = getPai(i);
            if(valores[i] > valores[pai]){
                trocar(i, pai);
                i = pai;
            } else {
                return;
            }
        }
    }

    // DESCE_HEAP (base 0)
    // Pseudocodigo do PDF (base 1):
    //   enquanto (2i <= n) {
    //       f = 2i;
    //       se (f < n e A[f+1] > A[f]) f = f + 1;
    //       se (A[i] < A[f]) { troca A[i] e A[f]; i = f; }
    //       senao i = n + 1;  // (sai do laco)
    //   }
    public void desceHeap(int n, int i){
        while(2*i + 1 < n){          // enquanto i tiver pelo menos o filho esquerdo
            int f = 2*i + 1;         // f aponta para o filho esquerdo
            // se existir filho direito e ele for maior que o esquerdo, f aponta pra direito
            if(f + 1 < n && valores[f + 1] > valores[f])
                f = f + 1;
            // se o pai e menor que o maior dos filhos, troca e continua descendo
            if(valores[i] < valores[f]){
                trocar(i, f);
                i = f;
            } else {
                return; // propriedade ja satisfeita neste ramo
            }
        }
    }

    // CONSTROI_HEAP_MAX (base 0)
    // Aplica desceHeap de baixo para cima, comecando do ultimo no espaço
    // (n/2 - 1 em base 0) ate a raiz (indice 0).
    public void construirMaxHeap(){
        int n = ocupacao;
        for(int i = n/2 - 1; i >= 0; i--){
            desceHeap(n, i);
        }
    }

    // HEAPSORT: ordena em ordem CRESCENTE (base 0)
    // Pseudocodigo do PDF (base 1):
    //   CONSTROI_HEAP_MAX(A, tamanho)
    //   para i de tamanho ate 2:
    //       troca(A[1], A[i])
    //       tamanho = tamanho - 1
    //       desce_heap(A, tamanho, 1)
    public void heapSort(){
        construirMaxHeap(); // 1) transforma o vetor em um max-heap
        int tamanho = ocupacao;
        for(int i = tamanho - 1; i >= 1; i--){
            // 2) o maior elemento (raiz) vai para o final da parte ainda nao ordenada
            trocar(0, i);
            // 3) reduz o tamanho da parte ainda nao ordenada
            tamanho = tamanho - 1;
            // 4) restaura a propriedade na raiz
            desceHeap(tamanho, 0);
        }
        // Ao final, valores[0..ocupacao-1] esta em ordem crescente.
    }
}