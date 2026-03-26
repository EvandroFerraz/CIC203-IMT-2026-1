public class Exercicio3 {
    /**
     * 3- criar um método que recebe um texto e o retorna de trás para frente,
     * usando recursão.
     */
    public static String inverterTexto(String texto) {
        // 1. Caso Base: Se o texto tiver 1 caractere ou menos, retorna ele mesmo.
        if (texto.length() <= 1) {
            return texto;
        }

        // 2. Caso Recursivo: Pega o texto a partir da segunda letra,
        // inverte esse pedaço, e cola a primeira letra no final.
        return inverterTexto(texto.substring(1)) + texto.charAt(0);
    }

    static void main(String args[]) {
        String palavra = "recursao";

        String resultado = inverterTexto(palavra);

        System.out.println("Palavra original: " + palavra);
        System.out.println("Palavra invertida: " + resultado);
        // Saída esperada: oasrucer
    }
}
