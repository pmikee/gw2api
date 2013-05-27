package cz.zweistein.gw2.api.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OfflineJsonDao implements JsonDao {
	
	private JSONObject recipeDetails;
	private JSONObject items;

	public OfflineJsonDao() throws RemoteException {
		try {
			recipeDetails = parseJSONFile("recipe_details.json");
			items = parseJSONFile("recipe_created_items.json");
		} catch (Exception e) {
			throw new RemoteException(e.toString());
		}
	}

	private JSONObject parseJSONFile(String fileName) throws FileNotFoundException, IOException, ParseException {
		return (JSONObject) new JSONParser().parse(new FileReader(new File(fileName)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getItems() throws RemoteException {
		JSONObject obj = new JSONObject();
		Set<String> ids = items.keySet();
		List<Long> result = new ArrayList<Long>(ids.size());
		for (String object : ids) {
			result.add(new Long(object));
		}
		obj.put("items", result);
		return obj;
	}

	@Override
	public JSONObject getItemDetails(Long id, String lang) throws RemoteException {
		return (JSONObject) items.get(id.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getRecipes() throws RemoteException {
		JSONObject obj = new JSONObject();
		Set<String> ids = recipeDetails.keySet();
		List<Long> result = new ArrayList<Long>(ids.size());
		for (String object : ids) {
			result.add(new Long(object));
		}
		obj.put("recipes", result);
		return obj;
	}

	@Override
	public JSONObject getRecipeDetails(Long id, String lang) throws RemoteException {
		return (JSONObject) recipeDetails.get(id.toString());
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
