public class NossoHash<K,V>{
    private Entrada<K,V>[] tabela; // tabela = tabela hash em si
    private int capacidade = 16;

    @SuppressWarnings("unchecked")
    public NossoHash(){
        tabela = new Entrada[16];
    }

    // funcao hash
    private int hash(K key){
        return Math.abs(key.hashCode()) % capacidade;
        // % resto da divisao é só para manter o indice valido (entre 0 e 15)
    }

    // funcao para inserir uma nova entrada na tabela
    public void put(K key, V value){
        int indice = hash(key);
        Entrada<K,V> entrada = new Entrada<>(key, value);
         // se ja existir um valor na posicao "indice" da tabela,
         // esse valor se torna o proxima da entrada atual
         // se nao existir, o proximo da entrada atual = null
         // lidando com as colisoes
        entrada.proximo = tabela[indice];
        tabela[indice] = entrada;
    }

    // método de busca com complexidade constante O(1) no caso médio
    public V get(K key){
        int indice = hash(key);
        Entrada<K,V> atual = tabela[indice];
        // Pior caso linear O(n), lista encadeada no indice tem tamanho n
        while(atual != null){
            if(key.equals(atual.key))
                return atual.value;
            atual = atual.proximo;
        }
        return null;
    }
}