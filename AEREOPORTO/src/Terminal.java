import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Terminal {
    private int gateNazionali;
    private int gateInternazionali;

    private int gateInternazionaliLiberi;
    private int gateNazionaliLiberi;

    private final ReentrantLock lock;
    private Condition attendiInternazionale;
    private Condition attendiNazionale;

    public Terminal(int gateNazionali, int gateInternazionali) {
        this.gateNazionali = gateNazionali;
        this.gateInternazionali = gateInternazionali;
        this.lock = new ReentrantLock();
        this.attendiInternazionale = lock.newCondition();
        this. attendiNazionale = lock.newCondition();

        this.gateInternazionaliLiberi=gateInternazionali;
        this.gateNazionaliLiberi=gateInternazionali;
    }

    public void occupaGateInternaionale(Volo v) throws InterruptedException{
        lock.lock();

        try {
            while (gateInternazionaliLiberi==0) attendiInternazionale.await();

            gateInternazionaliLiberi--;
            System.out.println("[GATE-INTERNAZIONALE]: "+v.getName()+" occupa un gate "+"(int.liberi): "+gateInternazionaliLiberi+")");
        } finally {
            lock.unlock();
        }


    }

    public void rilasciaGateInternazionale(Volo v){
        lock.lock();
        try {
            gateInternazionaliLiberi++;
            System.out.println("[RILASCIO GATE]: "+v.getName()+" gate liberi: "+ gateInternazionaliLiberi);
            attendiInternazionale.signal();
        } finally {
            lock.unlock();
        }
    }

    public void occupaGateNazionale(Volo v) throws InterruptedException{
        lock.lock();

        try {
            while (gateNazionaliLiberi==0) attendiNazionale.await();

            gateNazionaliLiberi--;
            System.out.println("[GATE-NAZIONALI]: "+v.getName()+" occupa un gate "+"(int.liberi): "+gateNazionaliLiberi+")");
        } finally {
            lock.unlock();
        }
    }

    public void rilasciaGateNazionale(Volo v) {
        lock.lock();
        try {
            gateNazionaliLiberi++;
            System.out.println("[RILASCIO GATE]: "+v.getName()+" gate liberi: "+ gateNazionaliLiberi);
            attendiNazionale.signal();
        } finally {
            lock.unlock();
        }
    }
}
