package observer_design_pattern;

/**
 * Subject interface for managing observers and broadcasting updates.
 */
public interface Subject {

    public void subscribe(Observer o);

    public void unSubscribe(Observer o);

    public void notifyChanges(String title);
}
