import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{
    private SharedData obj;
    Lock lk;
    public  Consumer(SharedData obj){
        this.obj = obj;
        this.lk = obj.getLock();
    }
    @Override
    public void run() {
        char c = '0';
        do{
            lk.lock();
            try {
                System.out.println("Consumer => "+obj.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lk.unlock();
        }while (c!='Z');
    }
}
