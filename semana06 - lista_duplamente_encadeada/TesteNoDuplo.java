public class TesteNoDuplo{
    // classe de teste, então terá método main
    public static void main(String[] args){

        NoDuplo no1 = new NoDuplo(10); // no1.info = 10
        NoDuplo no2 = new NoDuplo(20); // no2.info = 20

        // representação textual = sobrescrita do toString()
        System.out.println("no1: " + no1);
        System.out.println("no2: " + no2);

        // no1 é o primeiro nó da lista [no1 -> no2]
        no1.setProximo(no2); // no1.proximo = no2
        no2.setAnterior(no1); // no2.anterior = no1

        System.out.println("Proximo do no1: " + no1.getProximo()); //retorna 20 (no2.info)
        System.out.println("Anterior do no2: "+ no2.getAnterior()); // retorna 10 (no1.info)

        // trocamos o valor em cada nó
        no1.setInfo(30); // no1.info = 30
        no2.setInfo(40); // no2.info = 40
        // o nó proximo do no1, ou seja, no2, recebe o valor 500; no2.info = 500
        no1.getProximo().setInfo(500);
        // o nó anterior ao no2, ou seja, no1, recebe o valor 1000; no1.info = 1000
        no2.getAnterior().setInfo(1000);

        System.out.println("no1 atualizado: " + no1); // retorna [1000]
        System.out.println("no2 atualizado: " + no2); // retorna [500]
    }
}