import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Evento {
    public int identificador;
    public int ocorrencias;
    public String descricao;
    ArrayList<Pessoa> pessoasEvento = new ArrayList<Pessoa>();

    Evento(String descricao, int identificador) {
        this.descricao = descricao;
        this.identificador = identificador;
    }

    public static void cadastrarEvento(ArrayList<Pessoa> listaPessoas, ArrayList<Evento> listaEventos, Scanner scanner) {
        boolean verificarIdentificador;
        int identificadorNovo;

        System.out.print("Descrição do novo evento: ");
        String descricao = scanner.nextLine();

        do {
            System.out.print("Identificador do evento novo: ");
            identificadorNovo = scanner.nextInt();

            verificarIdentificador = false;
            for (Evento evento : listaEventos)
                if (evento.identificador == identificadorNovo)
                    verificarIdentificador = true;

            if (verificarIdentificador)
                System.out.println("Identificador já existe. Insira um novo identificador.");

        }while (verificarIdentificador);

        Evento eventoNovo = new Evento(descricao, identificadorNovo);

        Pessoa.imprimirPessoas(listaPessoas);

        System.out.println("Quais pessoas participarão do evento (identificador -1 para encerrar): ");

        int id;
        while (( id = scanner.nextInt()) != -1) {
            for (Pessoa pessoa : listaPessoas) {
                if (id == pessoa.getIdentificador()) {
                    eventoNovo.pessoasEvento.add(pessoa);
                }
            }
        }
        listaEventos.add(eventoNovo);
    }

    public static void listarEventos(ArrayList<Evento> listaEventos) {
        System.out.println("\n\nLista de Eventos:");
        for (Evento evento : listaEventos) {
            System.out.println("Identificador: " + evento.identificador);
            System.out.println("Descrição: " + evento.descricao);
            System.out.println("Pessoas relacionadas:");
            for (Pessoa pessoa : evento.pessoasEvento) {
                System.out.println("- " + pessoa.getNome());
            }
            System.out.println("-------------------");
        }
    }
    public static void ocorrerEvento(ArrayList<Evento> listaEventos, int identificador) {
        Evento eventoEncontrado = null;

        Iterator<Evento> iterator = listaEventos.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().identificador == identificador) {
                eventoEncontrado = iterator.next();
                iterator.remove();
                break;
            }
        }

        if (eventoEncontrado != null) {
            listaEventos.add(0, eventoEncontrado);
            System.out.println("Evento " + eventoEncontrado.descricao + " ocorreu e foi movido para a primeira posição.");
        } else {
            System.out.println("Evento não foi encontrado.");
        }

        System.out.println("\nOrdem dos eventos:");
        for (Evento evento : listaEventos) {
            System.out.println("Evento: " + evento.descricao + ", Id: " + evento.identificador);
            System.out.println("-------------");
        }
    }

    @Override
    public String toString() {
        return "Evento{" +
                "identificador=" + identificador +
                ", ocorrencias=" + ocorrencias +
                ", descricao='" + descricao + '\'' +
                ", pessoasEvento=" + pessoasEvento +
                '}';
    }
}

