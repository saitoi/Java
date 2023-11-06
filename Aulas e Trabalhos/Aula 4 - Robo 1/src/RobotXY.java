public class RobotXY {
    private String nome = "Pedro Henrique Honorio Saito";
    private String dre = "122149392";

    private int id;
    private GPS gps;
    private int ultimaLinha = -1, ultimaColuna = -1;
    private int linhaMaxima = -1, colunaMaxima = -1;
    private int centroLinha = -1, centroColuna = -1;
    private boolean GO_CENTER = true;
    private Move ultimaMovimentacao = Move.STOP;

    public RobotXY(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
    }

    public Move MOVE() {
        int atualLinha = gps.getL(id);
        int atualColuna = gps.getC(id);
        Move proximaMovimentacao = Move.STOP;

        if (centroLinha == -1) {
            if (ultimaLinha == atualLinha && ultimaColuna == atualColuna) {
                linhaMaxima = atualLinha;
                centroLinha = linhaMaxima / 2 + 1;
                proximaMovimentacao = Move.LEFT;
            } else {
                proximaMovimentacao = Move.DOWN;
            }
        } else if (centroColuna == -1) {
            if (ultimaLinha == atualLinha && ultimaColuna == atualColuna) {
                colunaMaxima = atualColuna;
                centroColuna = colunaMaxima / 2 + 1;
                proximaMovimentacao = Move.LEFT;
            } else {
                proximaMovimentacao = Move.RIGHT;
            }
        } else {
            if (ultimaMovimentacao == Move.LEFT) {
                proximaMovimentacao = Move.UP;
            } else if (ultimaMovimentacao == Move.UP) {
                proximaMovimentacao = Move.LEFT;
            }
        }

        if (atualLinha == centroLinha && atualColuna == centroColuna) {
            GO_CENTER = false;
        }

        if (!GO_CENTER) {
            return Move.STOP;
        }

        ultimaLinha = atualLinha;
        ultimaColuna = atualColuna;
        ultimaMovimentacao = proximaMovimentacao;
        return proximaMovimentacao;
    }

    public void print() {
        System.out.println("Nome: "+ nome + "\nDRE: " + dre);
        System.out.println(centroColuna + ", " + centroLinha);
        System.out.println(colunaMaxima + ", " + linhaMaxima);
    }
}
