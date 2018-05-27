package tweetprocessor.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tweetprocessor.command.LoadUsersCommand;

public class JunitLoadUsers {

	@Test
	public void testExecute() {
		LoadUsersCommand cmd = new LoadUsersCommand();
		if(!cmd.execute()){
			fail("Not yet implemented");
		}	
	}

}
