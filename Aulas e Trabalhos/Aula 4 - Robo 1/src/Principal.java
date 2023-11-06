public class Principal {
    public static void main (String[] args) {
        GPS g1 = new GPS();
        RobotXYZ r1 = new RobotXYZ(1, g1);

        while( true ) {
            Move m1 = r1.MOVE();
            if( m1 == Move.STOP )
                break;
            g1.move( m1 );
        }
        r1.print();
        System.out.print("\nFim\n");
    }

}