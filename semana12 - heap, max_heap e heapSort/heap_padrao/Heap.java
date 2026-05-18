// Heap = representação em vetor de uma árvore binária
public class Heap{
    private int[] valores;
    private int ocupacao;

    // Construtor para iniciar o Heap com uma capacidade escolhida pelo usuário
    public Heap(int capacidade){
        this.valores = new int[capacidade];
        // ocupacao = 0;
    }
    // Construtor não parametrizado, capacidade = 10 por padrão
    public Heap(){
        this(10);
    }
    public int getOcupacao(){
        return this.ocupacao;
    }
    // métodos auxiliares
    public boolean vazio(){
        return ocupacao == 0;
    }
    public boolean cheio(){
        return ocupacao == valores.length;
    }

    // métodos para percorrer o Heap
    // posicao = [0|1|2 |3|4]
    // valores = [8|2|14|7|8]
    public int getPai(int pos){
        // pos = 2, (2-1)/2 = pai, pai = int(0.5) = 0
        // pos = 4, (4-1)/2 = pai, pai = int(1.5) = 1
        return (pos-1)/2;
    }
    public int getFilhoEsquerdo(int pos){
        // pos = 1, 2*1+1 = esquerdo, esquerdo = 3
        // pos = 0, 2*0+1 = esquerdo, esquerdo = 1
        return 2*pos+1;
    }
    public int getFilhoDireito(int pos){
        // pos = 1, 2*1+2 = direito, direito = 4
        // pos = 0, 2*0+2 = direito, direito = 2
        return 2*pos+2;
    }

    //@Override, toString() herdado da classe Object
    public String toString(){
        String s = "heap: ";

        for(int i = 0; i < valores.length; i++)
            s += valores[i] + " ";

        return s;
    }

    // posicao = [0|1|2 |3|4|5|6], ocupacao = 5
    // valores = [8|2|14|7|8|0|0], capacidade = 7
    // inserir(10)
    public boolean inserir(int valor){
        if(cheio()) return false; // heap já está cheio

        // só continuo a partir daqui se o vetor não estiver cheio
        // pós incremento, primeiro usa ocupacao e depois incrementa
        valores[ocupacao++] = valor; // valores[5] = 10
        // e depois ocupacao é incrementada: ocupacao = 5 + 1 = 6

        return true;
    }
}