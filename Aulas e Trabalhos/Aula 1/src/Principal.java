public class Principal {
    public static void main(String[] args) {
        Banco b1 = new Banco (1);
        Banco b2 = new Banco (2);
        b1.criar_conta(101, 00008543211);

        Conta c1 = b1.get_conta(101);
        c1.deposita(80.0);

        b1.print();
    }
}


