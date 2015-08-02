API interface in java for guild wars 2 game

https://gw2api.googlecode.com/svn/trunk/dist/gw2api.jar

Sample of use:

```
		GW2API api = new GW2API();

		List<Long> items = api.getItems();
		for (Long id : items) {
			api.getItemDetails(id, null).getName();
		}
		
```


---


Current state:

  * Several flags and types are still unknown.
  * basic JSON API is fully functional as well as Java object translation.
  * Small refactor is on order


---


How to use basic access:

```
		OnlineJsonDao apiJSON = new OnlineJsonDao();
		JSONArray names = apiJSON.getEventNames(null);
```

Normal API usage:

```
		GW2API api = new GW2API();

		List<Long> items = api.getItems();
		for (Long id : items) {
			api.getItemDetails(id, SupportedLanguage.FRENCH.getCode()).getName();
		}
		
```

Offline API usage:

Put file from https://forum-en.guildwars2.com/forum/community/api/Data-dump-All-recipes-and-created-items/first#post2091313
  * recipe\_created\_items.json
  * recipe\_details.json
Into root folder and then:

```
		GW2API api = new GW2API();
		api.setDao(new OfflineJsonDao());
		
		List<Long> items = api.getRecipes();
		for (Long id : items) {
			Recipe detail = api.getRecipeDetails(id, null);
			System.out.println(detail);
		}
```