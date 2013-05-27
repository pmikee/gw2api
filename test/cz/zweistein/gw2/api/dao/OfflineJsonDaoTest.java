package cz.zweistein.gw2.api.dao;

import java.rmi.RemoteException;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OfflineJsonDaoTest {

	@Test
	public void getRecipes() throws RemoteException {

		JsonDao dao = new OfflineJsonDao();

		Assert.assertNotNull(dao.getRecipes());

		Assert.assertTrue(dao.getRecipes().keySet().size() > 0);

		Assert.assertNotNull((((List<?>) (dao.getRecipes().get("recipes"))).get(0)));

	}

	@Test
	public void getRecipeDetails() throws RemoteException {

		JsonDao dao = new OfflineJsonDao();

		Long recipeId = (Long) (((List<?>) (dao.getRecipes().get("recipes"))).get(0));

		JSONObject recipe = dao.getRecipeDetails(recipeId, null);

		Assert.assertEquals(recipeId, Long.valueOf((String) recipe.get("recipe_id")));

	}

	@Test
	public void getItems() throws RemoteException {

		JsonDao dao = new OfflineJsonDao();

		Assert.assertNotNull(dao.getItems());

		Assert.assertTrue(dao.getItems().keySet().size() > 0);

		Assert.assertNotNull((((List<?>) (dao.getItems().get("items"))).get(0)));

	}

	@Test
	public void getItemDetails() throws RemoteException {

		JsonDao dao = new OfflineJsonDao();

		Long itemId = (Long) (((List<?>) (dao.getItems().get("items"))).get(0));

		JSONObject item = dao.getItemDetails(itemId, null);

		Assert.assertEquals(itemId, Long.valueOf((String) item.get("item_id")));

	}

}
