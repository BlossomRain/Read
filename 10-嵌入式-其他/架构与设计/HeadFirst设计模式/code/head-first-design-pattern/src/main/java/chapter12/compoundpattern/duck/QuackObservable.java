package chapter12.compoundpattern.duck;


public interface QuackObservable {
    void registerObserver(Observer ob);
    void notifyObservers();
}
