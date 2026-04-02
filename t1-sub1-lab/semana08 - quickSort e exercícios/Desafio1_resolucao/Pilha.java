public class Pilha {
    private No topo; //o topo faz o mesmo papel que o primeiro
    private int tamanho;
    //o construtor é só o padrão, vou herdar de Object: topo = null e tamanho = 0
    public boolean estaVazia () {
        return topo == null;
    }
    public void empilha (char info) {
        No novo = new No(info);
        if (!estaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
        tamanho++;
    }
    public char desempilha () {
        char temp = topo.getInfo();
        topo = topo.getProximo();
        tamanho--;
        return temp;
    }
    public int getTamanho() {
        return tamanho;
    }
    @Override
    public String toString () {
        if (estaVazia()) 
            return "pilha vazia";
        String s = "";
        No runner = topo;
        while (runner != null) {
            s += runner.toString() + "-> ";
            runner = runner.getProximo();
        }
        return s + "//";
    }
}
