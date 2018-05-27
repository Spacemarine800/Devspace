package TweetFeed.UserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwiiterFollower {

	public TwiiterFollower() {
	}

	Map<String, ArrayList<Tweets>> followeeTweets = new HashMap<String, ArrayList<Tweets>>();

	public Map<String, ArrayList<Tweets>> getFolloweeTweets() {
		return followeeTweets;
	}

	public void setFolloweeTweets(Map<String, ArrayList<Tweets>> followeeTweets) {
		this.followeeTweets = followeeTweets;
	}
	
}
