import javax.swing.JOptionPane;

public class PreencherExibir{

    public static void main(String[] args){
        int v[] = new int[10]; // construindo um vetor com 10 posições (índice de 0 até 9)

        // preenchendo o vetor
        // i vai de 0 até 9
        for(int i=0; i < v.length; i++){
            v[i] = Integer.parseInt(
                JOptionPane.showInputDialog("Digite um número: ")
            );
        }
        // exibir os elementos do vetor em uma única mensagem
        String s = "";
        for(int i=0; i < v.length; i++){
            s = s + v[i] + " ";
        }
        JOptionPane.showMessageDialog(null,s);
    }
}