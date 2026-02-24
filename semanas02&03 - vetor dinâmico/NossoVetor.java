// herda da classe Object
public class NossoVetor {
    private int vetor[];  // vetor para armazenar os elementos na memória
    private int ocupacao = 0; // quantidade de elementos efetivamente inseridos no vetor
    private int capacidade = 0;

    // Construtor 1: inicializa o vetor com capacidade para 10 elementos
    public NossoVetor () {
        vetor = new int[10];
        capacidade = 10;
    }
    
    // Construtor 2: permite definir a capacidade inicial do vetor
    public NossoVetor (int capacidadeInicial) {
        vetor = new int[capacidadeInicial];
        capacidade = capacidadeInicial;
    }
    
    // Redimensiona a capacidade do vetor
    private void redimensiona(int novaCapacidade){
        int[] temp = new int[novaCapacidade];
        for(int j=0; j < ocupacao; j++){
            temp[j] = vetor[j];
        }
        vetor = temp; //temp sendo a cópia de vetor porém com a capacidade aumentada
        capacidade = novaCapacidade; // atualiza o atributo capacidade
    }

    // Retorna o tamanho do vetor (sua capacidade)
    public int getCapacidade () {
        return vetor.length;
    }
    
    // Verifica se existe pelo menos um elemento no vetor
    public boolean estaVazio(){
        return ocupacao == 0;
    }
    
    // Verifica se a ocupacao (número de elementos inseridos) alcançou a capacidade do vetor
    public boolean estaCheio () {
        return ocupacao == vetor.length;
    }
    
    // Adiciona um elemento na primeira posição vazia (vetor[ocupacao])
    public void adiciona (int elemento) {
        if (estaCheio()) redimensiona(capacidade*2);
        // Impede a inserção se o vetor estiver cheio
        // ocupacao++ atua como pós-incremento: 
        // 1º acessa o índice atual, 2º insere o elemento, 3º incrementa a variável ocupação computando que mais um número foi inserido no vetor
        vetor[ocupacao++] = elemento;
        // inserindo o número 5 no vetor |2|4|0|0|, ficaria |2|4|5|0|
    }

    // Remove o último elemento do vetor, reduz a capacidade se necessário e retorna o elemento removido
    public int remove(){
        if(estaVazio()) return -1;
        int removido = vetor[--ocupacao];
        // remover um número do vetor |2|4|5|0|, removeria o numero 5
        if(capacidade >= 10 && ocupacao <= capacidade/4) redimensiona(capacidade/2);
        return removido;
    }
    
    // Realiza uma busca linear. 
    // Devolve o índice da primeira ocorrência do elemento, ou -1 caso não seja encontrado.
    public int procuraIndice (int elemento) {
        for (int i = 0; i < ocupacao; i++) {
            if (elemento == vetor[i]) return i;
        }
        return -1; // Elemento não existe no vetor
    }

    // método que retorna um valor booleano caso existe o elemento no vetor
    public boolean contains(int elemento){
        for(int i=0; i < ocupacao; i++){
            if(vetor[i] == elemento) return true;
        }
        return false;
    }

    // método que lista as posições ocupadas por um elemento especifico no vetor
    public NossoVetor listaPosicoes(int elemento){
        // |2|4|5|2|, elemento = 2, ocupacao = 4
        NossoVetor lista = new NossoVetor(this.ocupacao);
        for(int i=0; i < this.ocupacao; i++){
            if(this.vetor[i] == elemento){
                lista.adiciona(i);
            }
        }
        return lista;
    }

    
    // Sobrescrita do método toString() herdado da classe Object. 
    // Permite que o print exiba os dados reais do vetor em vez do seu endereço de memória.
    @Override
    public String toString () {
        String s = "[ ";
        // Percorre apenas até a "ocupacao" (número de elementos inseridos), ignorando as posições vazias do vetor
        for (int i = 0; i < ocupacao; i++) {
            s += vetor[i] + " ";
        }
        return s + "]";
    }
}
