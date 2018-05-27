package TweetFeed.UserData;

public class Tweets {

	public Tweets(String username, String twt, Integer tIndex) {
		userName = username;
		tweetIndex = tIndex;
		tweet = twt;
	}

	private String userName = "";
	private Integer tweetIndex = 0;
	private String tweet = "";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getTweetIndex() {
		return tweetIndex;
	}

	public void setTweetIndex(Integer tweetIndex) {
		this.tweetIndex = tweetIndex;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
}
