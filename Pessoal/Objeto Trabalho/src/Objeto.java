import java.util.Collection;


abstract class Objeto {
    public int codigo;
    public Objeto(int codigo) {
        this.codigo = codigo;
    }
    public abstract boolean comparar(Objeto objeto);
    public void imprimir(Collection<Objeto> objetos) {
        for (Objeto objeto : objetos) {
            System.out.println("Código: " + objeto.codigo);
        }
    }
}
