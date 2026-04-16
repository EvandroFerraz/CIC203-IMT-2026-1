public class FilaEstatica{
    int[] dados;
    int primeiro, ultimo, ocupacao;

    // construtor que instancia o vetor dados de acordo com a capacidade
    public FilaEstatica(int capacidade){
        dados = new int[capacidade];
        // primeiro = 0;
        // ultimo = 0;
        // ocupacao = 0;
    }
    // construtor que instancia o vetor dados com capacidade = 10
    public FilaEstatica(){
        this(10); // FilaEstatica(10)
    }

    public boolean filaVazia(){ // fila vazia se ocupacao == 0
        return ocupacao == 0;
    }

    public boolean filaCheia(){ // fila cheia se ocupacao é igual ao tamanho do vetor
        return ocupacao == dados.length;
    }

    // define o indice da proxima posicao disponivel na fila
    private int proxima(int pos){
        return (pos+1) % dados.length;
    }
    
    // insere no final = enfileira()
    public void enfileira(int e){
        if(filaCheia()) throw new RuntimeException("fila ja encheu!!"); // message

        dados[ultimo] = e;
        ultimo = proxima(ultimo);
        ocupacao++;
    }

    // remove do inicio = desenfileira()
    public int desenfileira(){
        if(filaVazia()) throw new RuntimeException("fila vazia!!");

        int temp = dados[primeiro];
        primeiro = proxima(primeiro); // subtituimos a primeira posicao atual pela proxima
        ocupacao--;
        return temp;
    }

    // toString() para representacao textual de um objeto da classe Fila
    // toda classe criada no java herda o método toString() de Object
    // @Override
    public String toString(){
        if(filaVazia()) return ("fila vazia!!");

        String s = "";
        for(int i = primeiro, cont = 0; cont < ocupacao; cont++){
            s = s + dados[i] + " ";
            i = proxima(i);
        }
        return s;
    }
}