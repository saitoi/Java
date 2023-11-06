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
    public static Pessoa[] cadastrarPessoa(Pessoa[] listaPessoas, Scanner scanner) {
        boolean verificaIdentificador;

        System.out.print("Nome da pessoa nova: ");
        String nomeNovo = scanner.nextLine();

        do {
            System.out.print("Identificador da pessoa nova (exceto -1): ");
            int identificadorNovo = scanner.nextInt();

            verificaIdentificador = false;
            for (int i = 0; i < listaPessoas.length - 1; ++i)
                if (listaPessoas[i].identificador == identificadorNovo)
                    verificaIdentificador = true;

            if (verificaIdentificador)
                System.out.println("Identificador já existe. Insira um novo identificador.");
            else
                listaPessoas[listaPessoas.length - 1] = new Pessoa(nomeNovo, identificadorNovo);

            scanner.nextLine();

        } while (verificaIdentificador);

        return Principal.overflow(listaPessoas);
    }

    public static void imprimirPessoas(Pessoa[] listaPessoas) {
        System.out.println("\n\nLista de Pessoas:");
        for (int i = 0; i < listaPessoas.length - 1; ++i) {
            System.out.println("Nome: " + listaPessoas[i].getNome());
            System.out.println("Identificador: " + listaPessoas[i].getIdentificador());
            System.out.println("-------------------");
        }
    }
}