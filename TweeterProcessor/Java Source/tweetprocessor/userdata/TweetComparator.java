package tweetprocessor.userdata;

import java.util.Comparator;

public class TweetComparator implements Comparator<Tweets> {

	@Override
	public int compare(Tweets arg0, Tweets arg1) {
		return arg0.getTweetIndex().compareTo(arg1.getTweetIndex());
	}

}
