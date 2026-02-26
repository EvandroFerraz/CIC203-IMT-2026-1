public class TesteRedimensionar{
    public static void main(String[] args){
        
        NossoVetor v = new NossoVetor(); // capacidade = 10
        
        // adiciona 5 numeros
        v.adiciona(2);
        v.adiciona(10);
        v.adiciona(2);
        v.adiciona(5);
        v.adiciona(8); // ocupacao = 5, capacidade = 10

        System.out.println(v.listaPosicoes(2)); // retorna [0 2]

        // adiciona +5 numeros
        v.adiciona(20);
        v.adiciona(11);
        v.adiciona(23);
        v.adiciona(54);
        v.adiciona(81); // ocupacao = 10, capacidade = 10
        
        System.out.println(v.getCapacidade()); // retorna 10
        
        // extrapola a capacidade atual de v e o método redimensiona é chamado
        v.adiciona(99); // ocupacao = 11, capacidade = 20

        System.out.println(v.getCapacidade()); // retorna 20

        // remove 8 elementos do vetor
        for(int i = 0; i < 8; i++){
            v.remove();
        } // ocupacao = 3, capacidade = 10

        System.out.println(v.getCapacidade()); // retorna 10
    }
}