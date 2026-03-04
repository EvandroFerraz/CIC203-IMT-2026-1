import java.util.Scanner;

public class TesteBusca {
    public static void main(String[] args) {
        NossoVetor v = new NossoVetor(60);

        v.preencheVetor();
        System.out.println(v);

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um valor para busca: ");
        int valorPesquisado = sc.nextInt();
        int posicao = v.buscaLinear(valorPesquisado);

        if (posicao != -1) {
            System.out.println("Valor encontrado na pos ição de índice " + posicao);
        } else {
            System.out.println("Valor não encontrado no vetor.");
        }

        // Para que a busca binária funcione, o vetor deve estar ordenado.
        v.bubbleSort();

        System.out.print("Digite um valor para busca binária: ");
        valorPesquisado = sc.nextInt();
        int x = v.buscaBinaria(valorPesquisado);

        if (x != -1) {
            System.out.println("Valor encontrado na posicao: " + x);
        } else {
            System.out.println("Valor não encontrado no vetor.");
        }
    }
}