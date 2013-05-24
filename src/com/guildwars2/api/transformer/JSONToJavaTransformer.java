package com.guildwars2.api.transformer;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.guildwars2.api.dto.Ingredient;
import com.guildwars2.api.dto.Recipe;
import com.guildwars2.api.dto.Scores;
import com.guildwars2.api.dto.WvWMap;
import com.guildwars2.api.dto.WvWMatchDetail;
import com.guildwars2.api.dto.WvWObjective;
import com.guildwars2.api.dto.enums.AttributeType;
import com.guildwars2.api.dto.enums.BagModifier;
import com.guildwars2.api.dto.enums.ConsumableType;
import com.guildwars2.api.dto.enums.ContainerType;
import com.guildwars2.api.dto.enums.DamageType;
import com.guildwars2.api.dto.enums.GameType;
import com.guildwars2.api.dto.enums.GatheringType;
import com.guildwars2.api.dto.enums.GizmoType;
import com.guildwars2.api.dto.enums.InfusionSlotFlag;
import com.guildwars2.api.dto.enums.ItemClass;
import com.guildwars2.api.dto.enums.ItemFlag;
import com.guildwars2.api.dto.enums.ItemType;
import com.guildwars2.api.dto.enums.Rarity;
import com.guildwars2.api.dto.enums.Restriction;
import com.guildwars2.api.dto.enums.TrinketType;
import com.guildwars2.api.dto.enums.UpgradeComponentFlag;
import com.guildwars2.api.dto.enums.UpgradeComponentType;
import com.guildwars2.api.dto.enums.WeightClass;
import com.guildwars2.api.dto.enums.WvWMapType;
import com.guildwars2.api.dto.enums.WvWSide;
import com.guildwars2.api.dto.items.Armor;
import com.guildwars2.api.dto.items.Attribute;
import com.guildwars2.api.dto.items.Back;
import com.guildwars2.api.dto.items.Bag;
import com.guildwars2.api.dto.items.Buff;
import com.guildwars2.api.dto.items.Consumable;
import com.guildwars2.api.dto.items.Container;
import com.guildwars2.api.dto.items.Gathering;
import com.guildwars2.api.dto.items.Gizmo;
import com.guildwars2.api.dto.items.InfixUpgrade;
import com.guildwars2.api.dto.items.InfusionSlot;
import com.guildwars2.api.dto.items.Item;
import com.guildwars2.api.dto.items.Trinket;
import com.guildwars2.api.dto.items.UpgradeComponent;
import com.guildwars2.api.dto.items.Weapon;

public class JSONToJavaTransformer {

	private InfixUpgrade parseInfixUpgrade(JSONObject obj) {
		InfixUpgrade infixUpgrade = null;
		if (!(obj.get("infix_upgrade") instanceof String)) {
			JSONObject infixObj = (JSONObject) obj.get("infix_upgrade");
			JSONArray attributesObj = (JSONArray) infixObj.get("attributes");
			List<Attribute> attributes = new ArrayList<Attribute>(attributesObj.size());
			for (Object attributeO : attributesObj) {
				JSONObject attributeObj = (JSONObject) attributeO;

				attributes.add(new Attribute(AttributeType.resolve((String) attributeObj.get("attribute")), (String) attributeObj.get("modifier")));
			}

			Buff buff = null;
			if (!(infixObj.get("buff") instanceof String)) {
				JSONObject buffObj = (JSONObject) infixObj.get("buff");
				buff = new Buff((String) buffObj.get("skill_id"), (String) buffObj.get("description"));
			}
			infixUpgrade = new InfixUpgrade(buff, attributes);
		}

		return infixUpgrade;
	}

	private List<InfusionSlot> parseInfusionSlots(JSONObject obj) {
		JSONArray infusionSlotsObj = (JSONArray) obj.get("infusion_slots");
		List<InfusionSlot> infusionSlots = new ArrayList<InfusionSlot>(infusionSlotsObj.size());
		for (Object infusionSlotO : infusionSlotsObj) {
			JSONObject infusionSlotObj = (JSONObject) infusionSlotO;

			JSONArray infusionFlagsObj = (JSONArray) infusionSlotObj.get("flags");
			List<InfusionSlotFlag> infusionFlags = new ArrayList<InfusionSlotFlag>(infusionFlagsObj.size());
			for (Object infusionFlagO : infusionFlagsObj) {
				String infusionFlag = (String) infusionFlagO;

				infusionFlags.add(InfusionSlotFlag.resolve(infusionFlag));
			}

			infusionSlots.add(new InfusionSlot(infusionFlags, null));

		}
		return infusionSlots;
	}

	public Item transfromItem(JSONObject obj) {

		JSONArray gameTypesObj = (JSONArray) obj.get("game_types");
		List<GameType> gameTypes = new ArrayList<GameType>(gameTypesObj.size());
		for (Object gameTypeO : gameTypesObj) {
			gameTypes.add(GameType.resolve((String) gameTypeO));
		}

		JSONArray flagsObj = (JSONArray) obj.get("flags");
		List<ItemFlag> flags = new ArrayList<ItemFlag>(flagsObj.size());
		for (Object flagO : flagsObj) {
			flags.add(ItemFlag.resolve(((String) flagO)));
		}

		JSONArray restrictionsObj = (JSONArray) obj.get("restrictions");
		List<Restriction> restrictions = new ArrayList<Restriction>(restrictionsObj.size());
		for (Object restrictionO : restrictionsObj) {
			restrictions.add(Restriction.resolve((String) restrictionO));
		}

		ItemClass itemClass = ItemClass.resolve((String) obj.get("type"));

		Armor armor = null;
		if (ItemClass.ARMOR.equals(itemClass)) {
			JSONObject armorObj = (JSONObject) obj.get("armor");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(armorObj);
			List<InfusionSlot> infusionSlots = parseInfusionSlots(armorObj);

			armor = new Armor(ItemType.resolve((String) armorObj.get("type")), WeightClass.resolve((String) armorObj.get("weight_class")), (String) armorObj.get("defense"), infusionSlots, infixUpgrade);
		}

		Weapon weapon = null;
		if (ItemClass.WEAPON.equals(itemClass)) {
			JSONObject weaponObj = (JSONObject) obj.get("weapon");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(weaponObj);
			List<InfusionSlot> infusionSlots = parseInfusionSlots(weaponObj);

			weapon = new Weapon(ItemType.resolve((String) weaponObj.get("type")), DamageType.resolve((String) weaponObj.get("damage_type")), (String) weaponObj.get("min_power"), (String) weaponObj.get("max_power"), (String) weaponObj.get("defense"), infusionSlots, infixUpgrade);
		}

		Trinket trinket = null;
		if (ItemClass.TRINKET.equals(itemClass)) {
			JSONObject trinketObj = (JSONObject) obj.get("trinket");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(trinketObj);
			List<InfusionSlot> infusionSlots = parseInfusionSlots(trinketObj);

			trinket = new Trinket(TrinketType.resolve((String) trinketObj.get("type")), infusionSlots, infixUpgrade, (String) trinketObj.get("suffix_item_id"));
		}

		Bag bag = null;
		if (ItemClass.BAG.equals(itemClass)) {
			JSONObject bagObj = (JSONObject) obj.get("bag");

			List<BagModifier> bagModifiers = new ArrayList<BagModifier>();

			for (BagModifier bagModifier : BagModifier.values()) {
				if (bagObj.get(bagModifier.getTechName()) != null) {
					bagModifiers.add(bagModifier);
				}
			}

			bag = new Bag((String) bagObj.get("size"), bagModifiers);
		}

		Container container = null;
		if (ItemClass.CONTAINER.equals(itemClass)) {
			JSONObject containerObj = (JSONObject) obj.get("container");

			container = new Container(ContainerType.resolve((String) containerObj.get("type")));
		}

		Consumable consumable = null;
		if (ItemClass.CONSUMABLE.equals(itemClass)) {
			JSONObject consumableObj = (JSONObject) obj.get("consumable");

			consumable = new Consumable(ConsumableType.resolve((String) consumableObj.get("type")), (String) consumableObj.get("description"), (String) consumableObj.get("duration_ms"));
		}

		UpgradeComponent upgradeComponent = null;
		if (ItemClass.UPGRADE_COMPONENT.equals(itemClass)) {
			JSONObject upgradeComponentObj = (JSONObject) obj.get("upgrade_component");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(upgradeComponentObj);

			List<UpgradeComponentFlag> upgradeComponentFlags = new ArrayList<UpgradeComponentFlag>();
			JSONArray upgradeComponentFlagsObj = (JSONArray) upgradeComponentObj.get("flags");
			;
			for (Object flagO : upgradeComponentFlagsObj) {
				upgradeComponentFlags.add(UpgradeComponentFlag.resolve(((String) flagO)));
			}

			upgradeComponent = new UpgradeComponent(UpgradeComponentType.resolve((String) upgradeComponentObj.get("type")), upgradeComponentFlags, infixUpgrade, (String) upgradeComponentObj.get("suffix"), null);
		}

		Back back = null;
		if (ItemClass.BACK.equals(itemClass)) {
			JSONObject backObj = (JSONObject) obj.get("back");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(backObj);
			List<InfusionSlot> infusionSlots = parseInfusionSlots(backObj);

			back = new Back(infusionSlots, infixUpgrade, (String) backObj.get("suffix_item_id"));
		}

		Gathering gathering = null;
		if (ItemClass.GATHERING.equals(itemClass)) {
			JSONObject gatheringObj = (JSONObject) obj.get("gathering");

			gathering = new Gathering(GatheringType.resolve((String) gatheringObj.get("type")));
		}

		Gizmo gizmo = null;
		if (ItemClass.GIZMO.equals(itemClass)) {
			JSONObject gizmoObj = (JSONObject) obj.get("gizmo");

			gizmo = new Gizmo(GizmoType.resolve((String) gizmoObj.get("type")));
		}

		return new Item((String) obj.get("item_id"), (String) obj.get("name"), (String) obj.get("description"), (String) obj.get("level"), Rarity.resolve((String) obj.get("rarity")), (String) obj.get("vendor_value"), gameTypes, flags, restrictions, (String) obj.get("suffix_item_id"), itemClass, armor, weapon, bag, container, consumable, trinket, upgradeComponent, back, gathering, gizmo);

	}

	public Recipe transfromRecipe(JSONObject obj) {
		JSONArray ingredientsObj = (JSONArray) obj.get("ingredients");

		List<Ingredient> ingredients = new ArrayList<Ingredient>(ingredientsObj.size());

		for (Object ingredientO : ingredientsObj) {
			JSONObject ingredientObj = (JSONObject) ingredientO;

			ingredients.add(new Ingredient((String) ingredientObj.get("count"), (String) ingredientObj.get("item_id")));
		}

		return new Recipe((String) obj.get("recipe_id"), ingredients, (String) obj.get("min_rating"), (String) obj.get("time_to_craft_ms"), (String) obj.get("output_item_id"), (String) obj.get("output_item_count"), ItemType.resolve((String) obj.get("type")));
	}

	public WvWMatchDetail transformWvWMatchDetails(JSONObject obj) {

		JSONArray mapsObj = (JSONArray) obj.get("maps");
		List<WvWMap> wvwMaps = new ArrayList<WvWMap>(mapsObj.size());

		for (Object mapO : mapsObj) {
			JSONObject mapObj = (JSONObject) mapO;

			JSONArray objectivesObj = (JSONArray) mapObj.get("objectives");
			List<WvWObjective> objectives = new ArrayList<WvWObjective>(objectivesObj.size());

			for (Object objectiveO : objectivesObj) {
				JSONObject objectiveObj = (JSONObject) objectiveO;

				objectives.add(new WvWObjective(Long.toString((Long) objectiveObj.get("id")), (String) objectiveObj.get("owner_guild"), WvWSide.resolve((String) objectiveObj.get("owner"))));
			}

			JSONArray scores = (JSONArray) mapObj.get("scores");
			wvwMaps.add(new WvWMap(new Scores((Long) scores.get(0), (Long) scores.get(1), (Long) scores.get(2)), WvWMapType.resolve((String) mapObj.get("type")), objectives));
		}

		JSONArray scores = (JSONArray) obj.get("scores");
		return new WvWMatchDetail(new Scores((Long) scores.get(0), (Long) scores.get(1), (Long) scores.get(2)), (String) obj.get("match_id"), wvwMaps);
	}

}
