package com.guildwars2.api.dto.enums;

public enum InfusionSlotFlag {
	
	DEFENSE("Defense");
	
	private String techName;

	private InfusionSlotFlag(String name) {
		this.techName = name;
	}

	public static InfusionSlotFlag resolve(String name) {

		for (InfusionSlotFlag state : InfusionSlotFlag.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}

		throw new IllegalArgumentException(name);
	}

}
