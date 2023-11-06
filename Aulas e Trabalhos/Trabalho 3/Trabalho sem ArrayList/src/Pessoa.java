import java.util.List;
import java.util.Scanner;

public class Pessoa {
    public String nome;
    public int identificador;


    Pessoa(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public static void imprimirPessoas(Pessoa[] listaPessoasw) {
        System.out.println("\n\nLista de Pessoas:");
        for (Pessoa pessoa : listaPessoas) {
            System.out.println("Nome: " + pessoa.nome);
            System.out.println("Identificador: " + pessoa.identificador);
            System.out.println("-------------------");
        }
    }
}
