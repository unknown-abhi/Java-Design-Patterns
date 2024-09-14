package Inter_Thread_Communication;

public class InterThreadCommunication {
    public static void main(String[] args) {
        SumDemo th = new SumDemo();
        th.start();

        synchronized (th) {
            try {
                th.wait();
                // th.join();
                System.out.println("Sum : " + th.getSum());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
