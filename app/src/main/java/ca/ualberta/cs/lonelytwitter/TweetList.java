package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) throws IllegalArgumentException{
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }else {
            tweets.add(tweet);
        }

    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets(){
        Collections.sort(tweets);
        return tweets;
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount(){
        return tweets.size();
    }
}
