public class ObjetoA extends Objeto {
    public ObjetoA(int codigo) {
        super(codigo);
    }

    @Override
    public boolean comparar(Objeto objeto) {
        return Math.abs(this.codigo - objeto.codigo) < 3;
    }
    @Override
    public ObjetoA criarObjeto() {
        System.out.println("Código para objeto A novo: ");
        return new ObjetoA(Global.scanner.nextInt());
    }
}
