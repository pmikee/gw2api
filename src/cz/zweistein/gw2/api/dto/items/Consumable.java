package cz.zweistein.gw2.api.dto.items;

import cz.zweistein.gw2.api.dto.enums.ConsumableType;

public class Consumable {
	
	private ConsumableType type;

	private String description;
	
	private String duration;

	public Consumable(ConsumableType type, String description, String duration) {
		super();
		this.type = type;
		this.description = description;
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public String getDuration() {
		return duration;
	}

	public ConsumableType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Consumable [type=" + type + ", description=" + description + ", duration=" + duration + "]";
	}
	
}
