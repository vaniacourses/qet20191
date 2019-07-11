package br.uff.qet.cardgame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	private Player p1;
	private Player p2;
	private Game jogo;
	
	@Before
	public void inicializaJogadores() {
		p1 = new Player("Jogador 1");
		p2 = new Player("Jogador 2");
		jogo = new Game();
		jogo.addPlayer(p1);
		jogo.addPlayer(p2);
		
		p1.takeCard(new Card(Level.FOUR));
		p1.takeCard(new Card(Level.FIVE));
		p1.takeCard(new Card(Level.SIX));
		
		
		p2.takeCard(new Card(Level.FIVE));
		p2.takeCard(new Card(Level.FOUR));	
		p2.takeCard(new Card(Level.SEVEN));		
	}
	
	@Test
	public void testaJogarSimples() {
		Player ganhador = jogo.jogar(p1.getCard(0), p2.getCard(0));
		assertEquals(p2, ganhador);
		
	}
	
	@Test
	public void testaSegundaJogadaSimples() {
		Player ganhador = jogo.jogar(p1.getCard(1), p2.getCard(1));
		assertEquals(p1, ganhador);
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
