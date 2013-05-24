package com.guildwars2.api.dto.enums;

public enum GizmoType {
	
	DEFAULT("Default");
	
	private String techName;

	private GizmoType(String name) {
		this.techName = name;
	}

	public static GizmoType resolve(String name) {

		for (GizmoType state : GizmoType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}

}
