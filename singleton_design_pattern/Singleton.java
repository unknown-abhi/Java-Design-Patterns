package singleton_design_pattern;

public class Singleton {
    private static Singleton instance;

    // constructor should be private
    private Singleton() {
    }

    public static Singleton getInstance() {
        // Double Checked Locking
        synchronized (Singleton.class) {
            if (instance == null) {
                try {
                    instance = new Singleton();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }
}
