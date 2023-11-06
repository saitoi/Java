import java.util.Scanner;

public class NATOChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra simples: \n" + "> ");
        String stringValue = scanner.nextLine(); // Usar nextLine() para ler a linha completa
        convertMessage(stringValue);

        scanner.close(); // Fechar o Scanner no final
    }

    public static void convertMessage(String stringValue) {
        int length = stringValue.length();
        for (int i = 0; i < length; ++i) {
            String natoCode = convertNATO(stringValue.charAt(i));
            System.out.println("Character: " + stringValue.charAt(i) + ", NATO Code: " + natoCode);
        }
    }

    public static String convertNATO(char charString) {
        return switch (charString) {
            case 'A', 'a' -> "Able";
            case 'B', 'b' -> "Baker";
            case 'C', 'c' -> "Charlie";
            case 'D', 'd' -> "Dog";
            case 'E', 'e' -> "Easy";
            default -> {
                yield "Char not found";
            }
        };
    }
}
