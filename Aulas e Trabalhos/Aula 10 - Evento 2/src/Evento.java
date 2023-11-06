import java.util.Scanner;

public class Evento {
    public int identificador;
    public int ocorrencias;
    public String descricao;
    Pessoa[] pessoasEvento = new Pessoa[1];

    Evento(String descricao, int identificador) {
        this.descricao = descricao;
        this.identificador = identificador;
    }

    public static Evento[] cadastrarEvento(Pessoa[] listaPessoas, Evento[] listaEventos, Scanner scanner) {
        boolean verificarIdentificador;
        int identificadorNovo;

        System.out.print("Descrição do novo evento: ");
        String descricao = scanner.nextLine();

        do {
            System.out.print("Identificador do evento novo: ");
            identificadorNovo = scanner.nextInt();

            verificarIdentificador = false;
            for (int i = 0; i < listaEventos.length - 1; ++i)
                if (listaEventos[i].identificador == identificadorNovo)
                    verificarIdentificador = true;

            if (verificarIdentificador)
                System.out.println("Identificador já existe. Insira um novo identificador.");

        }while (verificarIdentificador);

        Evento eventoNovo = new Evento(descricao, identificadorNovo);
        eventoNovo.pessoasEvento = new Pessoa[listaPessoas.length];

        Pessoa.imprimirPessoas(listaPessoas);

        System.out.println("Quais pessoas participarão do evento (identificador -1 para encerrar): ");

        System.out.println("O tamanho do vetor de pessoas é " + listaPessoas.length);
        int id, j = 0;
        while (( id = scanner.nextInt()) != -1) {
            for (int i = 0; i < listaPessoas.length - 1; ++i)
                if (id == listaPessoas[i].getIdentificador()) {
                    eventoNovo.pessoasEvento[j] = listaPessoas[i];
                    ++j;
                }
        }
        listaEventos[listaEventos.length - 1] = eventoNovo;
        return Principal.overflow(listaEventos);
    }

    public static void listarEventos(Evento[] listaEventos) {
        System.out.println("\n\nLista de Eventos:");
        for (int i = 0; i < listaEventos.length - 1; ++i) {
            System.out.println("Identificador: " + listaEventos[i].identificador);
            System.out.println("Descrição: " + listaEventos[i].descricao);
            System.out.println("Pessoas relacionadas:");
            for (int j = 0;listaEventos[i].pessoasEvento[j] != null && j < listaEventos[i].pessoasEvento.length - 1; ++j) {
                System.out.println("- " + listaEventos[i].pessoasEvento[j].getNome());
            }
            System.out.println("-------------------");
        }
    }
    public static Evento[] ocorrerEvento(Evento[] listaEventos, int identificador) {
        Evento eventoEncontrado = null;

        for (int i = 0; i < listaEventos.length - 1; ++i) {
            if (listaEventos[i].identificador == identificador) {
                eventoEncontrado = listaEventos[i];
                ++(listaEventos[i].ocorrencias);
            }
        }

        if (eventoEncontrado == null) {
            System.out.println("Evento não foi encontrado.");
            return listaEventos;
        }

        Evento[] listaNova = new Evento[listaEventos.length];
        listaNova[0] = eventoEncontrado;
        for (int i = 1, j = 0; i < listaEventos.length - 1; ++i, ++j) {
            if (listaEventos[j] == eventoEncontrado) ++j;
            listaNova[i] = listaEventos[j];
        }
        System.out.println("Evento " + eventoEncontrado.descricao + " ocorreu e foi movido para a primeira posição.");

        System.out.println("\nOrdem dos eventos:");
        for (int i = 0; i < listaNova.length - 1; ++i) {
            System.out.println("Evento: " + listaNova[i].descricao + ", Id: " + listaNova[i].identificador);
            System.out.println("------------------");
        }

        return listaNova;
    }

}
