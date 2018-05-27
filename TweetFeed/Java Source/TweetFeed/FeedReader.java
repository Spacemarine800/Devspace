package TweetFeed;

public class FeedReader {

	public FeedReader() {
	}

	public static void main(String[] args) {
		
		FeedManager feedMngr = new FeedManager();
		if(!feedMngr.execute()){
			System.err.println(FeedManager.class.getName() + " experienced an issue");
		}
	}

}
