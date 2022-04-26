package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GameEnvironment;
import main.Monster;
import monsters.Garen;

class GameEnvironmentTest {

	@BeforeEach
	public void testSetup() {
		GameEnvironment game = new GameEnvironment();
	}
	
	@Test
	void gameSetupTest() {
		Monster monsterThing = new Garen();
		GameEnvironment game = new GameEnvironment();
		assertEquals("Good name", game.gameSetup("Steve", 5, monsterThing, "Easy"));
	}
	

}
