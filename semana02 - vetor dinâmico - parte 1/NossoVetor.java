public class NossoVetor {
    private int vetor[];  // vetor para armazenar os elementos na memória
    private int ocupacao = 0; // quantidade de elementos efetivamente inseridos no vetor

    // Construtor 1: inicializa o vetor com capacidade para 10 elementos
    public NossoVetor () {
        vetor = new int[10];
    }
    
    // Construtor 2: permite definir a capacidade inicial do vetor
    public NossoVetor (int capacidadeInicial) {
        vetor = new int[capacidadeInicial];
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
    public boolean adiciona (int elemento) {
        if (estaCheio()) return false; // Impede a inserção se o vetor estiver cheio
        // ocupacao++ atua como pós-incremento: 
        // 1º acessa o índice atual, 2º insere o elemento, 3º incrementa a variável ocupação computando que mais um número foi inserido no vetor
        vetor[ocupacao++] = elemento; 
        return true;
    }
    
    // Realiza uma busca linear. 
    // Devolve o índice da primeira ocorrência do elemento, ou -1 caso não seja encontrado.
    public int procuraIndice (int elemento) {
        for (int i = 0; i < ocupacao; i++) {
            if (elemento == vetor[i]) return i;
        }
        return -1; // Elemento não existe no vetor
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
