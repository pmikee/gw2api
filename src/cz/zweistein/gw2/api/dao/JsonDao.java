package cz.zweistein.gw2.api.dao;

import java.rmi.RemoteException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface JsonDao {

	public abstract JSONObject getItems() throws RemoteException;

	public abstract JSONObject getItemDetails(Long id, String lang) throws RemoteException;

	public abstract JSONObject getRecipes() throws RemoteException;

	public abstract JSONObject getRecipeDetails(Long id, String lang) throws RemoteException;

	public abstract JSONObject getWvWMatches() throws RemoteException;

	public abstract JSONObject getWvWMatchDetails(String id) throws RemoteException;

	public abstract JSONArray getWvWObjectiveNames(String lang) throws RemoteException;

	public abstract JSONObject getEvents(String eventId, String mapId, String worldId) throws RemoteException;

	public abstract JSONArray getEventNames(String lang) throws RemoteException;

	public abstract JSONArray getWorldNames(String lang) throws RemoteException;

	public abstract JSONArray getMapNames(String lang) throws RemoteException;

}