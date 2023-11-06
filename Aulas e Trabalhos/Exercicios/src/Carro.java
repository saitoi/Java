public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022);
        Carro carrinho = new Carro("Fusca", "Borboleta", 1970);
        System.out.println(carro.toString());    /* Saída: Carro@36baf30c */
        System.out.println(carrinho.toString()); /* Saída: Carro@7a81197d */

    }
}
