public class No{

    // atributos
    private int info;
    private No esquerda; // referencia para a subarvore esquerda do no atual
    private No direita; // referencia para a subarvore direita do no atual

    // Construtor inicializa somente o atributo info
    public No(int info){
        this.info = info;
        // esquerda = direita = null; // todo novo nó inserido na árvore é uma folha
    }

    // getters
    public int getInfo(){
        return info;
    }
    public No getEsquerda(){
        return esquerda;
    }
    public No getDireita(){
        return direita;
    }
    // setters
    public void setInfo(int info){
        this.info = info;
    }
    public void setEsquerda(No esquerda){
        this.esquerda = esquerda;
    }
    public void setDireita(No direita){
        this.direita = direita;
    }
    // toString()
    public String toString(){
        return info + " ";
    }
}