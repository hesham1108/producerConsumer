public class Main {
    public static void main(String[] args){
        SharedData s =new SharedData();
        Producer p = new Producer(s);
        Consumer c = new Consumer(s);

        Thread pr = new Thread(p);
        Thread co = new Thread(c);

        pr.start();
        co.start();
    }
}
