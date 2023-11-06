import java.util.Scanner;

public class Estudante extends Pessoa {

    private int matricula;

    public Estudante(String nome, int idade, int matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public void changeNomeConsole() {
        this.nome = System.console().readLine("");
    }

    public void changeNomeScanner() {
        Scanner scanner = new Scanner(System.in);
        this.nome = scanner.next();
        scanner.close();
    }
}
