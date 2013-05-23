package com.guildwars2.api.dto.enums;

public enum WeightClass {
	
	LIGHT("Light");
	
	private String techName;

	private WeightClass(String name) {
		this.techName = name;
	}

	public static WeightClass resolve(String name) {

		for (WeightClass state : WeightClass.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}

		throw new IllegalArgumentException(name);
	}

}
