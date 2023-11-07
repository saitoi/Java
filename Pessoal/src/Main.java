import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Conta> listaContas = new ArrayList<>();
        Conta contaAtual;
        int opcao;

        contaAtual = Conta.cadastrar(listaContas);   /* Uma conta deve ser cadastrada pelo menos uma vez */

        while (true) {
            menu();
            opcao = Global.scanner.nextInt();
            Global.scanner.nextLine();
            switch (opcao) {
                case 0 -> {
                    return;
                }
                case 1 -> contaAtual = Conta.cadastrar(listaContas);
                case 2 -> {
                    try {
                        Global.print("Quanto você deseja depositar? ");
                        contaAtual.depositar(Global.scanner.nextDouble());
                    } catch (SaldoExcedidoException e) {
                        Global.print("Erro: " + e);
                    }
                }
                case 3 -> {
                    Global.print("Quanto você deseja retirar? ");
                    contaAtual.retirar(Global.scanner.nextDouble());
                }
                case 4 -> {
                    try {
                        Conta contaDestino = null;
                        Global.print("Para qual conta você deseja transferir?\nEscolha um id: ");
                        Global.id = Global.scanner.nextInt();

                        for (Conta conta : listaContas) {
                            if (conta.getId() == Global.id) {
                                contaDestino = conta;
                                Global.print("Conta foi encontrada.");
                            }
                        }
                        if (contaDestino == null) {
                            Global.print("Conta destino não foi encontrada..");
                        }
                        Global.print("Quanto você deseja transferir? ");
                        contaAtual.transferencia(contaDestino, Global.scanner.nextDouble());
                    } catch(NullPointerException e) {
                        Global.print("Erro: " + e);
                    } catch(SaldoExcedidoException e) {
                        Global.print("Erro: " + e);
                    }
                }
                default -> {
                    Global.print("Opção não é válida, selecione novamente.");
                }
            }
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
                Escolha uma opção:\s""");
    }
    public static void validarEntrada(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valores negativos não são permitidos.");
        }
    }
}