package com.guildwars2.api.dto.items;

import com.guildwars2.api.dto.enums.GizmoType;

public class Gizmo {
	
	private GizmoType type;

	public Gizmo(GizmoType type) {
		super();
		this.type = type;
	}

	public GizmoType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Gizmo [type=" + type + "]";
	}

}
