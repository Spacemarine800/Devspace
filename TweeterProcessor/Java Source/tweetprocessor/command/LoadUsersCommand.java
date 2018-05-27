package tweetprocessor.command;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import tweetprocessor.services.PropertiesManager;
import tweetprocessor.userdata.TwitterUser;
import tweetprocessor.utility.Utilities;

public class LoadUsersCommand {

	public LoadUsersCommand() {
	}
	
	private boolean result = false;
	private BufferedReader br = null;
	public static final String FOLLOWS = "follows";
	
	private Map<String, TwitterUser> twitterUsers = new HashMap<String, TwitterUser>();
	private ArrayList<String> usersOnReadLine = null;

	public boolean execute(){
		try{
			// Open the file
			br = new BufferedReader(new InputStreamReader(new FileInputStream(PropertiesManager.getInstance().userSource)));
	
			String strLine;
	
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			   if(PropertiesManager.getInstance().debug){	
				   System.out.println(strLine); //Output to console, to check the content read in line by line	
			   }	
			   
			   String [] lineRead =  strLine.split(FOLLOWS); 
			   
			   //Data Input Validation, there should only be two items, Follower and Followee's
			   if(lineRead.length > 2){
				   System.err.println("Error encounterred reading source of data");
				   return false;
			   }

			   //User read, the Followee
			   String user =  Utilities.removeSpaces(lineRead[lineRead.length - 1].trim());
			   
			   StringTokenizer st = new StringTokenizer(user, ",");
			   usersOnReadLine = new ArrayList<String>();
			   if(st.countTokens() > 1){
				   //Multiple Users being followed
				   while(st.hasMoreTokens()){
					   storeUser(st);
				   }
			   }else{
				   //Single User being followed
				   storeUser(st);   
			   }
			   
			   //Follower read, Remember, Follower is a Twitter User and needs to be stored as well
			   String userFollower = Utilities.removeSpaces(lineRead[lineRead.length - 2].trim());
			   TwitterUser fwUser = new TwitterUser();
			   fwUser.setUserDisplayName(userFollower);
			   
			   if(twitterUsers != null && !twitterUsers.containsKey(userFollower)){
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

	public void storeUser(StringTokenizer token){
		String userName = "";
		userName = token.nextToken();
		usersOnReadLine.add(userName);
		TwitterUser twUser = new TwitterUser();
		twUser.setUserDisplayName(userName);
		if(!twitterUsers.containsKey(userName)){
			twitterUsers.put(userName, twUser);
		} 
	}
	
	public Map<String, TwitterUser> getTwitterUsers() {
		return twitterUsers;
	}

	public void setTwitterUsers(Map<String, TwitterUser> twitterUsers) {
		this.twitterUsers = twitterUsers;
	}
}
