import java.util.Random;

import javax.swing.JOptionPane;

public class CalcularMedia {
    public static void main(String[] args){

        // Random = gera numeros aleatórios
        Random gerador = new Random();
        double v[] = new double[100];

        // Preenchendo o vetor com numeros aleatórios
        for(int i=0; i < v.length; i++){
            v[i] = gerador.nextDouble() * 5 + 3;
        }
        // Calculando a média dos numeros no vetor
        double soma = 0;
        // Somando os números do vetor
        for(int i=0; i < v.length; i++){
            soma = soma + v[i];
            // soma += v[i]
        }
        
        double media = soma/v.length;
        JOptionPane.showMessageDialog(null, "A média é: " + media);
    }
}
