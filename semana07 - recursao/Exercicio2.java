public class Exercicio2 {
    /**
     * 1- Criar um método que receba uma base e um expoente e calcula a potenciação utilizando recursão.
     */
    static int calcularPotencia(int base, int expoente) {
        // 1. Caso Base: Se o expoente for 0, o resultado é 1
        if (expoente == 0) {
            return 1;
        }
        
        // 2. Caso Recursivo: Multiplica a base pelo resultado da próxima chamada,
        // reduzindo o expoente em 1 a cada passo.
        return base * calcularPotencia(base, expoente - 1);
    }

    static void main(String args[]){
        int base = 2;
        int expoente = 3; // Queremos calcular 2 elevado a 3 (2³)
        
        int resultado = calcularPotencia(base, expoente);
        
        System.out.println(base + " elevado a " + expoente + " e: " + resultado); 
        // Saída esperada: 2 elevado a 3 é: 8
    }
}
