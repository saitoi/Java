public class SaldoExcedidoException extends Exception{
    public SaldoExcedidoException() {
        super("O saldo da conta não pode ultrapassar R$1.000,00.");
    }
}
