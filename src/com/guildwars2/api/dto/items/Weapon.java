package com.guildwars2.api.dto.items;

import com.guildwars2.api.dto.enums.DamageType;
import com.guildwars2.api.dto.enums.ItemType;

public class Weapon {
	
	private ItemType weaponType;
	
	private DamageType damageType;
	
	private String minPower;
	
	private String maxPower;
	
	private String defense;
	
	private Object infusionSlots;
	
	private InfixUpgrade infixUpgrade; 

}
