// MaxHeap = heap com a propriedade: para todo no i diferente da raiz,
//          valores[pai(i)] >= valores[i]
// Logo, o maior elemento esta sempre na raiz (indice 0)

public class MaxHeap{
    private int[] valores;
    private int ocupacao;

    // construtor com capacidade escolhida pelo usuario
    public MaxHeap(int capacidade){
        this.valores = new int[capacidade];
    }

    // construtor padrão: capacidade = 10
    public MaxHeap(){
        this(10);
    }

    // métodos auxiliares
    public int getOcupacao(){
        return this.ocupacao;
    }
    public boolean vazio(){
        return ocupacao == 0;
    }
    public boolean cheio(){
        return ocupacao == valores.length;
    }
    private void trocar(int i, int j){
        int aux = valores[i];
        valores[i] = valores[j];
        valores[j] = aux;
    }

    // Navegação pelo heap
    public int getPai(int pos){
        return(pos - 1) / 2;
    }
    public int getFilhoEsquerdo(int pos){
        return 2*pos+1;
    }
    public int getFilhoDireito(int pos){
        return 2*pos+2;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("heap: [");
        for(int i = 0; i < ocupacao; i++){
            s.append(valores[i]);
            if(i < ocupacao-1) s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

    // inserir mantendo a propriedade de max-heap
    // estrategia: anexa no fim e depois faz o valor "subir" equanto o valor >= pai
    public boolean inserir(int valor){
        if(cheio()) return false; // heap cheio
        valores[ocupacao++] = valor; // insere na proxima posicao vazia e depois incrementa ocupacao
        subirHeap(ocupacao-1);  // restaura a propriedade "subindo" o novo valor inserido
        return true;
    }

    // Sobe o elemento da posicao i enquanto for maior que seu pai
    private void subirHeap(int i){
        while(i > 0){ //enquanto nao chegamos na raiz
            int pai = getPai(i);
            if(valores[i] > valores[pai]){
                trocar(i, pai);
                i = pai;
            }else{
                return;
            }
        }
    }

    // - DesceHeap
public void desceHeap(int n, int i){
    while(2*i+1 < n){ // enquanto i tiver pelo menos um filho esquerdo
        int f = 2*i+1; // apontar para o filho esquerdo

        // se existe filho direito e ele é maior que o esquerdo, f aponta para o direito
        if(f + 1 < n && valores[f+1] > valores[f])
            f = f + 1; // f agora aponta para o filho direito
        
        // se o pai é menor que o maior de seus filhos, troca os dois de posicao
        if(valores[i] < valores[f]){ // propriedade max_heap quebrada
            trocar(i, f);
            i = f;
        }else{ // propriedade max_heap não foi quebrada
            return; // propriedade ja foi satisfeita nesse ramo
        }
    }
}

// - ConstroiMaxHeap = Aplica desceHeap de baixo para cima,
// comecando o ultimo espaco (n/2-1) ate a raiz (indice 0)
public void construirMaxHeap(){
    int n = ocupacao;
    for(int i = n/2-1; i >= 0; i--){
        desceHeap(n,i);
    }
}

// - HeapSort
public void heapSort(){
    // 1) transforma o vetor de entrada em um max-heap
    construirMaxHeap();
    int tamanho = ocupacao;
    for(int i = tamanho - 1; i >= 1; i--){
        //2) o maior elemento (raiz) vai para o final da parte ainda não ordenada
        trocar(0,i);
        //3) reduz o tamanho da parte ainda não ordenada
        tamanho = tamanho - 1;
        // 4) restaura a propriedade do max_heap, para todo elemento reposicionado
        desceHeap(tamanho, 0);
    }
    // Ao final, valores[0..ocupacao-1] esta em ordem crescente.
}
}