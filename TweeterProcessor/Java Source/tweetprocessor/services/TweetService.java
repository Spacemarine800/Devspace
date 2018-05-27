package tweetprocessor.services;

import java.util.HashMap;
import java.util.Map;

import tweetprocessor.command.DisplayTweetsCommand;
import tweetprocessor.command.LoadTweetsCommand;
import tweetprocessor.command.LoadUsersCommand;
import tweetprocessor.exception.ExceptionCodes;
import tweetprocessor.exception.ServiceException;
import tweetprocessor.userdata.TwitterUser;

public class TweetService {

	public TweetService() {
	}
	
	Map<String, TwitterUser> twitterUsers = new HashMap<String, TwitterUser>();
	
	public void loadUsers() throws ServiceException{
		LoadUsersCommand usersCmd = new LoadUsersCommand();
		if(!usersCmd.execute()){
			throw new ServiceException(ExceptionCodes.USER_LOAD_ERROR, "Load of Twitter Users encounttered an error.");
		}
		twitterUsers = usersCmd.getTwitterUsers();
	}
	
	public void loadTweets() throws ServiceException{
		LoadTweetsCommand tweetsCmd = new LoadTweetsCommand();
		tweetsCmd.setTwitterUsers(twitterUsers);
		if(!tweetsCmd.execute()){
			throw new ServiceException(ExceptionCodes.TWEET_LOAD_ERROR, "Load of Twitter Tweets encounttered an error.");
		}
		twitterUsers = tweetsCmd.getTwitterUsers();
	}
	
	public void displayUserTweets() throws ServiceException{
		DisplayTweetsCommand displayCmd = new DisplayTweetsCommand();
		displayCmd.setTwitterUsers(twitterUsers);
		if(!displayCmd.execute()){
			throw new ServiceException(ExceptionCodes.TWEETS_DISPLAY_ERROR, "Display Twitter Tweets encounttered an error.");
		}
	}

	public Map<String, TwitterUser> getTwitterUsers() {
		return twitterUsers;
	}

	public void setTwitterUsers(Map<String, TwitterUser> twitterUsers) {
		this.twitterUsers = twitterUsers;
	}
	
}
