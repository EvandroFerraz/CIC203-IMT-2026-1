import java.util.Scanner;

public class TesteContador{

    public static void main(String[] args){
        NossoVetor v;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho do vetor, 0 encerra: ");
        int capacidade = scanner.nextInt(); //capacidade = n

        while(capacidade > 0){
            v = new NossoVetor(capacidade);
            v.preencheVetor();
            System.out.println(v);

            System.out.println("Digite um elemento para busca: ");
            int x = scanner.nextInt();
            System.out.println("iterações da busca linear: " 
                + v.buscaLinearContador(x));
            System.out.println("iterações do bubble: "
                + v.bubbleSortContador());
            System.out.println("iterações da busca binaria: "
                + v.buscaBinariaContador(x));
            
            System.out.println("Digite o tamanho do vetor, 0 encerra: ");
            capacidade = scanner.nextInt(); //capacidade = n
        }
        scanner.close();
    }
}