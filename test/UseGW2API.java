import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import cz.zweistein.gw2.api.GW2API;


public class UseGW2API {
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		
		GW2API api = new GW2API();
		
//		api.setDao(new OfflineJsonDao());
//		
//		List<Long> items = api.getRecipes();
//		for (Long id : items) {
//			Recipe detail = api.getRecipeDetails(id, null);
//			System.out.println(detail);
//		}

		List<Long> items = api.getItems();
		for (Long id : items) {
			Thread.sleep(500);
			System.out.print(id + " ");
			api.getItemDetails(id, null);
		}
		
	}

}
