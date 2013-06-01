package cz.zweistein.gw2.api;

//The MIT License (MIT)
//
//Copyright (c) <2013> <Petr Prokop>
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import cz.zweistein.gw2.api.dao.JsonDao;
import cz.zweistein.gw2.api.dao.OnlineJsonDao;
import cz.zweistein.gw2.api.dto.Color;
import cz.zweistein.gw2.api.dto.Event;
import cz.zweistein.gw2.api.dto.Guild;
import cz.zweistein.gw2.api.dto.GuildEmblem;
import cz.zweistein.gw2.api.dto.Recipe;
import cz.zweistein.gw2.api.dto.WvWMatch;
import cz.zweistein.gw2.api.dto.WvWMatchDetail;
import cz.zweistein.gw2.api.dto.enums.EventState;
import cz.zweistein.gw2.api.dto.items.Item;
import cz.zweistein.gw2.api.transformer.JSONToJavaTransformer;
import cz.zweistein.gw2.api.util.Realm;

public class GW2API {

	private JsonDao dao;
	private JSONToJavaTransformer transformer;

	public GW2API() throws RemoteException {
		this.dao = new OnlineJsonDao();
		this.transformer = new JSONToJavaTransformer();
	}

	public void setDao(JsonDao dao) {
		this.dao = dao;
	}

	public void setTransformer(JSONToJavaTransformer transformer) {
		this.transformer = transformer;
	}

	/**
	 * Return list of discovered item_ids
	 * 
	 * @return
	 * @throws RemoteException
	 */
	@SuppressWarnings("unchecked")
	public List<Long> getItems() throws RemoteException {
		JSONObject obj = dao.getItems();
		return (List<Long>) obj.get("items");
	}

	@SuppressWarnings("unchecked")
	public List<Long> getRecipes() throws RemoteException {
		JSONObject obj = dao.getRecipes();
		return (List<Long>) obj.get("recipes");
	}

	/**
	 * Return realm of giver world of wvw match
	 * 
	 * @param worldId
	 * @return
	 */
	public Realm getRealm(Long worldId) {
		if (worldId == null) {
			return Realm.UNKNOWN;
		} else {
			String worldString = Long.toString(worldId);
			if (worldString.startsWith("1")) {
				return Realm.NA;
			} else if (worldString.startsWith("2")) {
				return Realm.EU;
			} else {
				return Realm.UNKNOWN;
			}
		}
	}

	public String getItemChatCode(Long itemId) {
		StringBuilder result = new StringBuilder();

		result.append("[&");

		byte[] bytes = new byte[6];

		bytes[0] = 0x02;
		bytes[1] = 0x01;

		if (itemId != null) {
			bytes[2] = (byte) (itemId % 256);
			bytes[3] = (byte) (itemId / 256);
		}

		bytes[4] = 0x00;
		bytes[5] = 0x00;

		result.append(Base64.encodeBase64String(bytes));

		result.append("]");

		return result.toString();
	}

	public Map<String, String> getEventNames(String lang) throws RemoteException {
		JSONArray obj = dao.getEventNames(lang);

		Map<String, String> eventNames = new HashMap<String, String>();

		for (Object object : obj) {
			JSONObject eventName = (JSONObject) object;
			eventNames.put((String) eventName.get("id"), (String) eventName.get("name"));

		}

		return eventNames;
	}

	public Map<Long, String> getWorldNames(String lang) throws RemoteException {
		JSONArray obj = dao.getWorldNames(lang);

		Map<Long, String> worldNames = new HashMap<Long, String>();

		for (Object object : obj) {
			JSONObject worldName = (JSONObject) object;
			worldNames.put(Long.parseLong((String) worldName.get("id")), (String) worldName.get("name"));

		}

		return worldNames;
	}

	public Map<Long, String> getMapNames(String lang) throws RemoteException {
		JSONArray obj = dao.getMapNames(lang);

		Map<Long, String> mapNames = new HashMap<Long, String>();

		for (Object object : obj) {
			JSONObject mapName = (JSONObject) object;
			mapNames.put(Long.parseLong((String) mapName.get("id")), (String) mapName.get("name"));

		}

		return mapNames;
	}

	public Map<Long, String> getWvWObjectiveNames(String lang) throws RemoteException {
		JSONArray obj = dao.getWvWObjectiveNames(lang);

		Map<Long, String> mapNames = new HashMap<Long, String>();

		for (Object object : obj) {
			JSONObject mapName = (JSONObject) object;
			mapNames.put(Long.parseLong((String) mapName.get("id")), (String) mapName.get("name"));

		}

		return mapNames;
	}

	public List<Event> getEvents(String eventId, Long mapId, Long worldId) throws RemoteException {
		JSONObject obj = dao.getEvents(eventId, mapId, worldId);
		JSONArray eventObjects = (JSONArray) obj.get("events");

		List<Event> events = new ArrayList<Event>(eventObjects.size());

		for (Object object : eventObjects) {
			JSONObject eventObject = (JSONObject) object;

			events.add(new Event((String) eventObject.get("event_id"), (Long) eventObject.get("map_id"), (Long) eventObject.get("world_id"), EventState.resolve((String) eventObject.get("state"))));
		}

		return events;
	}

	public List<WvWMatch> getWvWMatches() throws RemoteException {
		JSONObject obj = dao.getWvWMatches();
		
	System.out.println(obj);	
		
		JSONArray matchObjects = (JSONArray) obj.get("wvw_matches");

		List<WvWMatch> matches = new ArrayList<WvWMatch>(matchObjects.size());

		for (Object object : matchObjects) {
			JSONObject matchObject = (JSONObject) object;
			Date startDate = DatatypeConverter.parseDateTime((String)matchObject.get("start_time")).getTime();
			Date endDate = DatatypeConverter.parseDateTime((String)matchObject.get("end_time")).getTime();;
			matches.add(new WvWMatch((String) matchObject.get("wvw_match_id"), (Long) matchObject.get("blue_world_id"), (Long) matchObject.get("red_world_id"), (Long) matchObject.get("green_world_id"), startDate, endDate));

		}

		return matches;
	}

	public WvWMatchDetail getWvWMatchDetails(String id) throws RemoteException {
		JSONObject obj = dao.getWvWMatchDetails(id);

		return transformer.transformWvWMatchDetails(obj);
	}

	public Recipe getRecipeDetails(Long id, String lang) throws RemoteException {
		JSONObject obj = dao.getRecipeDetails(id, lang);

		return transformer.transfromRecipe(obj);
	}

	public Item getItemDetails(Long id, String lang) throws RemoteException {
		JSONObject obj = dao.getItemDetails(id, lang);

		return transformer.transfromItem(obj);
	}
	
	public Guild getGuildDetails(String guildID, String guildName) throws RemoteException {
		JSONObject obj = dao.getGuildDetails(guildID, guildName);
		
		String emblemString = (String)obj.get("emblem");
		String[] emblemStringArray = emblemString.split(",");
		
		GuildEmblem emblem = new GuildEmblem(Long.valueOf(emblemStringArray[0]), Long.valueOf(emblemStringArray[1]), Long.valueOf(emblemStringArray[2]), Long.valueOf(emblemStringArray[3]), Long.valueOf(emblemStringArray[4]), Long.valueOf(emblemStringArray[5]));
		return new Guild((String)obj.get("guild_id"), (String)obj.get("tag"), (String)obj.get("guild_name"), emblem);
	}
	
	public Long getBuild() throws RemoteException {
		JSONObject obj = dao.getBuild();
		
		return (Long)obj.get("build_id");
	}
	
	public Map<Long, Color> getColors() throws RemoteException {
		JSONObject obj = dao.getColors();
		
		JSONObject colorsObj = (JSONObject) obj.get("colors");
		
		Map<Long, Color> colors= new HashMap<Long, Color>();
		for (Object key : colorsObj.keySet()) {
			colors.put(Long.valueOf((String) key), transformer.transformColor((JSONObject)colorsObj.get(key)));
		}

		return colors;
	}

}
