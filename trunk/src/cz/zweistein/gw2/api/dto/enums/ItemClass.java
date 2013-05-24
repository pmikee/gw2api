package cz.zweistein.gw2.api.dto.enums;

public enum ItemClass {
	
	ARMOR("Armor"),
	CRAFTING_MATERIAL("CraftingMaterial"),
	WEAPON("Weapon"),
	BAG("Bag"), //flags are not array FIXME, needs research
	CONTAINER("Container"),
	TROPHY("Trophy"), //no bound information?
	CONSUMABLE("Consumable"),
	TRINKET("Trinket"),
	GIZMO("Gizmo"), //FIXME
	UPGRADE_COMPONENT("UpgradeComponent"),
	BACK("Back"),
	MINIPET("MiniPet"), //no bound information
	GATHERING("Gathering"); //FIXME "gathering":{"type":"Mining"}
	
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
