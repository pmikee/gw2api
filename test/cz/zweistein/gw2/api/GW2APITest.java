package cz.zweistein.gw2.api;

import java.rmi.RemoteException;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import cz.zweistein.gw2.api.util.Realm;

@RunWith(JUnit4.class)
public class GW2APITest {

	@Test
	public void getItemChatCode() {

		try {
			GW2API api = new GW2API();

			Assert.assertEquals("[&AgEEkAAA]", api.getItemChatCode(36868l));

			Assert.assertEquals("[&AgEAAAAA]", api.getItemChatCode(null));

		} catch (RemoteException e) {
			Assert.fail(e.toString());
		}

	}

	@Test
	public void getRealm() {

		try {
			GW2API api = new GW2API();

			Assert.assertEquals(Realm.EU, api.getRealm("2001"));

			Assert.assertEquals(Realm.NA, api.getRealm("1013"));

			Assert.assertEquals(Realm.UNKNOWN, api.getRealm("0013"));

			Assert.assertEquals(Realm.UNKNOWN, api.getRealm(""));

			Assert.assertEquals(Realm.UNKNOWN, api.getRealm(null));

		} catch (RemoteException e) {
			Assert.fail(e.toString());
		}

	}

}
