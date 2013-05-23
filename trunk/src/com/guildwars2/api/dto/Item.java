package com.guildwars2.api.dto;

import java.util.List;

import com.guildwars2.api.dto.enums.GameType;
import com.guildwars2.api.dto.enums.ItemFlag;
import com.guildwars2.api.dto.enums.ItemType;
import com.guildwars2.api.dto.enums.Rarity;

public class Item {

	private String itemId;

	private String name;

	private String description;

	private String level;

	private Rarity rarity;

	private String vendorValue;

	private List<GameType> gameTypes;

	private List<ItemFlag> flags;

	private Object restrictions;

	private Armor armor; //FIXME
	
	private Object weapon; //FIXME
	
	private Object craftingMaterial; //FIXME

	private String suffixItemId;
	
	private ItemType itemType;

	public Item(String itemId, String name, String description, String level, Rarity rarity, String vendorValue, List<GameType> gameTypes, List<ItemFlag> flags,
			Object restrictions, Armor armor, String suffixItemId, ItemType itemType) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.level = level;
		this.rarity = rarity;
		this.vendorValue = vendorValue;
		this.gameTypes = gameTypes;
		this.flags = flags;
		this.restrictions = restrictions;
		this.armor = armor;
		this.suffixItemId = suffixItemId;
		this.itemType = itemType;
	}

	public String getItemId() {
		return this.itemId;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getLevel() {
		return this.level;
	}

	public Rarity getRarity() {
		return this.rarity;
	}

	public String getVendorValue() {
		return this.vendorValue;
	}

	public List<GameType> getGameTypes() {
		return this.gameTypes;
	}

	public List<ItemFlag> getFlags() {
		return this.flags;
	}

	public Object getRestrictions() {
		return this.restrictions;
	}

	public Armor getArmor() {
		return this.armor;
	}

	public String getSuffixItemId() {
		return this.suffixItemId;
	}
	
	public ItemType getItemType() {
		return this.itemType;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + this.itemId + ", name=" + this.name + ", description=" + this.description + ", level=" + this.level + ", rarity="
				+ this.rarity + ", vendorValue=" + this.vendorValue + ", gameTypes=" + this.gameTypes + ", flags=" + this.flags + ", restrictions="
				+ this.restrictions + ", armor=" + this.armor + ", suffixItemId=" + this.suffixItemId + ", itemType=" + this.itemType + "]";
	}



}
