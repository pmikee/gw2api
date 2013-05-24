package com.guildwars2.api.dto.enums;

public enum AttributeType {
	
	POWER("Power"),
	PRECISION("Precision");

	private String techName;

	private AttributeType(String name) {
		this.techName = name;
	}

	public static AttributeType resolve(String name) {

		for (AttributeType state : AttributeType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}
	
}
