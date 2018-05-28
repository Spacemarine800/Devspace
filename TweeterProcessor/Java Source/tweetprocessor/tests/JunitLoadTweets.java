package tweetprocessor.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tweetprocessor.command.LoadTweetsCommand;
import tweetprocessor.exception.ServiceException;
import tweetprocessor.services.TweetService;

public class JunitLoadTweets {

	@Test
	public void test() {
		TweetService service = new TweetService();
		try {
			service.loadUsers();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		LoadTweetsCommand cmd = new LoadTweetsCommand();
		cmd.setTwitterUsers(service.getTwitterUsers());
		assertTrue(cmd.execute());
	}

}
