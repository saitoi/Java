public class Conta {
    private int num, CPF;
    private double saldo;

    public Conta(int n, int CPF) {
        this.num = n;
        this.CPF = CPF;
        this.saldo = 0.0;
    }

    public int get_numero() {
        return this.num;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }
    
    public double get_saldo() {
        return this.saldo;
    }

    public void print() {
        System.out.print(num + " " + CPF + " " + saldo);
    }
}
