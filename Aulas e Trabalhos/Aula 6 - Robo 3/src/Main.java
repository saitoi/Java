import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        GPS g1 = new GPS();
        Robot19 r1 = new Robot19( 1, g1);
        List<SenhaSingleton> listaSenhas = new ArrayList<>();
        List<Robot19> listaRobos = new ArrayList<>();

        while( true ) {
            Move m1 = r1.MOVE();
            if( m1 == Move.STOP )
                break;
            g1.move( m1 );
        }
        r1.print();
        System.out.print("\nFim\n");
    }
    public static void chamarSenha(SenhaSingleton senha) {
        senha.setUsada();
        
    }
}