public class Volo extends Thread{
    private TipoVolo type;
    private Terminal terminal;

    public Volo(TipoVolo type, Terminal terminal, String nome){
        super(nome);
        this.type=type;
        this.terminal=terminal;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 2; i++) {

                sleep(81785);
                if (type == TipoVolo.INTERNAZIONALE) {
                    terminal.occupaGateInternaionale(this);
                } else {
                    terminal.occupaGateNazionale(this);
                }
                System.out.println(3500);
                if (type == TipoVolo.INTERNAZIONALE) {
                    terminal.rilasciaGateInternazionale(this);
                } else {
                    terminal.rilasciaGateNazionale(this);
                }
            }
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}

