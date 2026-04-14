public class FilaCircular{
    int[] dados;
    int primeiro, ultimo, ocupacao;

    // construtor que instancia dados de acordo com o parâmetro capacidade
    public FilaCircular(int capacidade){
        dados = new int[capacidade];
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }

    // construtor que instancia dados com capacidade = 10
    public FilaCircular(){ 
        this(10); // FilaCircular(10)
    }

    public boolean filaVazia(){
        return ocupacao == 0;
    }
    public boolean filaCheia(){
        return ocupacao == dados.length;
    }

    // define o índice do ultimo elemento inserido na fila
    private int proxima(int pos){
        return (pos + 1) % dados.length;
    }

    // inserir no final = enfileirar
    public void enfileirar(int e){
        if(filaCheia()) throw new RuntimeException("fila já encheu!!");

        dados[ultimo] = e;
        ultimo = proxima(ultimo);
        ocupacao++;
    }

    // remove do inicio = desenfileirar
    public int desenfileirar(){
        if(filaVazia()) throw new RuntimeException("fila vazia!!");

        int temp = dados[primeiro];
        primeiro = proxima(primeiro);
        ocupacao--;
        return temp;
    }

    public String toString(){
        if(filaVazia()) return("fila vazia");
        String s = "";
        for(int i = primeiro, cont = 0; cont < ocupacao; cont++){
            s = s + dados[i] + " ";
            i = proxima(i);
        }
        return s;
    }
}