import java.util.Random;

public class TesteFilaCircular{

    public static void main(String[] args){

        FilaCircular filaC = new FilaCircular(); // capacidade = 10
        Random random = new Random();

        for(int i=1; i <= 20; i++){
            try{
                if(random.nextBoolean()){ //50% de chances de entrar no if
                    filaC.enfileirar(i);
                }else{
                    System.out.println(filaC.desenfileirar() + " foi atendido."); 
                }
                System.out.println(filaC);
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
    }
}