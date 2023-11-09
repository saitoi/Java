public class ObjetoB extends Objeto{
    public ObjetoB(int codigo) {
        super(codigo);
    }
    @Override
    public boolean comparar(Objeto objeto) {
        return (Math.abs(this.codigo-objeto.codigo) < 10);
    }
    @Override
    public ObjetoB criarObjeto() {
        System.out.println("Código para objeto B novo: ");
        return new ObjetoB(Global.scanner.nextInt());
    }
}
