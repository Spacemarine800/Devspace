package TweetFeed.UserData;

import java.util.ArrayList;

public class TwitterUser extends TwiiterFollower {

	public TwitterUser() {
		super();
	}

	String userDisplayName = "";
	
	ArrayList<TwitterUser> followers = new ArrayList<TwitterUser>();
	
	ArrayList<Tweets> tweets = new ArrayList<Tweets>();

	public String getUserDisplayName() {
		return userDisplayName.trim();
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName.trim();
	}

	public ArrayList<TwitterUser> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<TwitterUser> followers) {
		this.followers = followers;
	}

	public ArrayList<Tweets> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<Tweets> tweets) {
		this.tweets = tweets;
	}
	
}
