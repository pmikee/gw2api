package com.guildwars2.api.dto.enums;

public enum ConsumableType {
	
	UNLOCK("Unlock"),
	GENERIC("Generic"),
	FOOD("Food"),
	UTILITY("Utility");
	
	private String techName;

	private ConsumableType(String name) {
		this.techName = name;
	}

	public static ConsumableType resolve(String name) {

		for (ConsumableType state : ConsumableType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}


}
