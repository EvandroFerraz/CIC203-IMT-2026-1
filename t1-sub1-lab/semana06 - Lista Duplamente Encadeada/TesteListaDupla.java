public class TesteListaDupla {

    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        System.out.println("lista depois da instanciacao: " + lista); // lista vazia

        // testando as inserções no inicio
        lista.insereInicio(10);
        lista.insereInicio(20);
        lista.insereInicio(30);
        System.out.println("lista depois das insercoes no inicio:\n" + lista);

        // testando as inserções no fim
        lista.insereFim(15);
        lista.insereFim(25);
        lista.insereFim(35);
        System.out.println("lista depois das insercoes no fim:\n" + lista);

        // testando o tratamento de exceção ao tentar remover de uma lista vazia
        // criamos uma nova lista (vazia) para esse teste
        ListaDupla listaVazia = new ListaDupla();
        try {
            System.out.println(listaVazia.removeInicio());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // testando remoção no início
        try {
            System.out.println(lista.removeInicio() + " foi removido do inicio da lista.");
            System.out.println("lista atualizada: " + lista);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // testando remoção no fim
        try {
            System.out.println(lista.removeFim() + " foi removido do fim da lista.");
            System.out.println("lista atualizada: " + lista);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
