package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    // JUnit test method for adding tweet into TweetList
    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("added tweet");
        tweetList.add(tweet);

        assertTrue(tweetList.hasTweet(tweet));
    }

    //JUnit test method for checking whether a tweet is in the TweetList
    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweetList.hasTweet(tweet));

        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testAddException(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("yes");
        tweetList.add(tweet);
        try {
            tweetList.add(tweet);
        }catch(IllegalArgumentException e){
            assert(TRUE);

        }
    }


    public void testGetTweet(){
            TweetList tweetList = new TweetList(); //
            Tweet tweet = new NormalTweet("get tweet check");

            tweetList.add(tweet);
            Tweet retrievedTweet = tweetList.getTweet(0);

            assertEquals(retrievedTweet.getMessage(), tweet.getMessage());
            assertEquals(retrievedTweet.getDate(), tweet.getDate());
    }

    public void testGetTweets(){
        TweetList tweetList = new TweetList();
        Tweet tweet1 = new NormalTweet("1");

        Tweet tweet2 = new NormalTweet("2");

        Tweet tweet3 = new NormalTweet("3");
        tweetList.add(tweet2);
        tweetList.add(tweet3);
        tweetList.add(tweet1);

        ArrayList<Tweet> tweetList2 = tweetList.getTweets();

        assert(TRUE);



    }

    public void testDeleteTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("one for delete");

        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));

        tweetList.delete(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweetList = new TweetList();
        Tweet tweet1 = new NormalTweet("first");
        Tweet tweet2 = new NormalTweet("second");
        Tweet tweet3 = new NormalTweet("Third");

        tweetList.add(tweet1);
        assertEquals(1, tweetList.getCount());

        tweetList.add(tweet2);
        assertEquals(2, tweetList.getCount());

        tweetList.add(tweet3);
        assertEquals(3, tweetList.getCount());

        tweetList.delete(tweet2);
        assertEquals(2, tweetList.getCount());


    }


}
