package tweetprocessor.exception;

public class ExceptionCodes {

	/*
	 * These error codes can be mapped to a database with a friendly error message and loaded on application startup
	 */
	
	public static final int BASE = 9000;
	public static final int USER_LOAD_ERROR = BASE + 1;
	public static final int TWEET_LOAD_ERROR = BASE + 2;
	public static final int TWEETS_DISPLAY_ERROR = BASE + 3;
	
}
