package cz.zweistein.gw2.api.dao;

import java.rmi.RemoteException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OfflineJsonDao implements JsonDao {

	@Override
	public JSONObject getItems() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getItemDetails(Long id, String lang) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getRecipes() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getRecipeDetails(Long id, String lang) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getWvWMatches() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getWvWMatchDetails(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getWvWObjectiveNames(String lang) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getEvents(String eventId, String mapId, String worldId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getEventNames(String lang) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getWorldName(String lang) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getMapNames(String lang) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
