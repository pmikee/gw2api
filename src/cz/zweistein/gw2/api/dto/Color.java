package cz.zweistein.gw2.api.dto;

public class Color {
	
	private ColorHue defaultColor;
	
	private ColorHue metalColor;
	
	private ColorHue clothColor;
	
	private ColorHue leatherColor;
	
	public Color(ColorHue defaultColor, ColorHue metalColor, ColorHue clothColor, ColorHue leatherColor) {
		super();
		this.defaultColor = defaultColor;
		this.metalColor = metalColor;
		this.clothColor = clothColor;
		this.leatherColor = leatherColor;
	}

	public ColorHue getDefaultColor() {
		return this.defaultColor;
	}

	public ColorHue getMetalColor() {
		return this.metalColor;
	}

	public ColorHue getClothColor() {
		return this.clothColor;
	}

	public ColorHue getLeatherColor() {
		return this.leatherColor;
	}

	@Override
	public String toString() {
		return "Color [defaultColor=" + this.defaultColor + ", metalColor=" + this.metalColor + ", clothColor=" + this.clothColor + ", leatherColor="
				+ this.leatherColor + "]";
	}

}
