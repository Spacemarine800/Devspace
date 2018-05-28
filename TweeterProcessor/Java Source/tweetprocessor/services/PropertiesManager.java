package tweetprocessor.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

	private static PropertiesManager instance = null;
	public String userSource = null;
    public String tweetSource = null;
    public String format = null;
    public String sourceVersion = null;
    public boolean debug = false;
	
	public static PropertiesManager getInstance(){
        if (instance == null) {
        	instance = new PropertiesManager();
        }
        return instance;
    }
	
	protected PropertiesManager(){
		try{
			InputStream file = new FileInputStream(new File("../TweeterProcessor/properties/tweeter.properties")) ;
			Properties props = new Properties();
			props.load(file);
			userSource = props.getProperty("USER_SOURCE")+props.getProperty("SOURCE_VERSION")+props.getProperty("FORMAT");
			tweetSource = props.getProperty("TWEET_SOURCE")+props.getProperty("SOURCE_VERSION")+props.getProperty("FORMAT");
			format = props.getProperty("FORMAT");
			debug = props.getProperty("DEBUG").equalsIgnoreCase("true") ? true : false;
			sourceVersion = props.getProperty("SOURCE_VERSION");
		} 
		catch(Exception e){
			System.err.println("Loading defaults properties");
			userSource = "../TweeterProcessor/Java Source/tweetprocessor/datainput/user.txt";
			tweetSource = "../TweeterProcessor/Java Source/tweetprocessor/datainput/tweet.txt";
			format = ".txt";
			debug = false;
			sourceVersion = ""; 
		}	 
	 }
	
}
