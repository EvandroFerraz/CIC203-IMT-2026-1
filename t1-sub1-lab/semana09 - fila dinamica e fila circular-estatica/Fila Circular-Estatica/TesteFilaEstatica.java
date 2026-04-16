import java.util.Random;

// Queue fila = new Queue();

public class TesteFilaEstatica{
    public static void main(String[] args){

        FilaEstatica fila = new FilaEstatica(); // capacidade = 10
        Random random = new Random();

        for(int i=1; i<=20; i++){ // 20 iterações
            try{
                if(random.nextBoolean()){ // 50% de nextBoolean() = true
                    fila.enfileira(i);
                }else{ // 50% de nextBoolean() = false
                    System.out.println(fila.desenfileira() + " foi atendido.");
                }
                System.out.println(fila);
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
    }
}