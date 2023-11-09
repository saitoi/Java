public class SenhaSingleton {
    private static SenhaSingleton uniqueInstance;
    private boolean usada;
    private int senhaAtual;

    private SenhaSingleton() {
        this.senhaAtual = Global.contador;
        this.usada = true;
    }

    public static synchronized SenhaSingleton getInstance() {
        if (uniqueInstance == null) {
            Global.contador++;
            return new SenhaSingleton();
        }
        return uniqueInstance;
    }
    public void setUsada() {
        this.usada = true;
    }
}
