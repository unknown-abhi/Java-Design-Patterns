package Inter_Thread_Communication;

public class SumDemo extends Thread {
    private int sum = 0;

    public void run() {

        synchronized (this) {
            this.sum = 0;
            for (int i = 0; i <= 10; i++) {
                this.sum += i;
            }
            this.notify();
        }
    }

    public int getSum() {
        return this.sum;
    }
}
