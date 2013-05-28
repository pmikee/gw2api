package cz.zweistein.gw2.api.dto;

import java.util.List;

import cz.zweistein.gw2.api.dto.enums.ItemType;

public class Recipe {

	private Long recipeId;

	private List<Ingredient> ingredients;

	private Long rating;

	private Long timeToCraft;

	private Long outputItem;

	private Long outputCount;

	private ItemType itemType;

	public Recipe(Long recipeId, List<Ingredient> ingredients, Long rating, Long timeToCraft, Long outputItem, Long outputCount, ItemType itemType) {
		super();
		this.recipeId = recipeId;
		this.ingredients = ingredients;
		this.rating = rating;
		this.timeToCraft = timeToCraft;
		this.outputItem = outputItem;
		this.outputCount = outputCount;
		this.itemType = itemType;
	}

	public Long getRecipeId() {
		return this.recipeId;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public Long getRating() {
		return this.rating;
	}

	public Long getTimeToCraft() {
		return this.timeToCraft;
	}

	public Long getOutputItem() {
		return this.outputItem;
	}

	public Long getOutputCount() {
		return this.outputCount;
	}

	public ItemType getItemType() {
		return this.itemType;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + this.recipeId + ", ingredients=" + this.ingredients + ", rating=" + this.rating + ", timeToCraft=" + this.timeToCraft
				+ ", outputItem=" + this.outputItem + ", outputCount=" + this.outputCount + ", itemType=" + this.itemType + "]";
	}

}
