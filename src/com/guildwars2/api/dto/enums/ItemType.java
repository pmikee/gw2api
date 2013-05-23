package com.guildwars2.api.dto.enums;

public enum ItemType {
	
	ARMOR("Armor"),
	CRAFTING_MATERIAL("CraftingMaterial"),
	WEAPON("Weapon"),
	BAG("Bag"),
	CONTAINER("Container"),
	TROPHY("Trophy"),
	CONSUMABLE("Consumable"),
	TRINKET("Trinket"),
	GIZMO("Gizmo"),
	UPGRADE_COMPONENT("UpgradeComponent"),
	MINIPET("MiniPet");
	
	private String techName;

	private ItemType(String name) {
		this.techName = name;
	}

	public static ItemType resolve(String name) {

		for (ItemType state : ItemType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}

}
