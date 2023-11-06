public class Automovel {
    protected String chassi, placa;
    protected int ano, num_rodas;
    public Automovel(String chassi) {
        this.chassi = chassi;
    }

    public void print() {
        System.out.print(chassi + "." + num_rodas);
    }
}

