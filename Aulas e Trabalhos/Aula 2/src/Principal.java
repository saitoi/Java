public class Principal {
    public static void main(String[] args) {
        Automovel a1 = new Automovel("123CDE123CDE");
        Passeio p1 = new Passeio("456FEH456FGH");
        Utilitario u1 = new Utilitario("78912K78912K", 12);
        a1.print();
        p1.print();
        u1.print();

        Carrinho fusquinha = new Carrinho("123CDE123CDE", "besouro");
        System.out.println("\nO apelido do meu carrinho é " + fusquinha.apelido);
    }
}
