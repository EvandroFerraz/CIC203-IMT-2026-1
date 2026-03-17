public class TesteListaDupla{

    public static void main(String[] args){
        ListaDupla listaDupla = new ListaDupla();
        ListaDupla listaVazia = new ListaDupla();
        System.out.println("lista foi construida: " + listaDupla); // lista vazia

        listaDupla.insereInicio(10);
        listaDupla.insereInicio(20);
        listaDupla.insereInicio(30);
        System.out.println("lista apos as insercoes no inicio: \n" + listaDupla);

        listaDupla.insereFim(15);
        listaDupla.insereFim(25);
        listaDupla.insereFim(35);
        System.out.println("lista apos as insercoes no fim: \n" + listaDupla);

        // testando a remoção no inicio
        try{
            System.out.println(listaDupla.removeInicio() + " foi removido do inicio da lista!!");
            System.out.println(listaDupla);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

    
        // testando a remoção na lista vazia
        try{
            System.out.println(listaVazia.removeFim() + " foi removido do fim da lista!!");
            System.out.println(listaVazia);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

        // testando a remoção no fim
        try{
            System.out.println(listaDupla.removeFim() + " foi removido do fim da lista!!");
            System.out.println(listaDupla);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}