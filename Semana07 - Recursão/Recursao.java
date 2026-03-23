import java.util.Calendar;

public class Recursao{

    static long fatorialIterativo(int n){
        long f = 1;
        for(int i = 2; i <= n; i++){
            f *= i; // f = f * i
        }
        return f;
    }

    static long fatorialRecursivo(int n){
        // Parte 1: Critério Base, que é condição de parada
        if(n <= 1) return 1;
        // Parte 2: Recursão
        return n * fatorialRecursivo(n-1);
    }
    // Teste de mesa considerando n = 4
    // 1ª fatorialRecursivo(4); 4 <= 1 é falso, então chamamos fatorialRecursivo(3)
    // 2ª fatorialRecursivo(3); 3 <= 1 é falso, então chamamos fatorialRecursivo(2)
    // 3ª fatorialRecursivo(2); 2 <= 1 é falso, então chamamos fatorialRecursivo(1)
    // 4ª fatorialRecursivo(1); 1 <= 1 é verdadeiro, então retorna 1 (caso base)
    // Resolvemos fatorialRecursivo(1), então voltamos resolvendo as chamadas empilhadas em ordem decrescente:
    // Resolvemos a 3ª chamada empilhada (n = 2): retorna 2 * 1 = 2, que seria n * retorno da 4ª chamada
    // Resolvemos a 2ª chamada empilhada (n = 3): retorna 3 * 2 = 6, que seria n * retorno da 3ª chamada
    // Resolvemos a 1ª chamada empilhada (n = 4): retorna 4 * 6 = 24, que seria n * retorno da 2ª chamada

    static long fibonacciIterativo(int n){
        if(n < 2) return 1; 
        long[] v = new long[n];
        v[0] = 1;
        v[1] = 1;
        for(int i = 2; i < n; i++){
            v[i] = v[i - 1] + v[i - 2];
        }
        return v[n-1];
    }

    static long fibonacciRecursivo(int n){
        // Parte 1: Critério Base
        if (n <= 1) return 1;
        // Parte 2: Recursão
        return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
    }

    public static void main(String[] args){
        // teste fatorial
        // long inicio = Calendar.getInstance().getTimeInMillis();
        // System.out.println("Fatorial Iterativo: " + fatorialIterativo(2000));
        // long fim = Calendar.getInstance().getTimeInMillis();
        // System.out.println("Fatorial Iterativo demorou: " + (fim-inicio));

        // inicio = Calendar.getInstance().getTimeInMillis();
        // System.out.println("Fatorial Recursivo: " + fatorialRecursivo(2000));
        // fim = Calendar.getInstance().getTimeInMillis();
        // System.out.println("Fatorial Recursivo demorou: " + (fim-inicio));

        // teste fibonacci
        long inicio = Calendar.getInstance().getTimeInMillis();
        System.out.println("Fibonacci Iterativo: " + fibonacciIterativo(10));
        long fim = Calendar.getInstance().getTimeInMillis();
        System.out.println("Fibonacci Iterativo demorou: " + (fim-inicio));

        inicio = Calendar.getInstance().getTimeInMillis();
        System.out.println("Fibonacci Recursivo: " + fibonacciRecursivo(10));
        fim = Calendar.getInstance().getTimeInMillis();
        System.out.println("Fibonacci Recursivo demorou: " + (fim-inicio));
    }
}