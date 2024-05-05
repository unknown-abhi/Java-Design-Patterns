package observer_design_pattern;

import java.util.Objects;

public class Subscriber implements Observer {

    private String userName;

    public Subscriber(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Subscriber [userName= " + userName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Subscriber subscriber = (Subscriber) o;
        return Objects.equals(userName.toLowerCase(), subscriber.userName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public void notified(String title) {
        System.out.println(userName + " : One New Notification : " + title);
    }
}