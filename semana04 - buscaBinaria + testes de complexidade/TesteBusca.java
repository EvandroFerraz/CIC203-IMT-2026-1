import java.util.Scanner;
import java.util.Calendar;

public class TesteBusca {
    public static void main(String[] args) {
        NossoVetor v = new NossoVetor(10000); // capacidade = 1000

        v.preencheVetor(); // ocupacao = capacidade = 1000
        System.out.println(v);

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um valor para busca: ");
        int valorPesquisado = sc.nextInt();

        long inicio = Calendar.getInstance().getTimeInMillis();
        int posicao = v.buscaLinear(valorPesquisado); //O(n)
        long fim = Calendar.getInstance().getTimeInMillis();
        System.out.println("Busca Linear demorou: " + (fim-inicio) + " milisegundos");

        if (posicao != -1) {
            System.out.println("Valor encontrado na posição de índice " + posicao);
        } else {
            System.out.println("Valor não encontrado no vetor.");
        }

        System.out.print("Digite um valor para busca binária: ");
        valorPesquisado = sc.nextInt();
        
        inicio = Calendar.getInstance().getTimeInMillis();
        // Para que a busca binária funcione, o vetor deve estar ordenado.
        v.bubbleSort();
        int x = v.buscaBinaria(valorPesquisado); //O(log n)
        fim = Calendar.getInstance().getTimeInMillis();
        System.out.println("Busca Binaria demorou: " + (fim-inicio) + " milisegundos");

        if (x != -1) {
            System.out.println("Valor encontrado na posicao: " + x);
        } else {
            System.out.println("Valor não encontrado no vetor.");
        }
    }
}