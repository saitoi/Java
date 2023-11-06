import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int identificador;


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
    public static void cadastrarPessoa(ArrayList<Pessoa> listaPessoas, Scanner scanner) {
        boolean verificaIdentificador = false;

        System.out.print("Nome da pessoa nova: ");
        String nomeNovo = scanner.nextLine();

        do {
            System.out.print("Identificador da pessoa nova (exceto -1): ");
            int identificadorNovo = scanner.nextInt();

            verificaIdentificador = false;
            for (Pessoa pessoa : listaPessoas)
                if (pessoa.identificador == identificadorNovo)
                    verificaIdentificador = true;

            if (verificaIdentificador)
                System.out.println("Identificador já existe. Insira um novo identificador.");
            else
                listaPessoas.add(new Pessoa(nomeNovo, identificadorNovo));


            scanner.nextLine();

        } while (verificaIdentificador);
    }

    public static void imprimirPessoas(ArrayList<Pessoa> listaPessoas) {
        System.out.println("\n\nLista de Pessoas:");
        for (Pessoa pessoa : listaPessoas) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Identificador: " + pessoa.getIdentificador());
            System.out.println("-------------------");
        }
    }
}
