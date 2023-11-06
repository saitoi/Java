import java.util.Scanner;

public class Conta {
    int identificador;
    double saldo;
    Scanner scanner = new Scanner(System.in);

    public Conta(int identificador, double saldo) {
        this.identificador = identificador;
        this.saldo = saldo;
    }

    public void deposito() {
        try {
            System.out.println("Qual valor você deseja depositar? ");
            double valor = scanner.nextDouble();
            valorNegativo(valor);
            if (valor + this.saldo <= 100) {
                this.saldo += valor;
            } else {
                throw new SaldoMaiorQueCemException("Saldo na conta não pode ultrapassar cem.");
            }
        } catch (SaldoMaiorQueCemException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void retirada() {
        try {
            System.out.println("Qual valor você deseja retirar? ");
            double valor = scanner.nextDouble();
            valorNegativo(valor);

            if (this.saldo - valor >= 0) {
                this.saldo -= valor;
            } else {
                throw new SaldoMenorQueZero("Saldo na conta não pode ser negativo.");
            }
        } catch (SaldoMenorQueZero e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void transferencia(Conta contaDestino) {
        try {
            System.out.println("Qual valor você deseja transferir? ");
            double valor = scanner.nextDouble();
            valorNegativo(valor);

            if (this.saldo - valor >= 0) {
                if (contaDestino.saldo + valor <= 100) {
                    this.saldo -= valor;
                    contaDestino.saldo += valor;
                } else {
                    throw new SaldoMaiorQueCemException("Saldo na conta de destino não pode ultrapassar cem.");
                }
            } else {
                throw new SaldoMenorQueZero("Saldo na conta não pode ser negativo.");
            }
        } catch (SaldoMaiorQueCemException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (SaldoMenorQueZero e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void valorNegativo(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo.");
        }
    }
}
