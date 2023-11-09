import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Objeto> objetos = new ArrayList<>();
        LinkedList<ObjetoA> objetosA = new LinkedList<>();
        HashSet<ObjetoB> objetosB = new HashSet<>();

        switch (Global.scanner.nextInt()) {
            case 0 -> {
                return;
            }
            case 1 -> {

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
}