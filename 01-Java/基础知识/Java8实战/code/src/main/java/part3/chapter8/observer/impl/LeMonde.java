package part3.chapter8.observer.impl;

import part3.chapter8.observer.Observer;

public class LeMonde implements Observer {
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("wine")){
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}