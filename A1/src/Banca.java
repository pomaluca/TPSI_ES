import java.util.Random;
public class Banca{

    private int cassieri=2;
    private Random random = new Random();
    private long prima;
    private long dopo;


    public synchronized Boolean Servire() throws InterruptedException {
        while(cassieri==0) {
            System.out.println(Thread.currentThread().getName()+" sta aspettando di essere servito");
            prima = System.currentTimeMillis();
            wait(5001);
            dopo = System.currentTimeMillis();
            if(dopo - prima >= 5000){
                return false;
            }
        }
        cassieri--;
        System.out.println("il cliente "+Thread.currentThread().getName()+" sta venendo servito");
        return true;
    }

    public synchronized void Liberare(){
        cassieri++;
        System.out.println("il cliente "+Thread.currentThread().getName()+" è stato servito");
        notifyAll();
    }
}
