package cz.zweistein.gw2.api.dto;


public class GuildEmblem {
	
	private Long backgroundId;
	
	private Long foregroundId;
	
	private Long flags;
	
	private Long color1;
	
	private Long color2;
	
	private Long color3;
	
	public GuildEmblem(Long backgroundId, Long foregroundId, Long flags, Long color1, Long color2, Long color3) {
		super();
		this.backgroundId = backgroundId;
		this.foregroundId = foregroundId;
		this.flags = flags;
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
	}

	public Long getBackgroundId() {
		return this.backgroundId;
	}

	public Long getForegroundId() {
		return this.foregroundId;
	}

	public Long getFlags() {
		return this.flags;
	}

	public Long getColor1() {
		return this.color1;
	}

	public Long getColor2() {
		return this.color2;
	}

	public Long getColor3() {
		return this.color3;
	}

	@Override
	public String toString() {
		return "GuildEmblem [backgroundId=" + this.backgroundId + ", foregroundId=" + this.foregroundId + ", flags=" + this.flags + ", color1=" + this.color1
				+ ", color2=" + this.color2 + ", color3=" + this.color3 + "]";
	}

}
