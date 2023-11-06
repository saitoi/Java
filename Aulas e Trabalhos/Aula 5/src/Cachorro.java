public class Cachorro implements Animal{
    private int id;
    public Cachorro(int i) {
        this.id = i;
    }

    public void comer() {
        System.out.println("Cachorro " + id + " comeu 200g de ração.");
    }
}
