import java.util.Random;

public class TesteABB{
    
    public static void main(String args[]){
        
        Random random = new Random();
        ArvoreBinariaBusca abb = new ArvoreBinariaBusca(); // raiz = null, nasce vazia
        ArvoreBinariaBusca abbZip = new ArvoreBinariaBusca(); // raiz = null, nasce vazia

        // Preenche a árvore
        for(int i = 1; i <= 100; i++){
            int n = random.nextInt(100); // entre 0 e 99
            abb.insere(n);
            abbZip.insereRepeticao(n);
        }

        // imprime todos os nós da árvore em ordem crescente
        System.out.println("Arvore Original: \n" + abb);
        System.out.println("Arvore Compactada: \n" + abbZip);

        // imprime a altura das arvores
        System.out.println("A altura da árvore original: " + abb.altura());
        System.out.println("A altura da árvore compactada: " + abbZip.altura());

        // imprime o número de nós das árvores
        System.out.println("O número de nós da árvore original: " + abb.contaNos());
        System.out.println("O número de nós da árvore compactada: " + abbZip.contaNos());
    }
}