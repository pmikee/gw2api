import java.rmi.RemoteException;
import java.util.List;

import com.guildwars2.api.GW2API;


public class UseGW2API {
	
	public static void main(String[] args) throws RemoteException {
		
		GW2API api = new GW2API();

		List<Long> recipes = api.getItems();
		for (Long id : recipes) {
			System.out.println(api.getItemDetails(id, null));
		}
		
	}

}
