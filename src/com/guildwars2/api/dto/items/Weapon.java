package com.guildwars2.api.dto.items;

import java.util.List;

import com.guildwars2.api.dto.enums.DamageType;
import com.guildwars2.api.dto.enums.ItemType;

public class Weapon {
	
	private ItemType weaponType;
	
	private DamageType damageType;
	
	private String minPower;
	
	private String maxPower;
	
	private String defense;
	
	private List<InfusionSlot> infusionSlots;
	
	private InfixUpgrade infixUpgrade;

	public Weapon(ItemType weaponType, DamageType damageType, String minPower, String maxPower, String defense, List<InfusionSlot> infusionSlots, InfixUpgrade infixUpgrade) {
		super();
		this.weaponType = weaponType;
		this.damageType = damageType;
		this.minPower = minPower;
		this.maxPower = maxPower;
		this.defense = defense;
		this.infusionSlots = infusionSlots;
		this.infixUpgrade = infixUpgrade;
	}

	public ItemType getWeaponType() {
		return weaponType;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public String getMinPower() {
		return minPower;
	}

	public String getMaxPower() {
		return maxPower;
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
		return "Weapon [weaponType=" + weaponType + ", damageType=" + damageType + ", minPower=" + minPower + ", maxPower=" + maxPower + ", defense=" + defense + ", infusionSlots=" + infusionSlots + ", infixUpgrade=" + infixUpgrade + "]";
	}

}
