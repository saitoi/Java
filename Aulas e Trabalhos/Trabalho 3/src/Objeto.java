import java.util.*;

public class Objeto {
    int codigo;
    boolean isA;
    public Objeto(int codigo, boolean isA) {
        this.codigo = codigo;
        this.isA = isA;
    }

    @Override
    public boolean equals(Object objeto) {
        Objeto novoObjeto = (Objeto) objeto;
        if (novoObjeto.isA)
            return ((novoObjeto.codigo / 100) == this.codigo);
        String meuCodigo = String.valueOf(this.codigo);
        String outroCodigo = String.valueOf(novoObjeto.codigo);
        return (meuCodigo.charAt(0) == outroCodigo.charAt(0) &&
                meuCodigo.charAt(meuCodigo.length()) == outroCodigo.charAt(outroCodigo.length()));
    }

    @Override
    public int hashCode() {
        return this.codigo;
    }
    public static boolean adicionaObjetoA(LinkedList<Objeto> objetosA, Objeto novoObjeto) {
        return (novoObjeto.isA && objetosA.contains(novoObjeto));
    }
    public static boolean adicionaObjetoB(HashSet<Objeto> objetosB, Objeto novoObjeto) {
        return ((!novoObjeto.isA) && objetosB.add(novoObjeto));
    }

    public static <T> void imprimir(Collection<T> colecao) {
        for (T elemento : colecao) {
            Objeto objetoAtual = (Objeto) elemento;
            System.out.print(objetoAtual.codigo + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Objeto> todosObjetos = new ArrayList<>();
        LinkedList<Objeto> objetosA = new LinkedList<>();
        HashSet<Objeto> objetosB = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Escolha um código novo: ");
            int codigoNovo = scanner.nextInt();

            System.out.print("O objeto é do tipo A (true/false): ");
            boolean isA = scanner.nextBoolean();

            Objeto novoObjeto = new Objeto(codigoNovo, isA);

            todosObjetos.add(novoObjeto);
            if (adicionaObjetoA(objetosA, novoObjeto))
                objetosA.add(novoObjeto);
            if (adicionaObjetoB(objetosB, novoObjeto))
                objetosB.add(novoObjeto);
            System.out.print("Imprimindo todos os objetos: ");
            imprimir(todosObjetos);
            System.out.print("Imprimindo objetos da Linked List: ");
            imprimir(objetosA);
            System.out.print("Imprimindo objetos do Hash Set: ");
            imprimir(objetosB);
        }
    }
}
