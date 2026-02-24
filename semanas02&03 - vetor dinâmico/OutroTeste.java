public class OutroTeste{
    public static void main(String[] args){
        NossoVetor v = new NossoVetor(); // v tem a capacida inicial = 10

        // adiciona 5 numeros
        v.adiciona(2);
        v.adiciona(10);
        v.adiciona(2);
        v.adiciona(5);
        v.adiciona(8);

        System.out.println(v.listaPosicoes(2));// retorna [0 2]

        System.out.println(v.getCapacidade()); // retorna capacidade = 10

        // adiciona mais 5 numeros
        v.adiciona(20);
        v.adiciona(11);
        v.adiciona(23);
        v.adiciona(54);
        v.adiciona(81); // ocupacao = capacidade = 10

        v.adiciona(99); // extrapola a capacidade atual (10) de v e o método redimensiona atualiza a capacidade
        System.out.println(v.getCapacidade()); // retorna capacidade = 20, redimensionamento foi usado

        // remove 8 elementos
        v.remove(); // ocupacao = 10
        v.remove(); // ocupacao = 9
        v.remove(); // ocupacao = 8
        v.remove();
        v.remove();
        v.remove();
        v.remove();
        v.remove(); // ocupacao = 3
        System.out.println(v.getCapacidade()); // retorna capacidade = 10, pois redimensiona foi chamado novamente
    }
}