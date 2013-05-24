package com.guildwars2.api.dto.items;

import java.util.List;

import com.guildwars2.api.dto.enums.TrinketType;

public class Trinket {

	private TrinketType type;

	private List<InfusionSlot> infusionSlots;
	
	private InfixUpgrade infixUpgrade;
	
	private String suffixItemId;

	public Trinket(TrinketType type, List<InfusionSlot> infusionSlots, InfixUpgrade infixUpgrade, String suffixItemId) {
		super();
		this.type = type;
		this.infusionSlots = infusionSlots;
		this.infixUpgrade = infixUpgrade;
		this.suffixItemId = suffixItemId;
	}

	public List<InfusionSlot> getInfusionSlots() {
		return infusionSlots;
	}

	public InfixUpgrade getInfixUpgrade() {
		return infixUpgrade;
	}

	public String getSuffixItemId() {
		return suffixItemId;
	}

	public TrinketType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Trinket [type=" + type + ", infusionSlots=" + infusionSlots + ", infixUpgrade=" + infixUpgrade + ", suffixItemId=" + suffixItemId + "]";
	}
	
}
