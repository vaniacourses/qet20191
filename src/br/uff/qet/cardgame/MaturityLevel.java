package br.uff.qet.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaturityLevel {
	
	private Level level;
	private Map<String, Process> process;
	private Map<String, Capacity> capacities;
	
	public MaturityLevel(Level level) {
		this.level = level;
		process = new HashMap<String, Process>();
		capacities = new HashMap<String, Capacity>();
	}
	
	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Map<String, Process> getProcess() {
		return process;
	}

	public void setProcess(Map<String, Process> process) {
		this.process = process;
	}

	public Map<String, Capacity> getCapacities() {
		return capacities;
	}

	public void setCapacities(Map<String, Capacity> capacities) {
		this.capacities = capacities;
	}
 	
	
	

}
