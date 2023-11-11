import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Conta> listaContas = new HashSet<>();
        Conta contaAtual;
        int opcao;

        try {
            contaAtual = Conta.cadastrar(listaContas);

            while (true) {
                menu();
                opcao = Global.scanner.nextInt();
                Global.scanner.nextLine();
                switch (opcao) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> contaAtual = Conta.cadastrar(listaContas);
                    case 2 -> contaAtual.depositar();
                    case 3 -> contaAtual.retirar();
                    case 4 -> contaAtual.transferencia(listaContas);
                    case 5 -> {
                        for (Conta conta : listaContas) {
                            Global.print("Conta: " + conta.getId() + ", Saldo: " + conta.getSaldo());
                        }
                    }
                    default -> {
                        Global.print("Opção não é válida, selecione novamente.");
                    }
                }
            }
        } catch(IllegalArgumentException e) {
            Global.print("Entrada de valores negativos não é aceita.");
        }
    }
    private static void menu() {
        System.out.println("\n\nSeja Bem-vindo!");
        System.out.print("""
                MENU
                0 - Sair
                1 - Cadastrar conta
                2 - Depositar
                3 - Retirar/Sacar
                4 - Transferir p/outra conta
                5 - Imprimir lista de contas
                Escolha uma opção:\s""");
    }
    public static void validarEntrada(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valores negativos não são permitidos.");
        }
    }

}