package tweetprocessor.command;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import tweetprocessor.services.PropertiesManager;
import tweetprocessor.userdata.Tweets;
import tweetprocessor.userdata.TwitterUser;
import tweetprocessor.utility.Utilities;

public class LoadTweetsCommand {

	public static final String GREATER_SYMBOL = ">";
	
	private BufferedReader br = null;
	private boolean result = false;
	
	Map<String, TwitterUser> twitterUsers = new HashMap<String, TwitterUser>();

	public boolean execute(){
		try{
			// Open the file
			br = new BufferedReader(new InputStreamReader(new FileInputStream(PropertiesManager.getInstance().tweetSource)));

			String strLine;
			Integer lineCounter = 0; //Keep track of the index of the tweet on the file

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				String [] lineRead =  strLine.split(GREATER_SYMBOL);
				String user = Utilities.removeSpaces(lineRead[0].trim());
				String tweet = lineRead[1]; //Check Tweet length, not more that 140 chars
				if(tweet.length() > 140){
					tweet = "Tweet Unavailable";
				}
				lineCounter++;
				
				if(PropertiesManager.getInstance().debug){
					System.out.println(user + "> " +tweet); //To output the tweets in the console
				}
				
				TwitterUser twtUser = twitterUsers.get(user);
				if(twtUser != null){
					//Add Tweets to User
					twtUser.getTweets().add(new Tweets(user, tweet, lineCounter));
				}else{
					System.err.println(user+" Not Found");
					break;
				}
				
				//Add Tweets to Follower
				Iterator<TwitterUser> userFollowers = twtUser.getFollowers().iterator();
				while(userFollowers.hasNext()){
 					TwitterUser uFollower = userFollowers.next();
					ArrayList<Tweets> tweetsFromUser = new ArrayList<Tweets>();
					tweetsFromUser.add(new Tweets(user, tweet, lineCounter));
					if(uFollower.getFolloweeTweets().containsKey(user)){
						uFollower.getFolloweeTweets().get(user).addAll(tweetsFromUser);
					}else{
						uFollower.getFolloweeTweets().put(user, tweetsFromUser);
					}
				}
			}
			System.out.println();
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
