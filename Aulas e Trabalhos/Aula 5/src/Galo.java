public class Galo implements Animal{
    private int id;
    public Galo (int i) {
        this.id = i;
    }

    public void comer() {
        System.out.println("Galo " + id + " comeu 50g de milho.");
    }
}
