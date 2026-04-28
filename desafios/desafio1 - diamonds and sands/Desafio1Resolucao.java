import java.util.Scanner;
import java.util.Stack;

public class Desafio1Resolucao{

    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        // 1. O algoritmo lê o número inteiro N (quantidade de amostras) 
        int N = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()
        
        for (int i = 0; i < N; i++) {
            String linha = sc.nextLine(); // Lê a amostra contendo <, > e . 
            
            // Estrutura de dados adequada: Pilha 
            Stack<Character> pilha = new Stack<>();
            int diamantes = 0;
            
            // Percorre todos os caracteres da amostra 
            for (int j = 0; j < linha.length(); j++) {
                char caractere = linha.charAt(j);
                
                if (caractere == '<') {
                    // Se <, adicionamos o caractere na Pilha 
                    pilha.push(caractere);
                } 
                else if (caractere == '>') {
                    // Se >, verificamos se a pilha não está vazia (se tem um < empilhado) 
                    if (!pilha.isEmpty()) {
                        pilha.pop(); // Desempilhamos um < 
                        diamantes++; // Computamos +1 diamante 
                    }
                    // Se a pilha estiver vazia, apenas ignoramos (não forma um par <>) 
                }
                // Se for '.', o caractere é ignorado (não fazemos nada) 
            }
            
            // Imprime o número total de diamantes extraídos 
            System.out.println(diamantes);
        }
        
        sc.close();
    }
}