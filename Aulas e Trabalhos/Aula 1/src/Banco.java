public class Banco {
    /* Atributos */
    private int numero_banco;
    private Conta[] conj_contas;
    private int qtde_contas;

    /* Métodos */
    public Banco(int numero_banco) {
        this.numero_banco = numero_banco;
        this.conj_contas = new Conta[100];
        this.qtde_contas = 0;
    }

    public void criar_conta(int n, int CPF) {
        Conta c1 = new Conta(n, CPF);
        this.conj_contas[qtde_contas++] = c1;
    }
}
