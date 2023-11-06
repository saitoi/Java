public class Main {
    public static void main(String[] args) {
        Animal[] va = new Animal[7];
        Humano h1 = new Humano(1);
        va[0] = h1;
        for (int i = 0; i < 2; ++i) {
            Cachorro c1 = new Cachorro(i + 1);
            va[i+1] = c1;
        }
        for (int i = 0; i < 4; ++i) {
            Galo g1 = new Galo(i + 1);
            va[i+3] = g1;
        }
        for (int i = 0; i < 7; ++i) {
            va[i].comer();
        }
        /*
        Galo vg[] = new Galo[4];
        Galo g1 = new Galo(1);
        Galo g2 = new Galo(2);
        Galo g3 = new Galo(3);
        Galo g4 = new Galo(4);
        */
        for (int i = 0; i < 7; ++i) {
            if (va[i] instanceof Humano) {
                Humano h2 = (Humano) va[i];
                h2.profissao();
            }
        }
    }
}