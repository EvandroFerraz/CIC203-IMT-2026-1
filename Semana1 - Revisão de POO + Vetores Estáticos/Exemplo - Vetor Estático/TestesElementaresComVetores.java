import javax.swing.JOptionPane;

public class TestesElementaresComVetores{

    public static void main(String[] args){
        //posições vão do indice 0 até 3
        int v[] = new int[4];
        v[0] = 2;
        System.out.println(v[0]); // saida: 2
        System.out.println(v[2]); // saida: 0

        v[1] = Integer.parseInt(
            JOptionPane.showInputDialog("Digite um número:")
        );
        JOptionPane.showMessageDialog(null, v[1]);

        System.out.println(v.length); //saída: 4
    }
}