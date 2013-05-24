import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

import com.guildwars2.api.GW2API;


public class UseGW2API {
	
	public static void main(String[] args) throws RemoteException {
		
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
			System.out.print(id + " ");
			api.getItemDetails(id, null);
		}
		
	}

}
