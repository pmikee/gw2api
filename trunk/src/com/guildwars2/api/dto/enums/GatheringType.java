package com.guildwars2.api.dto.enums;

public enum GatheringType {
	
	MINING("Mining"),
	LOGGING("Logging");
	
	private String techName;

	private GatheringType(String name) {
		this.techName = name;
	}

	public static GatheringType resolve(String name) {

		for (GatheringType state : GatheringType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}

}
