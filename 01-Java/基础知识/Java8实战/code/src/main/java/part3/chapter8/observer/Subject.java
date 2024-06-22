package part3.chapter8.observer;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
