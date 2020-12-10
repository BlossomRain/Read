package part3.chapter8.observer.impl;

import part3.chapter8.observer.Observer;

public class Guardian implements Observer {
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")){
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}