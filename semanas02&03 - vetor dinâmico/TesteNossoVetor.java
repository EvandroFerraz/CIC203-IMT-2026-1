/**
 * Classe principal (Main) para instanciar e testar as funcionalidades da classe NossoVetor.
 */
public class TesteNossoVetor {
    public static void main(String[] args) {
        // Instancia um vetor utilizando o construtor 1 (capacidade 10)
        NossoVetor v1 = new NossoVetor();
        
        // Instancia um vetor utilizando o construtor 2 (capacidade 6)
        NossoVetor v2 = new NossoVetor(6);

        System.out.println("--- Preenchendo o vetor v2 ---");
        
        // Loop iterando do índice 0 até a capacidade do vetor (6 vezes)
        for (int i = 0; i < v2.getCapacidade(); i++) {
            v2.adiciona(i + 3); // Insere valores calculados sequencialmente (3, 4, 5, 6, 7, 8)
            
            // Imprime o estado do vetor a cada iteração.
            // Como sobrescrevemos o método toString() na classe NossoVetor, o print mostra quais elementos estão no vetor.
            System.out.println("Iteração " + (i + 1) + ": " + v2);
        }
        
        // Imprime o vetor completo, após seu preenchimento
        System.out.println("Vetor completo: " + v2);
    }
}