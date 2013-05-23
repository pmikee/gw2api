package com.guildwars2.api.dto;

import java.util.List;

import com.guildwars2.api.dto.enums.RecipeType;

public class Recipe {

	private String recipeId;

	private List<Ingredient> ingredients;

	private String rating;

	private String timeToCraft;

	private String outputItem;

	private String outputCount;

	private RecipeType itemType;

	public Recipe(String recipeId, List<Ingredient> ingredients, String rating, String timeToCraft, String outputItem, String outputCount, RecipeType itemType) {
		super();
		this.recipeId = recipeId;
		this.ingredients = ingredients;
		this.rating = rating;
		this.timeToCraft = timeToCraft;
		this.outputItem = outputItem;
		this.outputCount = outputCount;
		this.itemType = itemType;
	}

	public String getRecipeId() {
		return this.recipeId;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public String getRating() {
		return this.rating;
	}

	public String getTimeToCraft() {
		return this.timeToCraft;
	}

	public String getOutputItem() {
		return this.outputItem;
	}

	public String getOutputCount() {
		return this.outputCount;
	}

	public RecipeType getItemType() {
		return this.itemType;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + this.recipeId + ", ingredients=" + this.ingredients + ", rating=" + this.rating + ", timeToCraft=" + this.timeToCraft
				+ ", outputItem=" + this.outputItem + ", outputCount=" + this.outputCount + ", itemType=" + this.itemType + "]";
	}

}
