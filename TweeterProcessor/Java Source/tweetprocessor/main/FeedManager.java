package tweetprocessor.main;

import tweetprocessor.exception.ServiceException;
import tweetprocessor.services.TweetService;

public class FeedManager {

	public FeedManager() {
	}

	private boolean result = true;
	
	public boolean execute(){
		
		TweetService twtService = new TweetService();
		
		try {
			twtService.loadUsers();
			twtService.loadTweets();
			twtService.displayUserTweets();
		} catch (ServiceException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
}
