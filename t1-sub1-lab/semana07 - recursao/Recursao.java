public class Recursao {

    // fatorial
    static long fatorialIterativo(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i; // f = f * i
        }
        return f;
    }

    static long fatorialRecursivo(int n) {
        // Parte 1: Caso Base, que é o condição de parada
        if (n <= 1)
            return 1;
        // Parte 2: Recursao
        return n * fatorialRecursivo(n - 1);
    }
    // Teste de mesa considerando n = 4
    // 1ª chamada fatorialRecursivo(4); 4 <= 1 é falso, então fatorialRecursivo(3)
    // 2ª chamada fatorialRecursivo(3); 3 <= 1 é falso, então fatorialRecursivo(2)
    // 3ª chamada fatorialRecursivo(2); 2 <= 1 é falso, então fatorialRecursivo(1)
    // 4ª chamada fatorialRecursivo(1); 1 <= 1 é verdadeiro, então retorna 1 (caso
    // base)
    // Resolvemos a 4ª fatorialRecursivo(1), então voltamos resolvendo as chamadas
    // empilhadas
    // Resolvemos a 3ª fatorialRecursivo(2); retorna 2 * 1 = 2, n * retorno de
    // fatorialRecursivo(1)
    // Resolvemos a 2ª fatorialRecursivo(3); retorna 3 * 2 = 6, n * retorno de
    // fatorialRecursivo(2)
    // Resolvemos a 1ª fatorialRecursivo(4); retorna 4 * 6 = 24, n * retorno de
    // fatorialRecursivo(3)

    // fibonacci
    static long fibonacciIterativo(int n) {
        if (n < 2)
            return 1;
        long[] v = new long[n + 1];
        v[0] = 1;
        v[1] = 1;
        for (int i = 2; i <= n; i++) {
            v[i] = v[i - 1] + v[i - 2];
        }
        return v[n];
    }

    static long fibonacciRecursivo(int n) {
        // Parte 1: Critério Base
        if (n <= 1)
            return 1;
        // Parte 2: Recursão
        return fibonacciRecursivo(n - 2) + fibonacciRecursivo(n - 1);
    }

    public static void main(String[] args) {
        // teste fatorial
        // recursivo e iterativo possuem complexidade O(n)
        // Marca o início em nanossegundos
        long inicio = System.nanoTime();
        System.out.println("Fatorial Iterativo: " + fatorialIterativo(10));
        // Marca o fim em nanossegundos
        long fim = System.nanoTime();
        System.out.println("Fatorial Iterativo demorou " + (fim - inicio));

        inicio = System.nanoTime();
        System.out.println("Fatorial Recursivo: " + fatorialRecursivo(10));
        fim = System.nanoTime();
        System.out.println("Fatorial Recursivo demorou " + (fim - inicio));

        // teste fibonacci
        // recursivo demora mais conforme o valor de n aumenta, complexidade O(2^n)
        inicio = System.nanoTime();
        System.out.println("Fibonacci Iterativo: " + fibonacciIterativo(10));
        fim = System.nanoTime();
        System.out.println("Fibonacci Iterativo demorou " + (fim - inicio));

        inicio = System.nanoTime();
        System.out.println("Fibonacci Recursivo: " + fibonacciRecursivo(10));
        fim = System.nanoTime();
        System.out.println("Fibonacci Recursivo demorou " + (fim - inicio));
    }
}