public class No{

    // atributos
    private int info;
    private No esquerda; // representa a subárvore esquerda daquele nó
    private No direita; // representa a subárvore direita daquele nó

    // construtor para inicializar o atributo info
    public No(int info){
        this.info = info;
        // esquerda = direita = null
    }

    //getters
    public int getInfo(){
        return info;
    }
    public No getEsquerda(){
        return esquerda;
    }
    public No getDireita(){
        return direita;
    }
    //setters
    public void setInfo(int info){
        this.info = info;
    }
    public void setEsquerda(No esquerda){
        this.esquerda = esquerda;
    }
    public void setDireita(No direita){
        this.direita = direita;
    }
    //toString()
    public String toString(){
        return info + " ";
    }
}