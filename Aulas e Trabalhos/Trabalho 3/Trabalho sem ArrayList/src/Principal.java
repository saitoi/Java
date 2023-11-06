import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    public static int tamListaEvento = 0;
    public static int tamListaPessoas = 0;

    public static void main(String[] args) {
        Pessoa[] listaPessoas = new Pessoa[100];
        Evento[] listaEventos = new Evento[100];

        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            menu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0 -> { return; }
                case 1 -> cadastrarPessoa(listaPessoas, scanner);
                case 2 -> cadastrarEvento(listaPessoas, listaEventos, scanner, tamListaEvento);
                case 3 -> Evento.listarEventos(listaEventos);
                default -> ocorrerEvento(listaEventos, opcao);
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
        return Arrays.copyOf(array, array.length * 2);
    }

    public static void cadastrarEvento(Pessoa[] listaPessoas, Evento[] listaEventos, Scanner scanner, int tamListaEvento) {
        boolean verificarIdentificador;
        int identificadorNovo;

        if (tamListaEvento == 100)
            listaEventos = overflow(listaEventos);

        System.out.print("Descrição do novo evento: ");
        String descricao = scanner.nextLine();

        do {
            System.out.print("Identificador do evento novo: ");
            identificadorNovo = scanner.nextInt();

            verificarIdentificador = false;
            for (int i = 0; i < tamListaEvento; i++) {
                if (listaEventos[i] != null && listaEventos[i].identificador == identificadorNovo) {
                    verificarIdentificador = true;
                    break;
                }
            }

            if (verificarIdentificador) {
                System.out.println("Identificador já existe. Insira um novo identificador.");
            }

        } while (verificarIdentificador);

        Evento eventoNovo = new Evento(descricao, identificadorNovo);

        Pessoa.imprimirPessoas(listaPessoas);

        System.out.println("Quais pessoas participarão do evento (identificador -1 para encerrar): ");

        int id;
        while ((id = scanner.nextInt()) != -1)
            for (int i = 0; i < tamListaPessoas; i++)
                if (id == listaPessoas[i].getIdentificador())
                    eventoNovo.pessoasEvento[i] = listaPessoas[i];

        listaEventos[tamListaEvento] = eventoNovo;

        ++(tamListaEvento);
    }

    public static void cadastrarPessoa(Pessoa[] listaPessoas, Scanner scanner) {
        boolean verificaIdentificador;

        System.out.print("Nome da pessoa nova: ");
        String nomeNovo = scanner.nextLine();

        if (tamListaPessoas == 100)
            listaPessoas = overflow(listaPessoas);

        do {
            System.out.print("Identificador da pessoa nova (exceto -1): ");
            int identificadorNovo = scanner.nextInt();

            verificaIdentificador = false;
            for (Pessoa pessoa : listaPessoas)
                if (pessoa != null && pessoa.identificador == identificadorNovo)
                    verificaIdentificador = true;

            if (verificaIdentificador) {
                System.out.println("Identificador já existe. Insira um novo identificador.");
            } else {
                listaPessoas[tamListaPessoas] = new Pessoa(nomeNovo, identificadorNovo);
            }

            scanner.nextLine();

        } while (verificaIdentificador);

        ++tamListaPessoas;
    }
    public static void ocorrerEvento(Evento[] listaEventos, int identificador) {
        Evento eventoEncontrado = null;
        int indiceEventoEncontrado = -1;
        System.out.print("Entrei");
        // Encontrar o evento e seu índice
        for (int i = 0; i < tamListaEvento; i++) {
            if (listaEventos[i] != null && listaEventos[i].identificador == identificador) {
                eventoEncontrado = listaEventos[i];
                ++(listaEventos[i].ocorrencias);
                indiceEventoEncontrado = i;
                break;
            }
        }

        if (eventoEncontrado != null) {
            if (indiceEventoEncontrado >= 0 && indiceEventoEncontrado < tamListaEvento) {
                // Remover o evento encontrado do array
                for (int i = indiceEventoEncontrado; i < tamListaEvento - 1; i++) {
                    listaEventos[i] = listaEventos[i + 1];
                }
                listaEventos[tamListaEvento - 1] = null; // Limpar a última posição

                // Atualizar o tamanho da lista
                tamListaEvento--;

                // Mover o evento encontrado para a primeira posição
                for (int i = tamListaEvento; i > 0; i--) {
                    listaEventos[i] = listaEventos[i - 1];
                }
                listaEventos[0] = eventoEncontrado;

                System.out.println("Evento " + eventoEncontrado.descricao + " ocorreu e foi movido para a primeira posição.");
            } else {
                System.out.println("Índice do evento encontrado é inválido.");
            }
        } else {
            System.out.println("Evento não foi encontrado.");
        }

        System.out.println("\nOrdem dos eventos:");
        for (int i = 0; i < tamListaEvento; i++) {
            if (listaEventos[i] != null) {
                System.out.println("Evento: " + listaEventos[i].descricao + ", Id: " + listaEventos[i].identificador);
                System.out.println("-------------");
            }
        }
    }

}
