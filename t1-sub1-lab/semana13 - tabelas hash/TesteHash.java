public class TesteHash{

    public static void main(String[] args){
        // K = Integer, V = String
        NossoHash<Integer, String> mapa = new NossoHash<>();
        // inserimos 5 combinações <chave,valor>
        mapa.put(1234,"aaaaaa");
        mapa.put(4567,"bbbbbb");
        mapa.put(8910,"cccccc");
        mapa.put(1112,"dddddd");
        mapa.put(1314,"eeeeee");

        // valor apontado pela chave existe
        String valor = mapa.get(8910); // retorna "cccccc"
        if(valor != null){
            System.out.println("Chave encontrada, valor = " + valor);
        }else{
            System.out.println("Chave não encontrada!");
        }

        // valor apontado pela chave não existe
        valor = mapa.get(1516); // retorna null
        if(valor != null){
            System.out.println("Chave encontrada, valor = " + valor);
        }else{
            System.out.println("Chave nao encontrada!");
        }
    }
}