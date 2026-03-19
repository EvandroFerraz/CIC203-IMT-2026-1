public class TesteNoDuplo{
    public static void main(String[] args){
        // no1.info = 10, no1.proximo = no1.anterior = null
        NoDuplo no1 = new NoDuplo(10);
        // no2.info = 20, no2.proximo = no2.anterior = null
        NoDuplo no2 = new NoDuplo(20);

        System.out.println("no1: " + no1); // [10]
        System.out.println("no2: " + no2); // [20]

        no1.setProximo(no2); // no1 é o primeiro da lista, no1 > no2
        no2.setAnterior(no1); // no1 vem antes do no2

        no1.getProximo().setInfo(100); // atribuindo 100 para o no2
        no2.getAnterior().setInfo(500); // atribuindo 500 para o no1

        System.out.println("no1 atualizado: " + no1); // [10]
        System.out.println("no2 atualizado: " + no2); // [20]
    }
}