import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        Conta conta1 = new Conta(1, 50);
        Conta conta2 = new Conta(1, 40);

        while (true) {
            menu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 0 -> { return; }
                case 1 -> conta1.deposito();
                case 2 -> conta1.retirada();
                case 3 -> conta1.transferencia(conta2);
                default -> throw new IllegalArgumentException("Opção não é permitida.");
            }
        }
    }

    public static void menu() {
        System.out.println("\n\nSeja Bem-vindo!");
        System.out.print("""
                MENU
                0 - Sair
                1 - Depositar
                2 - Retirar
                3 - Transferir para outra conta
                Escolha uma opção:\s""");
    }
}
