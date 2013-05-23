package com.guildwars2.api.dto.enums;

public enum ArmorType {
	
	COAT("Coat");
	
	private String techName;

	private ArmorType(String name) {
		this.techName = name;
	}

	public static ArmorType resolve(String name) {

		for (ArmorType state : ArmorType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}

		throw new IllegalArgumentException(name);
	}

}
