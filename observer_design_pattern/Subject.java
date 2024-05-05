package observer_design_pattern;

public interface Subject {

    public void subscribe(Observer o);

    public void unSubscribe(Observer o);

    public void notifyChanges(String title);
}
