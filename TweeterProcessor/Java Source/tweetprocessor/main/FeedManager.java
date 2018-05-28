package tweetprocessor.main;

import tweetprocessor.exception.ServiceException;
import tweetprocessor.services.TweetService;

public class FeedManager {

	public FeedManager() {
	}

	public boolean execute(){
		
		TweetService twtService = new TweetService();
		
		try {
			twtService.loadUsers();
			twtService.loadTweets();
			twtService.displayUserTweets();
		} catch (ServiceException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
}
