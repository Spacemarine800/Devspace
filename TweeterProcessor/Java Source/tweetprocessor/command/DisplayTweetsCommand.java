package tweetprocessor.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import tweetprocessor.userdata.TweetComparator;
import tweetprocessor.userdata.Tweets;
import tweetprocessor.userdata.TwitterUser;

public class DisplayTweetsCommand {

	private boolean result = false;
	Map<String, TwitterUser> twitterUsers = new HashMap<String, TwitterUser>();
	
	public boolean execute(){
		
		try{
			SortedSet<String> keys = new TreeSet<String>(twitterUsers.keySet());
			Iterator<String> twtUsers = keys.iterator();
			
			while(twtUsers.hasNext()){
			   TwitterUser tUser = twitterUsers.get(twtUsers.next());
			   
			   ArrayList<Tweets> orderTweets = new ArrayList<Tweets>();
			   orderTweets.addAll(tUser.getTweets());
			   for(Map.Entry<String, ArrayList<Tweets>> followeeTweets : tUser.getFolloweeTweets().entrySet()){
				   orderTweets.addAll(followeeTweets.getValue());
			   }
			   Collections.sort(orderTweets, new TweetComparator());
			   
			   //Display User Tweets
			   System.out.println(tUser.getUserDisplayName());
			   for(Tweets tweet : orderTweets){
				   System.out.println("@"+tweet.getUserName()+": "+tweet.getTweet());
			   }
			}
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public Map<String, TwitterUser> getTwitterUsers() {
		return twitterUsers;
	}

	public void setTwitterUsers(Map<String, TwitterUser> twitterUsers) {
		this.twitterUsers = twitterUsers;
	}
}
