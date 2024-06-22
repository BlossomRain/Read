package part3.chapter8.observer;

import org.junit.Test;
import part3.chapter8.observer.impl.Feed;
import part3.chapter8.observer.impl.Guardian;
import part3.chapter8.observer.impl.LeMonde;
import part3.chapter8.observer.impl.NYTimes;

public class ObserverTest {

    @Test
    public void testLambda() {
        Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet);
            }
        });
    }

    @Test
    public void testTradition() {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
