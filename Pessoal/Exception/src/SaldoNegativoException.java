public class SaldoNegativoException extends Exception{
    public SaldoNegativoException() {
        super("O saldo da conta não pode ficar abaixo de R$0,00.");
    }
}
