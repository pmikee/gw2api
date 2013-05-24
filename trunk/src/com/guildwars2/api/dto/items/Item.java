package com.guildwars2.api.dto.items;

import java.util.List;

import com.guildwars2.api.dto.enums.GameType;
import com.guildwars2.api.dto.enums.ItemFlag;
import com.guildwars2.api.dto.enums.ItemClass;
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

	private String suffixItemId;
	
	private ItemClass itemType;

	private Armor armor;
	
	private Weapon weapon;
	
	private Bag bag;
	
	private Container container;
	
	private Consumable consumable;
	
	private Trinket trinket;
	
	private UpgradeComponent upgradeComponent;

	public Item(String itemId, String name, String description, String level, Rarity rarity, String vendorValue, List<GameType> gameTypes, List<ItemFlag> flags, Object restrictions, String suffixItemId, ItemClass itemType, Armor armor, Weapon weapon, Bag bag, Container container, Consumable consumable, Trinket trinket, UpgradeComponent upgradeComponent) {
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
		this.suffixItemId = suffixItemId;
		this.itemType = itemType;
		this.armor = armor;
		this.weapon = weapon;
		this.bag = bag;
		this.container = container;
		this.consumable = consumable;
		this.trinket = trinket;
		this.upgradeComponent = upgradeComponent;
	}

	public Weapon getWeapon() {
		return weapon;
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

	public Consumable getConsumable() {
		return consumable;
	}

	public String getSuffixItemId() {
		return this.suffixItemId;
	}
	
	public UpgradeComponent getUpgradeComponent() {
		return upgradeComponent;
	}

	public ItemClass getItemType() {
		return this.itemType;
	}

	public Bag getBag() {
		return bag;
	}

	public Container getContainer() {
		return container;
	}

	public Trinket getTrinket() {
		return trinket;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", description=" + description + ", level=" + level + ", rarity=" + rarity + ", vendorValue=" + vendorValue + ", gameTypes=" + gameTypes + ", flags=" + flags + ", restrictions=" + restrictions + ", suffixItemId=" + suffixItemId + ", itemType=" + itemType + ", armor=" + armor + ", weapon=" + weapon + ", bag=" + bag + ", container="
				+ container + ", consumable=" + consumable + ", trinket=" + trinket + ", upgradeComponent=" + upgradeComponent + "]";
	}

}
