package cz.zweistein.gw2.api.dto;

public class WvWMatch {
	
	private String matchId;

	private Long blueWorldId;
	
	private Long redWorldId;
	
	private Long greenWorldId;

	public WvWMatch(String matchId, Long blueWorldId, Long redWorldId, Long greenWorldId) {
		super();
		this.matchId = matchId;
		this.blueWorldId = blueWorldId;
		this.redWorldId = redWorldId;
		this.greenWorldId = greenWorldId;
	}

	public Long getBlueWorldId() {
		return this.blueWorldId;
	}

	public Long getRedWorldId() {
		return this.redWorldId;
	}

	public Long getGreenWorldId() {
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

