import java.util.Scanner;

// Theta(n log n) = complexidade média
// O(n^2) = complexidade no pior caso
public class TesteQuickSort{

    public static void main(String[] args){
        NossoVetor v;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a capacidade do vetor, 0 encerra");
        int capacidade = sc.nextInt();

        while(capacidade > 0){
            v = new NossoVetor(capacidade);
            v.preencheVetor();

            long inicio = System.nanoTime(); // pega o horario atual em nanosegundos
            v.quickSort(0, capacidade-1); // primeira chamada para o vetor completo
            long fim = System.nanoTime();
            System.out.println("O quickSort demorou " + (fim-inicio) + " nano seg");

            System.out.print("Digite a capacidade do vetor, 0 encerra");
            capacidade = sc.nextInt();
        }
    }
}