public class ListaDupla{
    private NoDuplo primeiro; // referencia para a primeira posicao da lista
    private NoDuplo ultimo; // referencia para a ultima posicao da lista

    // 1- método que insere um novo elemento no inicio
    // 2- método que insere um novo elmento no final
    // 3- método que remove um elemento do inicio da lista
    // 4- método que remove um elemeneto do final da lista
    // 5- classe de teste para testar a ListaDupla

    // utilizaremos o construtor padrão do java

    // getters
    public NoDuplo getPrimeiro(){
        return primeiro;
    }
    public NoDuplo getUltimo(){
        return ultimo;
    }
    // setters
    public void setPrimeiro(NoDuplo primeiro){
        this.primeiro = primeiro;
    }
    public void setUltimo(NoDuplo ultimo){
        this.ultimo = ultimo;
    }

    // retorna true se a lista estiver vazia
    public boolean listaVazia(){
        return primeiro == null;
    }

    // define a representação textual de objetos da classe ListaDupla
    @Override
    public String toString(){
        if(listaVazia()) return "lista vazia \n";

        String s = ""/

        // runner inicialmente referencia a primeira posicao da lista
        for(NoDuplo runner = primeiro; runner != null; runner = runner.getProximo()){
            s += runner + " ";
        }
        return s + "\n";
    }
}