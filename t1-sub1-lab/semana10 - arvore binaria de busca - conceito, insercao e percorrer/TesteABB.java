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

        System.out.println("Arvore Original: \n" + abb);
        System.out.println("Arvore Compactada: \n" + abbZip);
    }
}