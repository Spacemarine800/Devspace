package TweetFeed.Command;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import TweetFeed.UserData.TwitterUser;
import TweetFeed.Utility.Utilities;

public class LoadUsersCommand {

	public LoadUsersCommand() {
	}
	
	private boolean result = false;
	private BufferedReader br = null;
	public static final String FOLLOWS = "follows";
	
	Map<String, TwitterUser> twitterUsers = new HashMap<String, TwitterUser>();

	public boolean execute(){
		try{
			// Open the file
			br = new BufferedReader(new InputStreamReader(new FileInputStream("../TweetFeed/Java Source/TweetFeed/DataInput/user.txt")));
	
			String strLine;
	
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				System.out.println(strLine);	
				
			   ArrayList<String> usersOnReadLine = new ArrayList<String>();
			   
			   String [] lineRead =  strLine.split(FOLLOWS); 

			   //User read
			   String user =  Utilities.removeSpaces(lineRead[lineRead.length - 1].trim());
			   
			   StringTokenizer st = new StringTokenizer(user, ",");
			   String userName = "";
			   if(st.countTokens() > 1){
				   //Multiple Users being followed
				   while(st.hasMoreTokens()){
					   userName = st.nextToken();
					   usersOnReadLine.add(userName);
					   TwitterUser twUser = new TwitterUser();
					   twUser.setUserDisplayName(userName);
					   if(!twitterUsers.containsKey(userName)){
						   twitterUsers.put(userName, twUser);
					   }	   
				   }
			   }else{
				   //Single User being followed
				   userName = st.nextToken();
				   usersOnReadLine.add(userName);
				   TwitterUser twUser = new TwitterUser();
				   twUser.setUserDisplayName(userName);
				   if(!twitterUsers.containsKey(userName)){
					   twitterUsers.put(userName, twUser);
				   } 	   
			   }
			   
			   
			   //Follower read, Remember, Follower is a Twitter User and needs to be stored as well
			   String userFollower = Utilities.removeSpaces(lineRead[lineRead.length - 2].trim());
			   TwitterUser fwUser = new TwitterUser();
			   fwUser.setUserDisplayName(userFollower);
			   
			   if(!twitterUsers.containsKey(userFollower)){
				   twitterUsers.put(userFollower, fwUser);
			   } 	   
			   
			   //Store Follower on User being followed
			   Iterator usersItr = usersOnReadLine.iterator();
			   while(usersItr.hasNext()){
				   String name = (String) usersItr.next();
				   TwitterUser twUser =  twitterUsers.get(name);
				   
				   //Check if Follower exists in Users and add that Object
				   if(twitterUsers.containsKey(userFollower)){
					   if(!twUser.getFollowers().contains(twitterUsers.get(userFollower))){
						   twUser.getFollowers().add(twitterUsers.get(userFollower));
					   }
				   }
				   
				   twitterUsers.put(name, twUser);
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
