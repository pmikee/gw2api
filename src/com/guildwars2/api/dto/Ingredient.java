package com.guildwars2.api.dto;

public class Ingredient {

	private String count;

	private String itemId;

	public Ingredient(String count, String itemId) {
		super();
		this.count = count;
		this.itemId = itemId;
	}

	public String getCount() {
		return this.count;
	}

	public String getItemId() {
		return this.itemId;
	}

	@Override
	public String toString() {
		return "Ingredient [count=" + this.count + ", itemId=" + this.itemId + "]";
	}

}
