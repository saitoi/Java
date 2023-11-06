public class RobotXYZ {
    private String nome = "Pedro Henrique Honorio Saito";
    private String dre = "122149392";

    private int id;
    private GPS gps;
    private int ultimaLinha, ultimaColuna;
    private int linhaMaxima, colunaMaxima;
    private int centroLinha, centroColuna;
    private boolean GO_CENTER = true;
    private Move ultimaMovimentacao = Move.STOP;

    public RobotXYZ(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
    }

    public Move MOVE() {
        Move proximoMovimento = Move.STOP;

        if (centroLinha == 0) {
            if (ultimaLinha == gps.getL(id)) {
                centroLinha = gps.getL(id)/2 + 1;
                proximoMovimento = Move.RIGHT;

            } else proximoMovimento = Move.DOWN;
        } else if (centroColuna == 0) {
            if (ultimaColuna == gps.getC(id)) {
                centroColuna = gps.getC(id)/2 + 1;
                proximoMovimento = Move.LEFT;
            } else proximoMovimento = Move.RIGHT;
        }

        if (centroLinha != 0 && centroColuna != 0) {
            if (ultimaMovimentacao == Move.LEFT) {
                proximoMovimento = Move.UP;
            } else {
                proximoMovimento = Move.LEFT;
            }
        }

        if (gps.getL(id) == centroLinha && gps.getC(id) == centroColuna) {
            GO_CENTER = false;
        }

        if (!GO_CENTER) {
            return Move.STOP;
        }

        ultimaLinha = gps.getL(id);
        ultimaColuna = gps.getC(id);
        ultimaMovimentacao = proximoMovimento;
        return proximoMovimento;
    }

    public void print() {
        System.out.println("Nome: "+ nome + "\nDRE: " + dre);
        System.out.println(centroColuna + ", " + centroLinha);
    }
}
