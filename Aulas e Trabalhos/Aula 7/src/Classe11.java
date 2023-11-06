public class Classe11 extends Classe1{
    private int x;
    public void met2() {
        System.out.println("M2 Classe 11");
    }
    public @Override void met1 () {
        x = 1;
        super.met1();
        Classe1.y = 5;
    }
}
