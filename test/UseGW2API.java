import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

import cz.zweistein.gw2.api.GW2API;


public class UseGW2API {
	
	public static void main(String[] args) throws RemoteException, InterruptedException {
		
		GW2API api = new GW2API();
		
		// 904
//		List<Long> items = api.getRecipes();
//		System.err.println(items.size());
//		int i = 0;
//		for (Long id : items) {
//			System.out.print(id + " ("+ i++ +") ");
//			api.getRecipeDetails(id, null);
//		}

		List<Long> items = api.getItems();
		Collections.shuffle(items);
		for (Long id : items) {
			Thread.sleep(500);
			System.out.print(id + " ");
			api.getItemDetails(id, null);
		}
		
	}

}
