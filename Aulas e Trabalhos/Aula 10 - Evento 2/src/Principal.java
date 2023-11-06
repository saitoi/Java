import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Pessoa[] listaPessoas = new Pessoa[1];
        Evento[] listaEventos = new Evento[1];
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while(true) {
            menu();
            opcao = scanner.nextInt(); scanner.nextLine();
            switch (opcao) {
                case 0 -> { return; }
                case 1 -> listaPessoas = Pessoa.cadastrarPessoa(listaPessoas, scanner);
                case 2 -> listaEventos = Evento.cadastrarEvento(listaPessoas, listaEventos, scanner);
                case 3 -> Evento.listarEventos(listaEventos);
                default -> listaEventos = Evento.ocorrerEvento(listaEventos, opcao);
            }
        }
    }

    private static void menu() {
        System.out.println("\n\nSeja Bem-vindo!");
        System.out.print("""
                MENU
                0 - Sair
                1 - Cadastrar pessoa
                2 - Cadastrar evento
                3 - Listagem dos eventos
                Numero positivo - Ocorrência do evento
                Escolha uma opção:\s""");
    }
    public static <T> T[] overflow(T[] array) {
        return Arrays.copyOf(array, array.length+1);
    }
}