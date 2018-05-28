package tweetprocessor.tests;

import java.util.Iterator;

import tweetprocessor.exception.ServiceException;
import tweetprocessor.services.TweetService;
import tweetprocessor.userdata.TwitterUser;


public class LoadUserServiceTest {

	public static void main(String[] args) {
		TweetService service = new TweetService();
		try {
			service.loadUsers();
			Iterator<String> usersItr = service.getTwitterUsers().keySet().iterator();
			
			while(usersItr.hasNext()){
				TwitterUser user = service.getTwitterUsers().get(usersItr.next());
				System.out.println("User: "+user.getUserDisplayName());
				for(TwitterUser follower : user.getFollowers()){
					System.out.println("Follower: "+follower.getUserDisplayName());
				}	
				System.out.println();
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
