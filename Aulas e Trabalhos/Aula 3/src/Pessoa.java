import java.util.Scanner;

public class Pessoa {

    protected String nome;
    public int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {   /* Getter */
        return this.nome;
    }
}

