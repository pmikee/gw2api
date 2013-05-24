package com.guildwars2.api.dto.enums;

public enum Restriction {

	ASURA("Asura");
	
	private String techName;

	private Restriction(String name) {
		this.techName = name;
	}

	public static Restriction resolve(String name) {

		for (Restriction state : Restriction.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}
	
}
