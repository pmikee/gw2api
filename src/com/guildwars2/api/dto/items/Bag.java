package com.guildwars2.api.dto.items;

import java.util.List;

import com.guildwars2.api.dto.enums.BagModifier;

public class Bag {
	
	private String size;
	
	private List<BagModifier> bagModifiers;
	
	public Bag(String size, List<BagModifier> bagModifiers) {
		super();
		this.size = size;
		this.bagModifiers = bagModifiers;
	}

	public String getSize() {
		return size;
	}

	public List<BagModifier> getBagModifiers() {
		return bagModifiers;
	}

	@Override
	public String toString() {
		return "Bag [size=" + size + ", bagModifier=" + bagModifiers + "]";
	}

}
