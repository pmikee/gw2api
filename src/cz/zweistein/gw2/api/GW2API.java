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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import cz.zweistein.gw2.api.dao.JsonDao;
import cz.zweistein.gw2.api.dao.OnlineJSONDAO;
import cz.zweistein.gw2.api.dto.Event;
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
		this.dao = new OnlineJSONDAO();
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

	public static Realm getRealm(String worldId) {
		assert (worldId != null);
		if (worldId.startsWith("1")) {
			return Realm.NA;
		} else if (worldId.startsWith("2")) {
			return Realm.EU;
		} else {
			return Realm.UNKNOWN;
		}
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

	public Map<String, String> getWorldNames(String lang) throws RemoteException {
		JSONArray obj = dao.getWorldName(lang);

		Map<String, String> worldNames = new HashMap<String, String>();

		for (Object object : obj) {
			JSONObject worldName = (JSONObject) object;
			worldNames.put((String) worldName.get("id"), (String) worldName.get("name"));

		}

		return worldNames;
	}

	public Map<String, String> getMapNames(String lang) throws RemoteException {
		JSONArray obj = dao.getMapNames(lang);

		Map<String, String> mapNames = new HashMap<String, String>();

		for (Object object : obj) {
			JSONObject mapName = (JSONObject) object;
			mapNames.put((String) mapName.get("id"), (String) mapName.get("name"));

		}

		return mapNames;
	}

	public Map<String, String> getWvWObjectiveNames(String lang) throws RemoteException {
		JSONArray obj = dao.getWvWObjectiveNames(lang);

		Map<String, String> mapNames = new HashMap<String, String>();

		for (Object object : obj) {
			JSONObject mapName = (JSONObject) object;
			mapNames.put((String) mapName.get("id"), (String) mapName.get("name"));

		}

		return mapNames;
	}

	public List<Event> getEvents(String eventId, String mapId, String worldId) throws RemoteException {
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
		JSONArray matchObjects = (JSONArray) obj.get("wvw_matches");

		List<WvWMatch> matches = new ArrayList<WvWMatch>(matchObjects.size());

		for (Object object : matchObjects) {
			JSONObject matchObject = (JSONObject) object;

			matches.add(new WvWMatch((String) matchObject.get("wvw_match_id"), Long.toString((Long) matchObject.get("blue_world_id")), Long.toString((Long) matchObject.get("red_world_id")), Long.toString((Long) matchObject.get("green_world_id"))));

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
		
		System.out.println(obj);
		
		return transformer.transfromItem(obj);
	}

}
