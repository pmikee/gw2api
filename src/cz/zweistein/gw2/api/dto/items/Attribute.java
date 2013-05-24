package cz.zweistein.gw2.api.dto.items;

import cz.zweistein.gw2.api.dto.enums.AttributeType;

public class Attribute {
	
	private AttributeType attribute;
	
	private String modifier;

	public Attribute(AttributeType attribute, String modifier) {
		super();
		this.attribute = attribute;
		this.modifier = modifier;
	}

	public AttributeType getAttribute() {
		return attribute;
	}

	public String getModifier() {
		return modifier;
	}

	@Override
	public String toString() {
		return "Attribute [attribute=" + attribute + ", modifier=" + modifier + "]";
	}

}
