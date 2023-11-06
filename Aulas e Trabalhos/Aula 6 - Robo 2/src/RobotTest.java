public class RobotTest {
    private String nome = "Pedro Henrique Honorio Saito";
    private String dre = "122149392";

    private int id;
    private GPS gps;
    private int ultimaLinha = -1, ultimaColuna = -1;
    private int linhaMaxima = -1, colunaMaxima = -1;
    private int centroLinha = -1, centroColuna = -1;
    private int linhaInicial = -1, colunaInicial = -1;
    private boolean ALTERNATE;
    private Move ultimaMovimentacao = Move.STOP;
    Move proximaMovimentacao = Move.STOP;
    private Rotation19 Movement = Rotation19.STOP;
    // private String sentido = "direita";
    private int sentidoHorario, sentidoAntiHorario;
    private int iterador;

    private String[] sentido = {"direita", "baixo", "esquerda", "cima"};
    private Move[] movimentos = {Move.RIGHT, Move.DOWN, Move.LEFT, Move.UP};

    public RobotTest(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
    }

    public Move MOVE() {
        int atualLinha = gps.getL(id);
        int atualColuna = gps.getC(id);

        switch(Movement) {
            case GO_CENTER -> {
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
                    stop();  // GO_CENTER = false;
                }

                /*
                if (!GO_CENTER) {
                    return Move.STOP;
                }
                * */

            } /* VAI SER MODIFICADO */
            case CLOCKWISE -> {
                switch (sentido) {
                    case "direita" -> {

                        if (ultimaColuna == atualColuna) {
                            if (ALTERNATE) {
                                linhaInicial = atualLinha;
                                colunaInicial = atualColuna;
                            }
                            sentido = "baixo";
                            proximaMovimentacao = Move.DOWN;
                        } else proximaMovimentacao = Move.RIGHT;
                    }
                    case "baixo" -> {
                        /*
                        * if (ALTERNATE && (atualLinha == Math.ceil(linhaMaxima/2))) {
                            Movement = Rotation19.COUNTER_CW;
                            System.out.println("Completei uma volta no sentio horário.");
                        }
                        * */

                        if (ultimaLinha == atualLinha) {
                            linhaMaxima = atualLinha;
                            sentido = "esquerda";
                            proximaMovimentacao = Move.LEFT;
                        } else proximaMovimentacao = Move.DOWN;
                    }
                    case "esquerda" -> {

                        if (ultimaColuna == atualColuna) {
                            sentido = "cima";
                            proximaMovimentacao = Move.UP;
                        } else proximaMovimentacao = Move.LEFT;
                    }
                    case "cima" -> {

                        if (ultimaLinha == atualLinha) {
                            if (ALTERNATE && linhaInicial == atualLinha && colunaInicial == atualColuna) {
                                Movement = Rotation19.COUNTER_CW;
                            }
                            sentido = "direita";
                            proximaMovimentacao = Move.RIGHT;
                        } else proximaMovimentacao = Move.UP;
                    }
                }
            }
            /* VAI SER MODIFICADO */
            case COUNTER_CW -> {
                switch (sentido) {
                    case "direita" -> {

                        if (ultimaColuna == atualColuna) {
                            if (ALTERNATE) {
                                linhaInicial = atualLinha;
                                colunaInicial = atualColuna;
                            }
                            sentido = "cima";
                            proximaMovimentacao = Move.UP;
                        } else proximaMovimentacao = Move.RIGHT;
                    }
                    case "cima" -> {
                        /*
                        * if (ALTERNATE && (atualLinha == Math.ceil(linhaMaxima/2))) {
                            Movement = Rotation19.CLOCKWISE;
                            System.out.println("Completei uma volta no sentido anti-horário.");
                        }
                        * */
                        if (ultimaLinha == atualLinha) {
                            if (ALTERNATE && linhaInicial == atualLinha && colunaInicial == atualColuna) {
                                Movement = Rotation19.CLOCKWISE;
                            }
                            sentido = "esquerda";
                            proximaMovimentacao = Move.LEFT;
                        } else proximaMovimentacao = Move.UP;
                    }
                    case "esquerda" -> {

                        if (ultimaColuna == atualColuna) {
                            sentido = "baixo";
                            proximaMovimentacao = Move.DOWN;
                        } else proximaMovimentacao = Move.LEFT;
                    }
                    case "baixo" -> {

                        if (ultimaLinha == atualLinha) {
                            linhaMaxima = atualLinha;
                            sentido = "direita";
                            proximaMovimentacao = Move.RIGHT;
                        } else proximaMovimentacao = Move.DOWN;
                    }
                }
            }
            /* VAI SER MODIFICADO */
            case ALTERNATING -> {
                Movement = Rotation19.CLOCKWISE;
            }
            case STOP -> {
                proximaMovimentacao = Move.STOP;
            }

        }

        ultimaLinha = atualLinha;
        ultimaColuna = atualColuna;
        ultimaMovimentacao = proximaMovimentacao;
        return proximaMovimentacao;
    }

    public void MudarSentido() {
        if (gps.getL(id) == ultimaLinha && gps.getC(id) == ultimaColuna) {
            if (Movement == Rotation19.CLOCKWISE) {
                sentidoHorario = ++sentidoHorario % 3;
                proximaMovimentacao = movimentos[sentidoHorario];
            } else {
                sentidoAntiHorario = 3 - (sentidoHorario % 3);
                proximaMovimentacao = movimentos[sentidoAntiHorario];
            }
        }
    }

    public void clockwise() {
        this.Movement = Rotation19.CLOCKWISE;
        this.ALTERNATE = false;
    }

    public void counter_cw() {
        this.Movement = Rotation19.COUNTER_CW;
        this.ALTERNATE = false;

    }

    public void alternating() {
        this.Movement = Rotation19.ALTERNATING;
        this.ALTERNATE = true;
    }

    public void go_center() {
        this.Movement = Rotation19.GO_CENTER;
    }

    public void stop() {
        this.Movement = Rotation19.STOP;
    }

    public void print() {
        System.out.println("Nome: "+ nome + "\nDRE: " + dre);
    }
}
