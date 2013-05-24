package com.guildwars2.api.dto.items;

import java.util.List;

import com.guildwars2.api.dto.enums.ItemType;
import com.guildwars2.api.dto.enums.WeightClass;

public class Armor {
	
	private ItemType armorType;
	
	private WeightClass weightClass;
	
	private String defense;
	
	private List<InfusionSlot> infusionSlots;
	
	private InfixUpgrade infixUpgrade;

	public Armor(ItemType armorType, WeightClass weightClass, String defense, List<InfusionSlot> infusionSlots, InfixUpgrade infixUpgrade) {
		super();
		this.armorType = armorType;
		this.weightClass = weightClass;
		this.defense = defense;
		this.infusionSlots = infusionSlots;
		this.infixUpgrade = infixUpgrade;
	}

	public ItemType getArmorType() {
		return armorType;
	}

	public WeightClass getWeightClass() {
		return weightClass;
	}

	public String getDefense() {
		return defense;
	}

	public List<InfusionSlot> getInfusionSlots() {
		return infusionSlots;
	}

	public InfixUpgrade getInfixUpgrade() {
		return infixUpgrade;
	}

	@Override
	public String toString() {
		return "Armor [armorType=" + armorType + ", weightClass=" + weightClass + ", defense=" + defense + ", infusionSlots=" + infusionSlots + ", infixUpgrade=" + infixUpgrade + "]";
	} 

}
