package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GameEnvironment;
import main.Monster;
import monsters.Jaren;

class GameEnvironmentTest {

	@BeforeEach
	public void testSetup() {
		GameEnvironment game = new GameEnvironment();
	}
	
	@Test
	void gameSetupTest() {
		Monster monsterThing = new Jaren();
		GameEnvironment game = new GameEnvironment();
		assertEquals("Good name", game.gameSetup("Steve", 5, monsterThing, "Easy"));
	}
	

}
