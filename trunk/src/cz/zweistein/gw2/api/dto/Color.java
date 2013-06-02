package cz.zweistein.gw2.api.dto;

public class Color {
	
	private String name;

	private ColorHue defaultColor;
	
	private ColorHue metalColor;
	
	private ColorHue clothColor;
	
	private ColorHue leatherColor;
	
	public Color(String name, ColorHue defaultColor, ColorHue metalColor, ColorHue clothColor, ColorHue leatherColor) {
		super();
		this.name = name;
		this.defaultColor = defaultColor;
		this.metalColor = metalColor;
		this.clothColor = clothColor;
		this.leatherColor = leatherColor;
	}

	public String getName() {
		return this.name;
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
		return "Color [name=" + this.name + ", defaultColor=" + this.defaultColor + ", metalColor=" + this.metalColor + ", clothColor=" + this.clothColor
				+ ", leatherColor=" + this.leatherColor + "]";
	}

}
