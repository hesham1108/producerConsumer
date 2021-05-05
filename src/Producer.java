import java.util.concurrent.locks.Lock;

public class Producer implements  Runnable{

    SharedData obj;
    Lock lk;
    public Producer(SharedData obj){
        this.obj = obj;
        this.lk = obj.getLock();
    }
    @Override
    public void run() {

    for (char c = 'A' ; c<'Z'; c++){
            lk.lock();
        try {
            obj.setData(c);
            System.out.println("Producer => "+ c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lk.unlock();
    }
    }
}
