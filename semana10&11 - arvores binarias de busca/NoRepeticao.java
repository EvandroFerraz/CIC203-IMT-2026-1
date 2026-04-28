public class NoRepeticao extends No{ // herdamos info, esquerda e direita
    private int ocorrencias;

    public NoRepeticao(int info){
        super(info); // executando o construtor da classe mãe (No) para inicializar o atributo info
        ocorrencias = 1;
    }

    public int getOcorrencias(){
        return ocorrencias;
    }
    public void setOcorrencias(int ocorrencias){
        this.ocorrencias = ocorrencias;
    }

    public String toString(){
        return super.toString() + " ocorre " + ocorrencias + " vezes |";
    }
}