package com.guildwars2.api.dto.items;

import com.guildwars2.api.dto.enums.GatheringType;

public class Gathering {

	private GatheringType type;

	public Gathering(GatheringType type) {
		super();
		this.type = type;
	}

	public GatheringType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Gathering [type=" + type + "]";
	}
	
}
