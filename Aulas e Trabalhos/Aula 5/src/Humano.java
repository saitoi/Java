public class Humano implements Animal{
    private int id;
    public Humano(int i) {
        this.id = i;
    }

    public void comer() {
        System.out.println("Humano " + id + " comeu feijão, arroz e carne.");
    }
    public void profissao() {
        System.out.println("Humano " + id + " trabalha com computação.");
    }
}
