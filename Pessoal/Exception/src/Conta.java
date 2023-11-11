import java.util.HashSet;
import java.util.List;

public class Conta {
    private int id;
    private double saldo;
    public Conta(int id) {
        this.id = id;
        this.saldo = 0;
    }
    public int getId() {
        return this.id;
    }
    public double getSaldo() {
        return this.saldo;
    }

    public static Conta cadastrar(HashSet<Conta> listaContas) {
        int idNovo = 0;
        Global.print("Escolha um identificador para conta nova: ");
        try {
            idNovo = Global.scanner.nextInt();
            validarEntrada(idNovo);
        } catch(IllegalArgumentException e) {
            Global.print("Entrada inválida, erro: " + e);
        }
        Conta novaConta = new Conta(idNovo);
        if (listaContas.add(novaConta)) {
            Global.print("Conta foi adicionada com sucesso.");
        } else Global.print("Identificador já consta.");

        return novaConta;
    }

    public double depositar() {
        Global.print("Quanto você deseja depositar? ");
        double valor = Global.scanner.nextDouble();
        validarEntrada(valor);
        try {
            if (this.saldo + valor > 1000) {
                throw new SaldoExcedidoException();
            }
            this.saldo += valor;
            Global.print("Você depositou " + valor + " em sua conta com sucesso.");
        } catch(SaldoExcedidoException e) {
            Global.print("Erro: " + e);
        }
        return valor;
    }
    public void retirar() {
        Global.print("Quanto você deseja retirar? ");
        double valor = Global.scanner.nextDouble();
        validarEntrada(valor);
        retirar(valor);
    }
    public void retirar(double valor) {
        if (this.saldo - valor < 0) {
            throw new SaldoNegativoException();
        }

        this.saldo -= valor;
        Global.print("Você sacou " + valor + " da sua conta com sucesso.");
    }

    public void transferencia(HashSet<Conta> listaContas) {
        Global.print("Para qual conta você deseja transferir?\nId: ");
        int id = Global.scanner.nextInt();
        for (Conta conta : listaContas) {
            if (conta.getId() == id) {
                this.retirar(conta.depositar());
                return;
            }
        }
    }
    public static void validarEntrada(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valores negativos não são permitidos.");
        }
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    @Override
    public boolean equals(Object objeto) {
        if(this == objeto) {
            return true;
        }
        if (objeto instanceof Conta) {
            return (this.getId() == ((Conta) objeto).getId());
        } return false;
    }
}
