package br.uff.qet.cardgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	private Player p1;
	private Player p2;
	private Game jogo;
	private Map<Level, MaturityLevel> mpsbr;
	
	@Before
	public void inicializaJogadores() {
		mpsbr = new HashMap<Level, MaturityLevel>();
		p1 = new Player("Jogador 1");
		p2 = new Player("Jogador 2");
		jogo = new Game();
		jogo.addPlayer(p1);
		jogo.addPlayer(p2);
		Util.initializeLevels(mpsbr);
	}
	
	@Test
	public void testaSubirMesmoNivel() {
		assertFalse(jogo.levelUp(mpsbr.get(Level.G), p1));		
	}
	
	@Test
	public void testaSubirNivel() {		
		assertTrue(jogo.levelUp(mpsbr.get(Level.D), p1));		
	}	
	
	
	
	
	
	
	
	
	
	
	
	

}
