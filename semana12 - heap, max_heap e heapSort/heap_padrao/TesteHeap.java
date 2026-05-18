public class TesteHeap{

    public static void main(String[] args){
        Heap h = new Heap(); // heap com capacidade = 10

        int[] vs = {8,2,14,7,8,5,11,1,4,9};

        // for each = cada iteracao v sera um dos elementos de vs
        for(int v : vs)
            h.inserir(v);
        System.out.println(h);

        // testando o percorrer do heap, considerando pos = 1
        System.out.println("O filho esquerdo do indice 1 e: " +
            h.getFilhoEsquerdo(1)); // retorna 3
        System.out.println("O filho direito do indice 1 e: " +
            h.getFilhoDireito(1)); // retorna 4
        System.out.println("O pai do indice 1 e: " + h.getPai(1));
        // retorna 0
    }
}