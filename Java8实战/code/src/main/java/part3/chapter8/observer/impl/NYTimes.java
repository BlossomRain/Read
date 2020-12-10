package part3.chapter8.observer.impl;

import part3.chapter8.observer.Observer;

public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")){
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
