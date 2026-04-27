import java.util.Random;

public class TesteABB{

    public static void main(String[] args){

        Random random = new Random();
        ArvoreBinariaBusca abb = new ArvoreBinariaBusca(); // raiz = null, nasce vazia

        // Prennche a árvore
        for(int i=1; i<=100; i++){
            int n = random.nextInt(100); // entre 0 e 99
            abb.insere(n); // testando o método insere
        }

        // Testando o método percorrer
        // Se a regra da árvore binária de busca foi implementada corretamente,
        // ao percorrer a árvore em ordem simétrica teremos os números da árvore
        // em ordem crescente
        System.out.println("Arvore: \n" + abb);
    }
}