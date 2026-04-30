public class Fila {
    private No primeiro;
    private No ultimo;

    // construtor padrão

    // verifica se a fila esta vazia
    public boolean filaVazia() {
        return primeiro == null;
    }

    // FIFO = First In, First Out
    // inserir na última posição = enfileira()
    // 4 - 7 - 8 - 19, primeiro = 4 e ultimo = 19
    // enfileira(12), novo = [12] e deve ser inserido ao final da fila
    // ultimo.setProximo(novo) = próximo do ultimo (19) é o novo (12)
    public void enfileira(int e) {
        No novo = new No(e); // info = e; proximo = null
        if (filaVazia()) { // quer dizer que a fila passará a ter um único elemento
            primeiro = novo;
        } else { // se a fila não está vazia
            ultimo.setProximo(novo); // 4 - 7 - 8 - 19 - 12, ultimo = 19, ainda não foi atualizado
        }
        ultimo = novo; // ultimo é atualizado, ultimo = 12
    }

    // remove no início = desinfileira()
    public int desinfileira() {
        if (filaVazia())
            throw new RuntimeException("Fila Vazia");

        int temp = primeiro.getInfo();
        primeiro = primeiro.getProximo(); // sobrescreve primeiro pelo segundo

        if (primeiro == null) // fila esta vazia
            ultimo = null;

        return temp;
    }

    // retorna a quantidade de elementos na fila
    public int tamanho() {
        int count = 0;
        No runner = primeiro;
        while (runner != null) {
            count++;
            runner = runner.getProximo();
        }
        return count;
    }

    // Desafio 2 - Jogando Cartas Fora (Beecrowd 1110)
    // Recebe N e simula o descarte: remove o topo, move o próximo para o final.
    // Imprime a sequência de descartadas e, ao final, a carta remanescente.
    public void jogandoCartasFora(int n) {
        if (n <= 0) {
            System.out.println("N deve ser maior que zero.");
            return;
        }

        // Monta a fila com cartas de 1 até N (1 no topo, N no fundo)
        for (int i = 1; i <= n; i++) {
            enfileira(i);
        }

        System.out.print("Descartadas: ");
        while (tamanho() > 1) {
            // Descarta a carta do topo
            int descartada = desinfileira();

            // Imprime com separador apenas se ainda existirem mais cartas a descartar
            if (tamanho() > 1) {
                System.out.print(descartada + ", ");
            } else {
                // Última carta a ser descartada (restará apenas 1 na fila)
                System.out.print(descartada);
            }

            // Move a carta agora no topo para o fundo da fila
            enfileira(desinfileira());
        }

        // A carta que sobrou é a remanescente
        System.out.println();
        System.out.println("Remanescente: " + desinfileira());
    }

    // representação textual para objetos da classe Fila
    public String toString() {
        if (filaVazia())
            return "Fila Vazia";

        String s = "";
        No runner = primeiro;

        // percorrer a fila
        while (runner != null) {
            s += runner + "->";
            runner = runner.getProximo();
        }
        return s;
    }

}

class No {
    private int info;
    private No proximo;

    // inicializa o atributo info
    public No(int info) {
        this.info = info;
        // proximo = null;
    }

    // getters/setters
    public int getInfo() {
        return info;
    }

    public No getProximo() {
        return proximo;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    // @Override
    public String toString() {
        return "[" + info + "]";
    }
}