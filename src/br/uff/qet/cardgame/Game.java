package br.uff.qet.cardgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game {
	private Map<Level, MaturityLevel> mpsbr;
    private List<Player> players;
	private List<Card> deck;
    private int finalRound = 15;
    private int actualRound = 1;
	
	public Game() {
		this.mpsbr = new HashMap<Level, MaturityLevel>();
		this.players = new ArrayList<Player>();
        this.initializeGame();
	}
	
    public void nextRound(){
        this.actualRound++;
    }
    
    public int getRound(){
        return this.actualRound;
    }
    
    public int getFinalRound(){
        return this.finalRound;
    }	

    public void addPlayer(Player player) {
    	player.setCurrentMaturityLevel(mpsbr.get(Level.G));
    	player.setGame(this);
    	players.add(player);
        
    }

    public int countPlayers() {
        return players.size();
    }      
    
	public void initializeGame() {
		Util.initializeLevels(mpsbr);
		//initializeCards();
		//shuffleCards();
	}
	

	

	public boolean levelUp(MaturityLevel newLevel, Player player) {
		return player.levelUp(newLevel, mpsbr.get(player.getCurrentMaturityLevel().getLevel()).getProcess().keySet());
	}

}
