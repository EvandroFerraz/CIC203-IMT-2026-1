public class Cachorro extends Animal{
    // herda o método fazerBarulho()
    // para sobrescrever um método da classe mãe, declaramos 
    // um método com a mesma assinatura na classe filha
    public void fazerBarulho(){
        System.out.println("au au");
    }
}
