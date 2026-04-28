import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JogandoCartasForaQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            
            // O algoritmo deve encerrar se o usuário digitar N = 0
            if (n == 0) {
                break;
            }

            // Crie uma fila que inicialmente guardará a numeração das cartas em ordem crescente
            Queue<Integer> cartas = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                cartas.add(i);
            }

            StringBuilder descartadas = new StringBuilder();

            // Percorra a fila enquanto o número de cartas for > 1
            while (cartas.size() > 1) {
                // A carta no início da fila será desenfileirada e adicionada na lista de descartadas
                descartadas.append(cartas.poll());
                
                // Se o número de cartas atual é > 2, adiciona a vírgula e espaço
                if (cartas.size() >= 1) {
                    descartadas.append(", ");
                }

                // Remove a carta que agora ficou no início e a adiciona ao final da fila
                cartas.add(cartas.poll());
            }

            System.out.println("Cartas descartadas: " + descartadas.toString());
            System.out.println("Carta remanescente: " + cartas.poll());
        }
        
        scanner.close();
    }
}