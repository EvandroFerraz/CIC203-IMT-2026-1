import java.util.Random;

public class TesteFila{
    public static void main(String[] args){
        // Queue fila = new Queue(); // Lista FIFO, ou Fila;
        
        Fila fila = new Fila(); // construtor padrão, primeiro = ultimo = null
        Random random = new Random();

        for(int i=1; i<20; i++){
            try{
                if(random.nextBoolean()){ // 50% = true, 50% = false
                    fila.enfileira(i);
                }else{
                    System.out.println(fila.desinfileira() + " foi atendido!!");
                }
                System.out.println(fila);
            }catch(RuntimeException rt){ // rt.message = "Fila Vazia"
                System.out.println(rt.getMessage());
            }
        }
    }
}