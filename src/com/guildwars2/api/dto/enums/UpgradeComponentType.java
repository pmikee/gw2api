package com.guildwars2.api.dto.enums;

public enum UpgradeComponentType {
	
	SIGIL("Sigil"),
	DEFAULT("Default"),
	RUNE("Rune"),
	GEM("Gem");
	
	private String techName;

	private UpgradeComponentType(String name) {
		this.techName = name;
	}

	public static UpgradeComponentType resolve(String name) {

		for (UpgradeComponentType state : UpgradeComponentType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}

}
