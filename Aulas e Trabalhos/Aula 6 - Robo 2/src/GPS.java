public class GPS {
    private int lr = 1;
    private int cr = 1;
    private int l = 5;
    private int c = 5;
    public int getL ( int id ) {
        return lr;
    }
    public int getC ( int id ) {
        return cr;
    }
    public void move ( Move m1 ) {
        if( m1 == Move.UP && lr > 1)
            lr--;
        if( m1 == Move.LEFT && cr > 1)
            cr--;
        if( m1 == Move.DOWN && lr < l)
            lr++;
        if( m1 == Move.RIGHT && cr < c)
            cr++;
    }
}