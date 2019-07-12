package br.uff.qet.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Player {

    private String name;
    private List<Card> hand;
    private Map<String, Process> process;
    private Score score;
    private MaturityLevel currentMaturityLevel;
    private Game game;
    private int resource;
    
    public Player(String name){
        this.name = name;
        this.process = new HashMap<String, Process>();
        this.score = new Score();
        this.hand = new ArrayList<Card>();
    }

    
    
    public Game getGame() {
		return game;
	}



	public void setGame(Game game) {
		this.game = game;
	}



	public void addResource(int quantity){
        this.resource += quantity;
    }

    public int getResource(){
        return this.resource;
    }
        

    public void takeCard(Card card) {
        hand.add(card);
    }

    public int countHand(){
        return hand.size();
    }
    
    public Card getCard(int posicao) {
    	return this.hand.remove(posicao);
    }

    public int getHandValue(){
        int cardValues = 0;
        for (Card card : hand){
            int cardValue = card.getValue().ordinal();
            cardValues += cardValue;
        }
        return cardValues;
    }
    
    public void earnProcess(Process newProcess) {
    	this.process.put(newProcess.getName(), newProcess);
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Card> getHand() {
		return hand;
	}


	public void setHand(List<Card> hand) {
		this.hand = hand;
	}


	public Map<String, Process> getProcess() {
		return process;
	}


	public void setProcess(Map<String, Process> process) {
		this.process = process;
	}


	public Score getScore() {
		return score;
	}


	public void setScore(Score score) {
		this.score = score;
	}


	public MaturityLevel getCurrentMaturityLevel() {
		return currentMaturityLevel;
	}


	public void setCurrentMaturityLevel(MaturityLevel currentMaturityLevel) {
		this.currentMaturityLevel = currentMaturityLevel;
	}
    
	public boolean levelUp(MaturityLevel newLevel, Set<String> requirements) {
		if (this.currentMaturityLevel.getLevel().ordinal() >= newLevel.getLevel().ordinal()) {
			return false;
		}
		else {
			boolean isAble = true;
			for (String requirement : requirements){
				if (this.getProcess().get(requirement) != null) {
					isAble = false;
					break;
				}
			}
			if (isAble){
				this.setCurrentMaturityLevel(newLevel);
				this.process = new HashMap<String, Process>();
			}
			return isAble;
		}			
	}   

}

