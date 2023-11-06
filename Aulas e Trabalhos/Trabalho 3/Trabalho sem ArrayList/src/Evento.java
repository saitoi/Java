import java.util.Arrays;
import java.util.Scanner;

public class Evento {
    public int identificador;
    public int ocorrencias;
    public String descricao;
    Pessoa[] pessoasEvento = new Pessoa[100];

    Evento(String descricao, int identificador) {
        this.descricao = descricao;
        this.identificador = identificador;
    }

    public static void listarEventos(Evento[] listaEventos) {
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

}

