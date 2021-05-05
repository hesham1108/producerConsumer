import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData {


    private char c;
    private boolean available;
    Lock lock;
    Condition condition;
    public SharedData()
    {
        available = false;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    void setData(char c) throws InterruptedException {
        while(available){
            condition.await();
        }
        available = true;
        this.c = c;
        condition.signal();
    }

    char getData() throws InterruptedException {
        while (!available){
            condition.await();
        }
        available = false;
        condition.signal();
        return c;
    }

    Lock getLock(){
        return lock;
    }

}
