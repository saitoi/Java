public class Principal {
    public void outro() {
        Estudante Aluno1 = new Estudante("Pedro", 18, 122149392);
        System.out.println("O nome do primeiro estudante é " + Aluno1.getNome());

        try {
            Aluno1.changeNomeConsole();
        } catch(NullPointerException e) {
            Aluno1.changeNomeScanner();
        } finally {
            System.out.println("Dados lidos com sucesso.");
        }


        System.out.println("Agora o nome do primeiro estudante é " + Aluno1.getNome());
    }

    public static void main(String[] args) {
        Principal objeto = new Principal();
        objeto.outro();
    }

}
