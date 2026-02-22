public class TestePolimorfismo { 
    public static void main(String[] args){
        Animal animal = new Animal(); // construindo um novo objeto da classe Animal
        Cachorro cachorro = new Cachorro(); // construindo um novo objeto da classe Cachorro
        Gato gato = new Gato(); // construindo um novo objeto da classe Gato

        animal.fazerBarulho(); // Barulho...
        cachorro.fazerBarulho(); // au au
        gato.fazerBarulho(); // miau
    }
}
