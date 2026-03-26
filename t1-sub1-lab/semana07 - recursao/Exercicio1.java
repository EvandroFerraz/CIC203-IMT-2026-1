public class Exercicio1 {
    /**
     * 1- Criar um método que recebe um vetor de números inteiros e retorne a soma de todos eles, 
     * utilizando recursão.
     */
    static int somarRecursivo(int[] vetor, int indice) {
        // 1. Caso Base: Ponto de parada
        // Se o índice for igual ao tamanho do vetor, significa que já passamos 
        // por todos os elementos. Retornamos 0 para não alterar a soma.
        if (indice == vetor.length) {
            return 0;
        }
        
        // 2. Caso Recursivo:
        // Pegamos o número na posição atual e somamos com o resultado 
        // da mesma função avançando para a próxima posição (indice + 1).
        return vetor[indice] + somarRecursivo(vetor, indice + 1);
    }

    static void main(String args[]){
        int[] vetor = {10, 7, 5, 4, 6, 3, 2}; // 37
        System.out.println("A soma recursiva do vetor e: " + somarRecursivo(vetor,0));
    }
}
