package cz.zweistein.gw2.api.util;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.junit.Assert;

@RunWith(JUnit4.class)
public class UtilitiesTest {

	@Test
	public void buildQuerryString() {

		try {
			Utilities.buildQuerryString(null, null);
			Assert.fail("action is null");
		} catch (Exception e) {
		}

		Assert.assertEquals("https://api.guildwars2.com/v1/", Utilities.buildQuerryString("", null));

		Assert.assertEquals("https://api.guildwars2.com/v1/test.json", Utilities.buildQuerryString("test.json", null));

		Assert.assertEquals("https://api.guildwars2.com/v1/test.json", Utilities.buildQuerryString("test.json", new HashMap<String, Object>()));

		HashMap<String, Object> param = new HashMap<String, Object>();

		param.put("stringParam", "string");

		Assert.assertEquals("https://api.guildwars2.com/v1/test.json?stringParam=string", Utilities.buildQuerryString("test.json", param));

		param.put("longParam", 1234L);

		Assert.assertEquals("https://api.guildwars2.com/v1/test.json?stringParam=string&longParam=1234", Utilities.buildQuerryString("test.json", param));

		param.put("nullParam", null);

		Assert.assertEquals("https://api.guildwars2.com/v1/test.json?nullParam&stringParam=string&longParam=1234", Utilities.buildQuerryString("test.json", param));

	}

	@Test
	public void buildQuerryURL() throws MalformedURLException {

		Assert.assertEquals("https://api.guildwars2.com/v1/test.json", Utilities.buildQuerryURL("test.json", new HashMap<String, Object>()).toExternalForm());

	}

}
