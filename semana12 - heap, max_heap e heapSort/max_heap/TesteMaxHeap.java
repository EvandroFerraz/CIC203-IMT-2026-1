public class TesteMaxHeap{

    public static void main(String[] args){
        MaxHeap h = new MaxHeap(); // max-heap com capacidade = 10

        int[] vs = {8,2,14,7,8,5,11,1,4,9};

        // ao inserir em um MaxHeap, a propriedade de max-heap ja e mantida
        // automanticamente (via subirHeap()), entao a cada insercao o vetor
        // ja e um max-heap valido.
        for(int v : vs)
            h.inserir(v);

        System.out.println("Apos inserir um a um no MaxHeap: ");
        System.out.println(h);

        // Testando o percorrer do heap (base 0)
        System.out.println("Filho esquerdo do indice 1: " + h.getFilhoEsquerdo(1)); //3
        System.out.println("Filho direito do indice 1: " + h.getFilhoDireito(1)); //4
        System.out.println("Pai do indice 1: " + h.getPai(1)); //0

        // HeapSort: ordena em ordem crescente
        h.heapSort();
        System.out.println("\nApos heapSort() (ordem crescente): ");
        System.out.println(h);
        // Esperado: [1,2,4,5,7,8,8,9,11,14]
    }
}