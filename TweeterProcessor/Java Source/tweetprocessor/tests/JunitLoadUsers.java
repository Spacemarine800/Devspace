package tweetprocessor.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tweetprocessor.command.LoadUsersCommand;

public class JunitLoadUsers {

	@Test
	public void testExecute() {
		LoadUsersCommand cmd = new LoadUsersCommand();
		assertTrue(cmd.execute());	
	}

}
