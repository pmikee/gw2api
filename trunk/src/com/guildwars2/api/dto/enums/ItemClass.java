package com.guildwars2.api.dto.enums;

public enum ItemClass {
	
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

	private ItemClass(String name) {
		this.techName = name;
	}

	public static ItemClass resolve(String name) {

		for (ItemClass state : ItemClass.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}

}
