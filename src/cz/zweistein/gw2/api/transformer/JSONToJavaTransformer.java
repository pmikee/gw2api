package cz.zweistein.gw2.api.transformer;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import cz.zweistein.gw2.api.dto.Color;
import cz.zweistein.gw2.api.dto.ColorHue;
import cz.zweistein.gw2.api.dto.Guild;
import cz.zweistein.gw2.api.dto.GuildEmblem;
import cz.zweistein.gw2.api.dto.Ingredient;
import cz.zweistein.gw2.api.dto.Recipe;
import cz.zweistein.gw2.api.dto.Scores;
import cz.zweistein.gw2.api.dto.WvWMap;
import cz.zweistein.gw2.api.dto.WvWMatchDetail;
import cz.zweistein.gw2.api.dto.WvWObjective;
import cz.zweistein.gw2.api.dto.enums.AttributeType;
import cz.zweistein.gw2.api.dto.enums.BagModifier;
import cz.zweistein.gw2.api.dto.enums.ConsumableType;
import cz.zweistein.gw2.api.dto.enums.ContainerType;
import cz.zweistein.gw2.api.dto.enums.CraftingDiscipline;
import cz.zweistein.gw2.api.dto.enums.CraftingFlag;
import cz.zweistein.gw2.api.dto.enums.DamageType;
import cz.zweistein.gw2.api.dto.enums.GameType;
import cz.zweistein.gw2.api.dto.enums.GatheringType;
import cz.zweistein.gw2.api.dto.enums.GizmoType;
import cz.zweistein.gw2.api.dto.enums.GuildEmblemFlag;
import cz.zweistein.gw2.api.dto.enums.InfusionSlotFlag;
import cz.zweistein.gw2.api.dto.enums.ItemClass;
import cz.zweistein.gw2.api.dto.enums.ItemFlag;
import cz.zweistein.gw2.api.dto.enums.ItemType;
import cz.zweistein.gw2.api.dto.enums.Rarity;
import cz.zweistein.gw2.api.dto.enums.Restriction;
import cz.zweistein.gw2.api.dto.enums.ToolType;
import cz.zweistein.gw2.api.dto.enums.TrinketType;
import cz.zweistein.gw2.api.dto.enums.UpgradeComponentFlag;
import cz.zweistein.gw2.api.dto.enums.UpgradeComponentType;
import cz.zweistein.gw2.api.dto.enums.WeightClass;
import cz.zweistein.gw2.api.dto.enums.WvWMapType;
import cz.zweistein.gw2.api.dto.enums.WvWSide;
import cz.zweistein.gw2.api.dto.items.Armor;
import cz.zweistein.gw2.api.dto.items.Attribute;
import cz.zweistein.gw2.api.dto.items.Back;
import cz.zweistein.gw2.api.dto.items.Bag;
import cz.zweistein.gw2.api.dto.items.Buff;
import cz.zweistein.gw2.api.dto.items.Consumable;
import cz.zweistein.gw2.api.dto.items.Container;
import cz.zweistein.gw2.api.dto.items.Gathering;
import cz.zweistein.gw2.api.dto.items.Gizmo;
import cz.zweistein.gw2.api.dto.items.InfixUpgrade;
import cz.zweistein.gw2.api.dto.items.InfusionSlot;
import cz.zweistein.gw2.api.dto.items.Item;
import cz.zweistein.gw2.api.dto.items.Tool;
import cz.zweistein.gw2.api.dto.items.Trinket;
import cz.zweistein.gw2.api.dto.items.UpgradeComponent;
import cz.zweistein.gw2.api.dto.items.Weapon;
import cz.zweistein.gw2.api.util.SupportedLanguage;

public class JSONToJavaTransformer {

	public String translateLang(SupportedLanguage lang) {
		if (lang == null) {
			return null;
		} else {
			return lang.getCode();
		}
	}
	
	private Long parseGracefullyLong(JSONObject obj, String key) {
		Long result = null;

		Object value = obj.get(key);

		if (value != null && !"".equals(value)) {
			result = Long.parseLong((String) value);
		}

		return result;
	}

	private InfixUpgrade parseInfixUpgrade(JSONObject obj) {
		InfixUpgrade infixUpgrade = null;
		if (obj.get("infix_upgrade") != null) {
			JSONObject infixObj = (JSONObject) obj.get("infix_upgrade");
			JSONArray attributesObj = (JSONArray) infixObj.get("attributes");
			List<Attribute> attributes = new ArrayList<Attribute>(attributesObj.size());
			for (Object attributeO : attributesObj) {
				JSONObject attributeObj = (JSONObject) attributeO;

				attributes.add(new Attribute(AttributeType.resolve((String) attributeObj.get("attribute")), Long.parseLong((String) attributeObj
						.get("modifier"))));
			}

			Buff buff = null;
			if (infixObj.get("buff") != null) {
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

			infusionSlots.add(new InfusionSlot(infusionFlags, parseGracefullyLong(infusionSlotObj, "item_id")));

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

			armor = new Armor(ItemType.resolve((String) armorObj.get("type")), WeightClass.resolve((String) armorObj.get("weight_class")),
					Long.parseLong((String) armorObj.get("defense")), infusionSlots, infixUpgrade);
		}

		Weapon weapon = null;
		if (ItemClass.WEAPON.equals(itemClass)) {
			JSONObject weaponObj = (JSONObject) obj.get("weapon");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(weaponObj);
			List<InfusionSlot> infusionSlots = parseInfusionSlots(weaponObj);

			weapon = new Weapon(ItemType.resolve((String) weaponObj.get("type")), DamageType.resolve((String) weaponObj.get("damage_type")),
					Long.parseLong((String) weaponObj.get("min_power")), Long.parseLong((String) weaponObj.get("max_power")), Long.parseLong((String) weaponObj
							.get("defense")), infusionSlots, infixUpgrade);
		}

		Trinket trinket = null;
		if (ItemClass.TRINKET.equals(itemClass)) {
			JSONObject trinketObj = (JSONObject) obj.get("trinket");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(trinketObj);
			List<InfusionSlot> infusionSlots = parseInfusionSlots(trinketObj);

			trinket = new Trinket(TrinketType.resolve((String) trinketObj.get("type")), infusionSlots, infixUpgrade, parseGracefullyLong(trinketObj,
					"suffix_item_id"));
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

			bag = new Bag(Long.parseLong((String) bagObj.get("size")), bagModifiers);
		}

		Container container = null;
		if (ItemClass.CONTAINER.equals(itemClass)) {
			JSONObject containerObj = (JSONObject) obj.get("container");

			container = new Container(ContainerType.resolve((String) containerObj.get("type")));
		}

		Consumable consumable = null;
		if (ItemClass.CONSUMABLE.equals(itemClass)) {
			JSONObject consumableObj = (JSONObject) obj.get("consumable");

			consumable = new Consumable(ConsumableType.resolve((String) consumableObj.get("type")), (String) consumableObj.get("description"),
					parseGracefullyLong(consumableObj, "duration_ms"));
		}

		UpgradeComponent upgradeComponent = null;
		if (ItemClass.UPGRADE_COMPONENT.equals(itemClass)) {
			JSONObject upgradeComponentObj = (JSONObject) obj.get("upgrade_component");

			InfixUpgrade infixUpgrade = parseInfixUpgrade(upgradeComponentObj);

			List<UpgradeComponentFlag> upgradeComponentFlags = new ArrayList<UpgradeComponentFlag>();
			JSONArray upgradeComponentFlagsObj = (JSONArray) upgradeComponentObj.get("flags");

			for (Object flagO : upgradeComponentFlagsObj) {
				upgradeComponentFlags.add(UpgradeComponentFlag.resolve(((String) flagO)));
			}

			JSONArray infusionSlotFlagsObj = (JSONArray) upgradeComponentObj.get("infusion_upgrade_flags");
			List<InfusionSlotFlag> infusionSlotFlags = new ArrayList<InfusionSlotFlag>(infusionSlotFlagsObj.size());
			for (Object infusionSlotFlagO : infusionSlotFlagsObj) {
				infusionSlotFlags.add(InfusionSlotFlag.resolve(((String) infusionSlotFlagO)));
			}

			upgradeComponent = new UpgradeComponent(UpgradeComponentType.resolve((String) upgradeComponentObj.get("type")), upgradeComponentFlags,
					infixUpgrade, (String) upgradeComponentObj.get("suffix"), infusionSlotFlags);
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

		Tool tool = null;
		if (ItemClass.TOOL.equals(itemClass)) {
			JSONObject toolObj = (JSONObject) obj.get("tool");

			tool = new Tool(ToolType.resolve((String) toolObj.get("type")), Long.parseLong((String) toolObj.get("charges")));
		}

		return new Item(Long.parseLong((String) obj.get("item_id")), (String) obj.get("name"), (String) obj.get("description"), Long.parseLong((String) obj
				.get("level")), Rarity.resolve((String) obj.get("rarity")), Long.parseLong((String) obj.get("vendor_value")), gameTypes, flags, restrictions,
				parseGracefullyLong(obj, "suffix_item_id"), itemClass, armor, weapon, bag, container, consumable, trinket, upgradeComponent, back, gathering,
				gizmo, tool);

	}

	public Recipe transfromRecipe(JSONObject obj) {
		JSONArray ingredientsObj = (JSONArray) obj.get("ingredients");

		List<Ingredient> ingredients = new ArrayList<Ingredient>(ingredientsObj.size());

		for (Object ingredientO : ingredientsObj) {
			JSONObject ingredientObj = (JSONObject) ingredientO;

			ingredients.add(new Ingredient(Long.parseLong((String) ingredientObj.get("count")), (Long.parseLong((String) ingredientObj.get("item_id")))));
		}

		JSONArray flagsObj = (JSONArray) obj.get("flags");
		List<CraftingFlag> flags = new ArrayList<CraftingFlag>(flagsObj.size());
		for (Object flagO : flagsObj) {
			flags.add(CraftingFlag.resolve((String) flagO));
		}

		JSONArray disciplinesObj = (JSONArray) obj.get("disciplines");
		List<CraftingDiscipline> craftingDisciplines = new ArrayList<CraftingDiscipline>(disciplinesObj.size());
		for (Object disciplineO : disciplinesObj) {
			craftingDisciplines.add(CraftingDiscipline.resolve((String) disciplineO));
		}

		return new Recipe(Long.parseLong((String) obj.get("recipe_id")), ingredients, Long.parseLong((String) obj.get("min_rating")),
				Long.parseLong((String) obj.get("time_to_craft_ms")), Long.parseLong((String) obj.get("output_item_id")), Long.parseLong((String) obj
						.get("output_item_count")), ItemType.resolve((String) obj.get("type")), craftingDisciplines, flags);
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

				objectives.add(new WvWObjective((Long) objectiveObj.get("id"), (String) objectiveObj.get("owner_guild"), WvWSide.resolve((String) objectiveObj
						.get("owner"))));
			}

			JSONArray scores = (JSONArray) mapObj.get("scores");
			wvwMaps.add(new WvWMap(new Scores((Long) scores.get(0), (Long) scores.get(1), (Long) scores.get(2)),
					WvWMapType.resolve((String) mapObj.get("type")), objectives));
		}

		JSONArray scores = (JSONArray) obj.get("scores");
		return new WvWMatchDetail(new Scores((Long) scores.get(0), (Long) scores.get(1), (Long) scores.get(2)), (String) obj.get("match_id"), wvwMaps);
	}

	public Color transformColor(JSONObject colorsObj) {
		ColorHue defaultColor = transfromColorHue((JSONObject) colorsObj.get("default"));
		ColorHue metalColor = transfromColorHue((JSONObject) colorsObj.get("metal"));
		ColorHue clothColor = transfromColorHue((JSONObject) colorsObj.get("cloth"));
		ColorHue leatherColor = transfromColorHue((JSONObject) colorsObj.get("leather"));
		return new Color((String) colorsObj.get("name"), defaultColor, metalColor, clothColor, leatherColor);
	}

	private ColorHue transfromColorHue(JSONObject colorHueObj) {
		if (colorHueObj != null) {
			return new ColorHue(
				parseDouble(colorHueObj.get("brightness")),
				parseDouble(colorHueObj.get("contrast")),
				parseDouble(colorHueObj.get("hue")),
				parseDouble(colorHueObj.get("saturation")),
				parseDouble(colorHueObj.get("lightness")));
		} else {
			return null;
		}
	}
	
	private Double parseDouble(Object obj) {
		if (obj instanceof Double) {
			return (Double) obj;
		} else if (obj instanceof Long) {
			return Double.valueOf(obj.toString());
		} else {
			throw new IllegalArgumentException(obj.toString());
		}
	}

	public Guild transfromGuildDetail(JSONObject obj) {
		JSONObject emblemObj = (JSONObject) obj.get("emblem");

		GuildEmblem emblem = null;
		if (emblemObj != null) {
			JSONArray flagsObj = (JSONArray) emblemObj.get("flags");
			List<GuildEmblemFlag> flags = new ArrayList<GuildEmblemFlag>(flagsObj.size());
			for (Object flagO : flagsObj) {
				flags.add(GuildEmblemFlag.resolve((String) flagO));
			}

			emblem = new GuildEmblem((Long) emblemObj.get("background_id"), (Long) emblemObj.get("foreground_id"), flags,
					(Long) emblemObj.get("foreground_primary_color_id"), (Long) emblemObj.get("foreground_secondary_color_id"),
					(Long) emblemObj.get("background_color_id"));
		}

		return new Guild((String) obj.get("guild_id"), (String) obj.get("tag"), (String) obj.get("guild_name"), emblem);
	}

}
