import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import cz.zweistein.gw2.api.GW2API;
import cz.zweistein.gw2.api.auth.OAuth2Client;
import cz.zweistein.gw2.api.dto.Recipe;
import cz.zweistein.gw2.api.dto.WvWMap;
import cz.zweistein.gw2.api.dto.WvWMatch;
import cz.zweistein.gw2.api.dto.WvWMatchDetail;
import cz.zweistein.gw2.api.dto.WvWObjective;
import cz.zweistein.gw2.api.util.SupportedLanguage;


public class UseGW2API {
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		
		GW2API api = new GW2API();
		
		System.out.println(api.getGuildDetails("B8DE9611-67DC-4A07-87AD-366F9A63C3EC", null));
		
//		System.out.println(api.getWvWMatches());
		
//		System.out.println(api.getColors());
		
//		System.out.println( api.getBuild());
		
//		OAuth2Client auth = new OAuth2Client();
//		
//		System.out.println(auth.getOAuth2Token());
		
//		List<WvWMatch> matches = api.getWvWMatches();
//		for (WvWMatch wvWMatch : matches) {
//			WvWMatchDetail matchDetail = api.getWvWMatchDetails(wvWMatch.getMatchId());
//
//			List<WvWMap> maps = matchDetail.getMaps();
//			for (WvWMap wvWMap : maps) {
//				List<WvWObjective> objectives = wvWMap.getObjectives();
//				for (WvWObjective wvWObjective : objectives) {
//					if (wvWObjective.getOwnerGuild() != null) {
//						System.out.println(api.getGuildDetails(wvWObjective.getOwnerGuild(), null));
//					}
//				}
//			}
//		}

//		System.out.println(api.getWorldNames(SupportedLanguage.FRENCH.getCode()));
//		System.out.println(api.getMapNames(SupportedLanguage.SPANNISH.getCode()));
//		System.out.println(api.getWvWObjectiveNames(null));
		
//		api.setDao(new OfflineJsonDao());
		
//		List<Long> items = api.getRecipes();
//		for (Long id : items) {
//			Recipe detail = api.getRecipeDetails(id, null);
//			System.out.println(detail);
//		}
	
		
//		List<Long> items = api.getItems();
//		for (Long id : items) {
//			api.getItemDetails(id, null);
//			System.out.println(id + " " + api.getItemDetails(id, null));
//		}
		
	}

}