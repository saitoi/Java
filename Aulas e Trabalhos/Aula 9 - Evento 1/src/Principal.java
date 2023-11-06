import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while(true) {
            menu();
            opcao = scanner.nextInt(); scanner.nextLine();
            switch (opcao) {
                case 0 -> { return; }
                case 1 -> Pessoa.cadastrarPessoa(listaPessoas, scanner);
                case 2 -> Evento.cadastrarEvento(listaPessoas, listaEventos, scanner);
                case 3 -> Evento.listarEventos(listaEventos);
                default -> Evento.ocorrerEvento(listaEventos, opcao);
            }
        }
    }

    private static void menu() {
        System.out.println("\n\nSeja Bem-vindo!");
        System.out.print("MENU\n" +
                "0 - Sair\n" +
                "1 - Cadastrar pessoa\n" +
                "2 - Cadastrar evento\n" +
                "3 - Listagem das pessoas\n" +
                "Numero positivo - Ocorrência do evento\n" +
                "Escolha uma opção: ");
    }
}
