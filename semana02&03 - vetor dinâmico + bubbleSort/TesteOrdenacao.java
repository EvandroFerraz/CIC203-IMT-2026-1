import java.util.Scanner;
import java.util.Date;

public class TesteOrdenacao{
    public static void main(String[] args){
        NossoVetor v;
        Scanner scanner = new Scanner(System.in);

        int n; // tamanho do vetor de entrada
        System.out.println("Escolha o tamanho do vetor, 0 encerra: ");
        n = scanner.nextInt();

        while(n > 0){
            v = new NossoVetor(n);
            v.preencheVetor();

            // pega o horário, contando os milisegundos, antes de executar o bubble
            long ini = new Date().getTime();

            // executa o bubble
            v.bubbleSort();

            // pega o horário, contando os milisegundos, depois de executar o bubble
            long fim = new Date().getTime();
         
            System.out.println("Bubble Demorou: " + (fim-ini) + " milisegundos.");

            System.out.println("Escolha o tamanho do vetor, 0 encerra: ");
            n = scanner.nextInt();
        }
        scanner.close();
    }
}