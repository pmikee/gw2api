package cz.zweistein.gw2.api.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OfflineJsonDao implements JsonDao {

	private Map<Long, JSONObject> recipes;
	private Map<Long, JSONObject> items;

	public OfflineJsonDao() throws RemoteException {
		try {
			recipes = parseJSONFile("recipes.json", "recipe_id");
			items = parseJSONFile("items.json", "item_id");
		} catch (Exception e) {
			throw new RemoteException(e.toString());
		}
	}

	private Map<Long, JSONObject> parseJSONFile(String fileName, String idKey) throws FileNotFoundException, IOException, ParseException {

		Map<Long, JSONObject> result = new HashMap<Long, JSONObject>();

		JSONArray entries = (JSONArray) new JSONParser().parse(new InputStreamReader(new FileInputStream(new File(fileName)), Charset.forName("UTF16")));
		for (Object object : entries) {
			JSONObject obj = (JSONObject) object;
			result.put(Long.parseLong((String) obj.get(idKey)), obj);
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getItems() throws RemoteException {
		JSONObject obj = new JSONObject();
		Set<Long> ids = items.keySet();
		List<Long> result = new ArrayList<Long>(ids.size());
		for (Long object : ids) {
			result.add(new Long(object));
		}
		obj.put("items", result);
		return obj;
	}

	@Override
	public JSONObject getItemDetails(Long id, String lang) throws RemoteException {
		return items.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getRecipes() throws RemoteException {
		JSONObject obj = new JSONObject();
		Set<Long> ids = recipes.keySet();
		List<Long> result = new ArrayList<Long>(ids.size());
		for (Long object : ids) {
			result.add(new Long(object));
		}
		obj.put("recipes", result);
		return obj;
	}

	@Override
	public JSONObject getRecipeDetails(Long id, String lang) throws RemoteException {
		return recipes.get(id);
	}

	@Override
	public JSONObject getWvWMatches() throws RemoteException {
		throw new UnsupportedOperationException();
	}

	@Override
	public JSONObject getWvWMatchDetails(String id) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	@Override
	public JSONArray getWvWObjectiveNames(String lang) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	@Override
	public JSONObject getEvents(String eventId, String mapId, String worldId) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	@Override
	public JSONArray getEventNames(String lang) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	@Override
	public JSONArray getWorldName(String lang) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	@Override
	public JSONArray getMapNames(String lang) throws RemoteException {
		throw new UnsupportedOperationException();
	}

}
