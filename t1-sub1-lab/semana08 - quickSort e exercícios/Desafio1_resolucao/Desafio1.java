import java.util.Scanner;

public class Desafio1{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite quantas amostras gostaria de testar: ");
        int n = sc.nextInt();
        sc.nextLine(); // consome a quebra de linha após o nextInt();

        for(int i = 1; i <= n; i++){ // testando as amostras
            System.out.println("Digite a " + i + " amostra: ");
            String amostra = sc.nextLine();

            int diamantes = 0;
            Pilha pilha = new Pilha();

            for(int j = 0; j < amostra.length(); j++){ // iterar sobre a amostra
                char c = amostra.charAt(j);

                if(c == '<'){
                    pilha.empilha(c);
                }else if(c == '>' && !pilha.estaVazia()){
                    diamantes++;
                    pilha.desempilha();
                }
            }
            System.out.println("Diamantes Amostra " + i + ": " + diamantes);
        }   
    }
}