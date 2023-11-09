import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static Conta cadastrar(List<Conta> listaContas) {
        Global.print("Escolha um identificador para conta nova: ");
        int idNovo = Global.scanner.nextInt();
        validarEntrada(idNovo);
        Conta novaConta = new Conta(idNovo);

        if (listaContas.contains(novaConta)) {
            Global.print("A conta já consta no banco.");
        } else listaContas.add(novaConta);

        return novaConta;
    }

    public void depositar(double valor) throws SaldoExcedidoException{
        validarEntrada(valor);

        if (this.saldo + valor > 1000) {
            throw new SaldoExcedidoException();
        }
        this.saldo += valor;
        Global.print("Você depositou " + valor + " em sua conta com sucesso.");
    }

    public void retirar(double valor) {
        validarEntrada((valor));

        try {
            if (this.saldo - valor < 0) {
                throw new SaldoNegativoException();
            }
        } catch (SaldoNegativoException e) {
            Global.print("Erro: " + e);
        }
        this.saldo -= valor;
        Global.print("Você sacou " + valor + " da sua conta com sucesso.");
    }

    public void transferencia(Conta contaDestino, double valor) throws SaldoExcedidoException {
        validarEntrada(valor);
        contaDestino.depositar(valor);
        this.retirar(valor);
    }
    public static void validarEntrada(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valores negativos não são permitidos.");
        }
    }
}
