package cz.zweistein.gw2.api.dto;

public class ColorHue {

	private Long brightness;
	
	private Long contrast;
	
	private Long hue;
	
	private Long saturation;
	
	private Long lightness;

	public ColorHue(Long brightness, Long contrast, Long hue, Long saturation, Long lightness) {
		super();
		this.brightness = brightness;
		this.contrast = contrast;
		this.hue = hue;
		this.saturation = saturation;
		this.lightness = lightness;
	}

	public Long getBrightness() {
		return this.brightness;
	}

	public Long getContrast() {
		return this.contrast;
	}

	public Long getHue() {
		return this.hue;
	}

	public Long getSaturation() {
		return this.saturation;
	}

	public Long getLightness() {
		return this.lightness;
	}

	@Override
	public String toString() {
		return "ColorHue [brightness=" + this.brightness + ", contrast=" + this.contrast + ", hue=" + this.hue + ", saturation=" + this.saturation
				+ ", lightness=" + this.lightness + "]";
	}

}
