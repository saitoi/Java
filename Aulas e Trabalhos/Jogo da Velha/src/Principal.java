import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String[][] jogoDaVelha = new String[3][3];
        int jogadorUm = 0;

        inicializarJogoDaVelha(jogoDaVelha);
        while(!verificarVencedor(jogoDaVelha)) {
            imprimirJogoVelha(jogoDaVelha);
            inserirPosição(jogoDaVelha, (jogadorUm++ % 2 == 0));
        }
        imprimirJogoVelha(jogoDaVelha);
        System.out.println("Parabéns! O vencedor foi o jogador " + (++jogadorUm % 2 == 0 ? "1" : "2") + " !!");
    }
    public static void imprimirJogoVelha(String[][] jogoDaVelha) {
        System.out.println(" " + jogoDaVelha[0][0] + " | " + jogoDaVelha[0][1] + " | " + jogoDaVelha[0][2] + " ");
        System.out.println("------------");
        System.out.println(" " + jogoDaVelha[1][0] + " | " + jogoDaVelha[1][1] + " | " + jogoDaVelha[1][2] + " ");
        System.out.println("------------");
        System.out.println(" " + jogoDaVelha[2][0] + " | " + jogoDaVelha[2][1] + " | " + jogoDaVelha[2][2] + " \n");
    }
    public static void inicializarJogoDaVelha(String[][] jogoDaVelha) {
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                jogoDaVelha[i][j] = " ";
    }
    public static boolean verificarVencedor(String[][] jogoDaVelha) {
        /* Linhas e Colunas */
        for (int i = 0; i < 3; ++i) {
            if (!(jogoDaVelha[i][0] == " ") && jogoDaVelha[i][0].equals(jogoDaVelha[i][1]) && jogoDaVelha[i][1].equals(jogoDaVelha[i][2]))
                return true;
            if (!(jogoDaVelha[0][i] == " ") && jogoDaVelha[0][i].equals(jogoDaVelha[1][i]) && jogoDaVelha[1][i].equals(jogoDaVelha[2][i]))
                return true;
        }
        /* Diagonais */
        if (!(jogoDaVelha[1][1] == " ")) {
            if (jogoDaVelha[0][0].equals(jogoDaVelha[1][1]) && jogoDaVelha[1][1].equals(jogoDaVelha[2][2]))
                return true;
            else if (jogoDaVelha[0][2].equals(jogoDaVelha[1][1]) && jogoDaVelha[1][1].equals(jogoDaVelha[2][0]))
                return true;
        }
        return false;
    }
    public static void inserirPosição(String[][] jogoDaVelha, boolean jogadorUm) {
        String posicao = " ";
        Scanner scanner = new Scanner(System.in);
        int i = -1, j = -1;

        while (i == -1 || j == -1 || jogoDaVelha[i][j].equals("X") || jogoDaVelha[i][j].equals("O")) {
            System.out.print("Vez do jogador " + (jogadorUm ? "1" : "2") + ", escolha uma posição da matriz (x,y): ");
            posicao = scanner.nextLine();
            for (char numero : posicao.toCharArray()) {
                if (Character.isDigit(numero))
                    if (i == -1)
                        i = Character.getNumericValue(numero);
                    else
                        j = Character.getNumericValue(numero);
            }
            if (i == -1 || j == -1 || jogoDaVelha[i][j].equals("X") || jogoDaVelha[i][j].equals("O"))
                System.out.println("Tente novamente, valores inválidos..");
        }
        System.out.println("");
        jogoDaVelha[i][j] = (jogadorUm) ? "X" : "O";
    }
}
