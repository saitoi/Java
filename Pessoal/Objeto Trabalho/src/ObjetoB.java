import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjetoB extends Objeto{
    public ObjetoB(int codigo) {
        super(codigo);
    }
    @Override
    public boolean comparar(Objeto objeto) {
        return (Math.abs(this.codigo-objeto.codigo) < 10);
    }
}
