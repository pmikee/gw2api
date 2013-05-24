package cz.zweistein.gw2.api.dto.enums;

public enum TrinketType {
	
	RING("Ring"),
	ACCESSORY("Accessory"),
	AMULET("Amulet");
	
	private String techName;

	private TrinketType(String name) {
		this.techName = name;
	}

	public static TrinketType resolve(String name) {

		for (TrinketType state : TrinketType.values()) {
			if (state.techName.equals(name)) {
				return state;
			}
		}
		
		throw new IllegalArgumentException(name);
	}

}
