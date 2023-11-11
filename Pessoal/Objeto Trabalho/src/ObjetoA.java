import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjetoA extends Objeto {
    public ObjetoA(int codigo) {
        super(codigo);
    }

    @Override
    public boolean comparar(Objeto objeto) {
        return Math.abs(this.codigo - objeto.codigo) < 3;
    }
    @Override
    public boolean equals(Object objetoA) {

    }
}
