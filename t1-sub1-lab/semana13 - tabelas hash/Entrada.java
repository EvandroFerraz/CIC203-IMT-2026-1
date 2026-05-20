// Entrada = uma das posições da tabela hash
// K e V = placeholders, tipos de dados genéricos
// Lidando com Colisoes = Encadeamento
public class Entrada<K,V>{
    K key;
    V value;
    Entrada<K,V> proximo; // lista encadeada no indice de Entrada

    public Entrada(K key, V value){
        this.key = key;
        this.value = value;
        this.proximo = null;
    }
}