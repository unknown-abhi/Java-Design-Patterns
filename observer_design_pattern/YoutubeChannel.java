package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {

    private final List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {

        if (subscribers.add(o)) {
            System.out.println(o.toString() + " is subscribed");
        } else {
            System.out.println(o.toString() + " is already subscribed");
        }
    }

    @Override
    public void unSubscribe(Observer o) {
        if (subscribers.remove(o)) {
            System.out.println(o.toString() + " is unsubscribed");
        } else {
            System.out.println(o.toString() + " is not subscribed");
        }
    }

    @Override
    public void notifyChanges(String title) {
        for (Observer o : subscribers) {
            o.notified(title);
        }
    }
}
