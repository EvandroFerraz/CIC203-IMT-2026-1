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
        StringBuilder s = new StringBuild("heap: [");
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
}

// - DesceHeap
// - ConstroiMaxHeap
// - HeapSort 