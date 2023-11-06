public class Robot19 {
    private String nome = "Pedro Henrique Honorio Saito";
    private String dre = "122149392";
    private int id;
    private GPS gps;
    private int ultimaLinha, ultimaColuna;
    private int centroLinha, centroColuna;
    private int linhaInicial, colunaInicial;
    private boolean ALTERNATE = false;
    private boolean CENTRO = false;
    private Move ultimoMovimento = Move.STOP;
    private Move proximoMovimento = Move.STOP;
    public Estado19 estado = Estado19.STOP;
    private int iterador;
    private Move[] movimentoHorario = {Move.RIGHT, Move.DOWN, Move.LEFT, Move.UP};
    private Move[] movimentoAntiHorario = {Move.RIGHT, Move.UP, Move.LEFT, Move.DOWN};
    private int contagem = 1, referencia = 1;

    public Robot19(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
    }

    public Move MOVE() {
        System.out.println("(" + gps.getC(id) + ", " + gps.getL(id) + ")");  /* Imprime a posição do robô */
        if (!CENTRO) irCentro();
        else {
            switch (estado) {
                case CLOCKWISE -> MudarSentido(movimentoHorario);
                case COUNTER_CW -> MudarSentido(movimentoAntiHorario);
                case SWEEP -> Espiral(movimentoHorario);
                case STOP -> proximoMovimento = Move.STOP;
            }
        }

        ultimaLinha = gps.getL(id);
        ultimaColuna = gps.getC(id);
        ultimoMovimento = proximoMovimento;
        return proximoMovimento;
    }

    public void MudarSentido(Move[] movimento) {
        if (centroLinha == 1) ALTERNATE = false;  /* Quando espaço tem uma única linha, o sentido horário e anti-horário são os mesmos. */
        if (ALTERNATE) alterna();
        if (gps.getL(id) == ultimaLinha && gps.getC(id) == ultimaColuna) {
            ++iterador;
        }
        proximoMovimento = movimento[iterador % 4];
    }

    public void Espiral(Move[] movimento) {
        proximoMovimento = movimento[iterador % 4];
        contagem--;
        if (contagem == 0) {
            iterador++;
            if (iterador % (referencia*2) == 0) referencia++;
            contagem = referencia;
        }

        if (gps.getC(id) == ultimaColuna && gps.getL(id) == ultimaLinha) {
            stop();
        }
    }

    public void irCentro() {
        if (centroLinha == 0) {
            if (ultimaLinha == gps.getL(id)) {
                centroLinha = gps.getL(id) / 2 + 1;
                proximoMovimento = Move.RIGHT;

            } else proximoMovimento = Move.DOWN;
        } else if (centroColuna == 0) {
            if (ultimaColuna == gps.getC(id)) {
                centroColuna = gps.getC(id) / 2 + 1;
                proximoMovimento = Move.LEFT;

            } else proximoMovimento = Move.RIGHT;
        }
        if (centroLinha != 0 && centroColuna != 0) {
            if (ultimoMovimento == Move.LEFT) proximoMovimento = Move.UP;
            else proximoMovimento = Move.LEFT;
        }

        if (gps.getL(id) == centroLinha && gps.getC(id) == centroColuna) {
            CENTRO = true;
            proximoMovimento = Move.RIGHT;
        }
    }

    public void alterna() {
        if (iterador == 0 && gps.getC(id) == ultimaColuna) {
            linhaInicial = gps.getL(id);
            colunaInicial = gps.getC(id);

        } else if (gps.getL(id) == linhaInicial && gps.getC(id) == colunaInicial && (iterador % 4) == 1) {
            if (estado == Estado19.CLOCKWISE) estado = Estado19.COUNTER_CW;
            else estado = Estado19.CLOCKWISE;
            iterador = 0;
        }
    }

    public void clockwise() {
        this.estado = Estado19.CLOCKWISE;
        this.ALTERNATE = false;
        this.iterador = 0;
    }

    public void counter_cw() {
        this.estado = Estado19.COUNTER_CW;
        this.ALTERNATE = false;
        this.iterador = 0;
    }

    public void alternating() {
        this.ALTERNATE = true;
        this.estado = Estado19.CLOCKWISE;
    }

    public void sweep() {
        this.estado = Estado19.SWEEP;
        this.iterador = 1;
    }

    public void stop() {
        this.estado = Estado19.STOP;
    }

    public void print() {
        System.out.println("Nome: "+ nome + "\nDRE: " + dre);
    }
}