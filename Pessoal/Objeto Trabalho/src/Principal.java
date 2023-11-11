import java.util.*;

public class Principal {
    public static void main(String[] args) {
        List<Objeto> objetos = new ArrayList<>();
        LinkedList<ObjetoA> objetosA = new LinkedList<>();
        HashSet<ObjetoB> objetosB = new HashSet<>();

        while (true) {
            menu();
            switch (Global.scanner.nextInt()) {
                case 0 -> { return; }
                case 1 -> criarObjeto(ObjetoA.class, objetosA, objetos);
                case 2 -> criarObjeto(ObjetoB.class, objetosB, objetos);
                case 3 -> imprimirLista(objetos);
                case 4 -> imprimirLista(objetosA);
                case 5 -> imprimirLista(objetosB);
            }
        }
    }

    public static void menu() {
        System.out.print("""
                MENU
                0 - Sair
                1 - Criar objeto A
                2 - Criar objeto B
                3 - Imprimir lista de todos objetos
                4 - Imprimir objetos A
                5 - Imprimir objetos B
                Escolha uma opção:\s""");
    }

    public static <T extends Objeto> void criarObjeto(Class<T> classeObjeto, Collection<T> lista, List<Objeto> objetos) {
        System.out.println("Código novo para " + classeObjeto.getName() + ": ");
        int codigo = Global.scanner.nextInt();
        try {
            T objetoNovo = classeObjeto.getConstructor(int.class).newInstance(codigo);
            objetos.add(objetoNovo);
            lista.contains();
            /*
            * for (T objetoAtual : lista) {
                if (objetoAtual.comparar(objetoNovo)) {
                    return;
                }
            }
            * */

            lista.add(objetoNovo);
        } catch (Exception e) {
            System.out.println("Erro ao criar objeto: " + e.getMessage());
        }
    }

    public static void imprimirLista(Collection<? extends Objeto> listaObjetos) {
        for (Objeto objeto : listaObjetos) {
            System.out.print("(" + objeto.codigo + ")");
        }
        System.out.println();
    }
}
