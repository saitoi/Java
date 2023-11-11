public class Robot19 {
    private String nome = "Pedro Henrique Honorio Saito";
    private String dre = "122149392";
    private int id;
    private GPS gps;
    private Move proximoMovimento = Move.STOP;
    public Estado19 estado = Estado19.STOP;
    private SenhaSingleton senha;

    public Robot19(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
    }

    public Move MOVE() {
        mudarEstado();
        return switch (estado) {
            case SEM_SENHA, CONVOCADO -> Move.DOWN;
            case ESPERA -> (gps.getL(id) == gps.getl()) ? Move.UP : Move.RIGHT;
            case STOP -> Move.STOP;
        };
    }
    public void mudarEstado() {
        switch(estado) {
            case SEM_SENHA -> {
                if (gps.getL(id) == gps.getl()) {
                    this.espera();
                }
            }
            case ESPERA -> {
                if (gps.getC(id) == gps.getc()) {
                    this.stop();
                }
                if (this.senha.usada) {
                    this.convocado();
                }
            }
            case CONVOCADO -> {
                if (gps.getL(id) == gps.getc()) {
                    exit();
                }
            }
        }
    }

    public void semSenha() {
        this.estado = Estado19.SEM_SENHA;
    }
    public void espera() {
        /* Recebe senha nova */
        this.senha = SenhaSingleton.getInstance();
        this.estado = Estado19.ESPERA;
    }
    public void convocado() {
        /* Senha foi usada */
        this.estado = Estado19.CONVOCADO;
    }

    public void stop() {
        this.estado = Estado19.STOP;
    }

    public void print() {
        System.out.println("Nome: "+ nome + "\nDRE: " + dre);
    }
}