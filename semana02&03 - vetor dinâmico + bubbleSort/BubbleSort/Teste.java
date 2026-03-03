public class Teste {
    public static void main(String[] args) {
        int[] v1 = {64, 34, 25, 12, 22, 11, 90};
        
        Vetor vetor = new Vetor(v1);
        
        System.out.println("Vetor antes da ordenação:");
        vetor.print();

        vetor.bubbleSort();

        System.out.println("\nVetor após a ordenação:");
        vetor.print();
    }
}