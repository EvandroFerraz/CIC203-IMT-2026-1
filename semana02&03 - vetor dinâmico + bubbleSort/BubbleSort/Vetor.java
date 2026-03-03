public class Vetor {
    private int[] array;

    public Vetor(int[] array) {
        this.array = array;
    }
    
    public void bubbleSort() {     
      // Teste de Mesa
      // vetor = [8, 72, 64, 12, 36]
      // Complexidade quadrática (n^2) no pior caso, sendo n o tamanho do vetor de entrada   
      for (int i = 1; i < array.length; i++) {
          for (int j = 0; j < array.length-i; j++) {
            // 1.1 iteração: j = 0, vetor[j] = 8
            // 1.2 iteração: j = 1, vetor[j] = 72, 72 e 64 trocam de lugar
                // vetor = [8, 64, 72, 12, 36]
            // 1.3 iteração: j = 2, vetor[j] = 72, 72 e 12 trocam de lugar
                // vetor = [8, 64, 12, 72, 36]
            // 1.4 iteração: j = 3, vetor[j] = 72, 72 e 36 trocam de lugar
                // vetor = [8, 64, 12, 36, 72]
            // 2.1 iteração: j = 0, vetor[j] = 8
            // 2.2 iteração: j = 1, vetor[j] = 64, 64 e 12 trocam de lugar
                // vetor = [8, 12, 64, 36, 72]
            // 2.3 iteração: j = 2, vetor[j] = 64, 64 e 36 trocam de lugar
                // vetor = [8, 12, 36, 64, 72]
            // 3.1 iteração: j = 0, vetor[j] = 8
            // 3.2 iteração: j = 1, vetor[j] = 12
            // 4.1 iteração: j = 0, vetor[j] = 8
                // Ordenação concluída: vetor = [8, 12, 36, 64, 72]
            if (array[j] > array[j + 1]) {
                 // Troca os elementos
                 int temp = array[j];
                  array[j] = array[j + 1];
                  array[j + 1] = temp;
                }
            }
          }
    }
    
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}