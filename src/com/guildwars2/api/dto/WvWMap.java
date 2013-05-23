package com.guildwars2.api.dto;

import java.util.List;

import com.guildwars2.api.dto.enums.WvWMapType;

public class WvWMap {
	
	private Scores scores;

	private WvWMapType type;

	private List<WvWObjective> objectives;

	public WvWMap(Scores scores, WvWMapType type, List<WvWObjective> objectives) {
		super();
		this.scores = scores;
		this.type = type;
		this.objectives = objectives;
	}

	public Scores getScores() {
		return this.scores;
	}

	public WvWMapType getType() {
		return this.type;
	}

	public List<WvWObjective> getObjectives() {
		return this.objectives;
	}

	@Override
	public String toString() {
		return "WvWMap [scores=" + this.scores + ", type=" + this.type + ", objectives=" + this.objectives + "]";
	}
	
}
