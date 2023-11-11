public class SaldoNegativoException extends RuntimeException{
    public SaldoNegativoException() {
        super("O saldo da conta não pode ficar abaixo de R$0,00.");
    }
}
