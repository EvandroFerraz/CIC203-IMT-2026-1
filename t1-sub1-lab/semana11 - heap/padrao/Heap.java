// Heap = representação em estrutura vetorial de uma árvore binária
public class Heap{
    private int[] valores;
    private int ocupacao;

    // construtor para iniciar o Heap com uma capacidade escolhida pelo usuário
    public Heap(int capacidade){
        this.valores = new int[capacidade];
        //ocupacao = 0;
    }

    // construtor nao parametrizado, capacidade = 10 por padrão 
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
    // [0][1][2][3]
    // [8][2][14][7]
    public int getPai(int pos){
        // pos = 1
        // return 0 / 2 = 0
        return (pos-1) / 2;
    }  
    // [0][1][2][3]
    // [8][2][14][7]
    public int getFilhoEsquerdo(int pos){
        // pos = 1
        // return = 2*(pos)+1 = 3
        return 2*(pos)+1;
    }
    // [0][1][2][3][4]
    // [8][2][14][7][8]
    public int getFilhoDireito(int pos){
        // pos = 1
        // return = 2*(pos)+2 = 4
        return 2*(pos)+2;
    }

    //@Override
    // toString() herdado da classe Object
    public String toString(){
        String s = "heap";

        for(int i = 0; i < valores.length; i++) 
            s += valores[i] + " ";
        
        return s;
    }

    // posicoes = [0][1][2][3][4]
    // valores =  [8][2][14][7][8]
    // capacidade = 10, ocupacao = 5
    // inserir(10)
    public boolean inserir(int valor){
        if(cheio()) return false; // heap já está cheio

        // só continua a partir daqui se o vetor não estiver cheio
        valores[ocupacao++] = valor; //pós incremento, então primeiro usa ocupacao e depois incrementa
        // primeiro inserimos valor em valores[ocupacao], ou seja, valores[5] = 10.
        // somente depois, ocupacao = ocupacao + 1 = 6
        return true;
    }
}