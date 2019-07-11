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
    public static int numberPlayers = 2;
	
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
        players.add(player);
    }

    public int countPlayers() {
        return players.size();
    }      
    
	public void initializeGame() {
		initializeLevels();
		initializePlayers();
		//initializeCards();
		//shuffleCards();
	}
	
	public void initializePlayers() {
		for (int i=0; i< numberPlayers; i++) {
			Player p = new Player("Player "+i,  mpsbr.get(Level.G), this);
			players.add(p);
		}
		
	}
	public void initializeLevels() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./resources/levels.info"));
			while (br.ready()) {
				String linha = br.readLine();
				String[] levels = linha.split("\\|", -1);
				Level level = Level.valueOf(levels[0].trim());
				MaturityLevel mLevel = new MaturityLevel(level);
				for (int i = 1; i < levels.length; i++) {
					Process process = new Process(levels[i].trim());
					this.initializeProcess(process);
					mLevel.getProcess().put(levels[i].trim(), process);
				}
				mpsbr.put(level, mLevel);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public void initializeProcess(Process process) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./resources/process.info"));
			while (br.ready()) {
				String linha = br.readLine();
				String[] employees = linha.split("\\|", -1);
				Process newProcess = new Process(employees[0].trim());
				if (!process.equals(newProcess))
					continue;
				for (int i = 1; i < employees.length; i++) {
					Employee employee = new Employee(employees[i].trim());
					this.initializeEmployees(employee);
					process.getEmployees().put(employees[i].trim(), employee);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initializeEmployees(Employee employee) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./resources/artifacts.info"));
			while (br.ready()) {
				String linha = br.readLine();
				String[] artifacts = linha.split("\\|", -1);
				Employee newEmployee = new Employee(artifacts[0].trim());
				if (!employee.equals(newEmployee))
					continue;
				for (int i = 1; i < artifacts.length; i++) {
					Artifact artifact = new Artifact(artifacts[i].trim());
					employee.getArtifacts().add(artifact);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public boolean levelUp(MaturityLevel newLevel, Player player) {
		return player.levelUp(newLevel);

}
