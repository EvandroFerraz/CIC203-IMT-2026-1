import java.util.Random;

public class TesteFila{

    public static void main(String[] args){

        Fila fila = new Fila(); // construtor padrão, cria uma fila com primeiro = ultimo = null
        Random random = new Random();

        // Queue fila = new Queue(); // Lista FIFO, ou Fila;

        for(int i=1; i<20; i++){
            try{
                if(random.nextBoolean()){ // gera um boolean aleatorio
                    fila.enfileira(i);
                }else{
                    System.out.println(fila.desinfileira() + " foi atendido!!");
                }
                System.out.println(fila);
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
    }
}