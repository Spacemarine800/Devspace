package TweetFeed;

import TweetFeed.Services.TweetService;

public class FeedManager {

	public FeedManager() {
	}

	private boolean result = true;
	
	public boolean execute(){
		
		TweetService twtService = new TweetService();
		
		twtService.loadUsers();
		
		twtService.loadTweets();
		
		twtService.displayUserTweets();

		return result;
	}
	
}
