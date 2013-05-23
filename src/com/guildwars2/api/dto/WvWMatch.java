package com.guildwars2.api.dto;

public class WvWMatch {
	
	private String matchId;

	private String blueWorldId;
	
	private String redWorldId;
	
	private String greenWorldId;

	public WvWMatch(String matchId, String blueWorldId, String redWorldId, String greenWorldId) {
		super();
		this.matchId = matchId;
		this.blueWorldId = blueWorldId;
		this.redWorldId = redWorldId;
		this.greenWorldId = greenWorldId;
	}

	public String getBlueWorldId() {
		return this.blueWorldId;
	}

	public String getRedWorldId() {
		return this.redWorldId;
	}

	public String getGreenWorldId() {
		return this.greenWorldId;
	}

	public String getMatchId() {
		return this.matchId;
	}

	@Override
	public String toString() {
		return "WvWMatch [blueWorldId=" + this.blueWorldId + ", redWorldId=" + this.redWorldId + ", greenWorldId=" + this.greenWorldId + ", matchId="
				+ this.matchId + "]";
	}
	
}

