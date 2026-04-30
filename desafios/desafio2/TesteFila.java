import java.util.Random;

public class TesteFila {
    public static void main(String[] args) {
        // Queue fila = new Queue(); // Lista FIFO, ou Fila;

        Fila fila = new Fila(); // construtor padrão, primeiro = ultimo = null
        Random random = new Random();

        for (int i = 1; i < 20; i++) {
            try {
                if (random.nextBoolean()) { // 50% = true, 50% = false
                    fila.enfileira(i);
                } else {
                    System.out.println(fila.desinfileira() + " foi atendido!!");
                }
                System.out.println(fila);
            } catch (RuntimeException rt) { // rt.message = "Fila Vazia"
                System.out.println(rt.getMessage());
            }
        }

        // -------------------------------------------------------
        // Teste do Desafio 2 - Jogando Cartas Fora (Beecrowd 1110)
        // -------------------------------------------------------
        System.out.println("\n=== Desafio 2: Jogando Cartas Fora ===\n");

        // Caso do teste de mesa do enunciado: N = 7
        // Esperado: Descartadas: 1, 3, 5, 7, 4, 2 | Remanescente: 6
        System.out.println("-- N = 7 --");
        Fila fila7 = new Fila();
        fila7.jogandoCartasFora(7);

        // Caso pequeno: N = 1 (nenhuma carta é descartada, a própria é a remanescente)
        System.out.println("\n-- N = 1 --");
        Fila fila1 = new Fila();
        fila1.jogandoCartasFora(1);

        // Caso N = 4
        // Esperado: Descartadas: 1, 3 | Remanescente: 4
        System.out.println("\n-- N = 4 --");
        Fila fila4 = new Fila();
        fila4.jogandoCartasFora(4);

        // Caso maior: N = 10
        System.out.println("\n-- N = 10 --");
        Fila fila10 = new Fila();
        fila10.jogandoCartasFora(10);

        // Entrada inválida: N = 0 (deve exibir mensagem de erro)
        System.out.println("\n-- N = 0 (inválido) --");
        Fila fila0 = new Fila();
        fila0.jogandoCartasFora(0);
    }
}