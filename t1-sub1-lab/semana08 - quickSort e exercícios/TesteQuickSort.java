import java.util.Scanner;

public class TesteQuickSort{

    public static void main(String[] args){
        NossoVetor v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a capacidade do vetor, 0 encerra.");
        int capacidade = sc.nextInt();

        while(capacidade > 0){
            v = new NossoVetor(capacidade);
            v.preencheVetor();

            long inicio =  System.nanoTime(); // pega o horário atual em nano segundos
            v.quickSort(0, capacidade-1); // primeira chamada é para o vetor completo
            long fim = System.nanoTime();
            System.out.println("O quickSort demorou " + (fim-inicio) + " nano s");

            System.out.println("Digite a capacidade do vetor, 0 encerra.");
            capacidade = sc.nextInt();
        }

    }
}