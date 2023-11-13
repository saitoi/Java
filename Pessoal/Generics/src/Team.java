public class GenericClass<T> {
    private T valor;
    public GenericClass(T valor) {
        this.valor = valor;
    }
    public void oqueEIsso() {
        System.out.println("Isso é um " + this.valor);
    }
}
