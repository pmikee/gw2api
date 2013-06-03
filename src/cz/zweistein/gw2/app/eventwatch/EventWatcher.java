package cz.zweistein.gw2.app.eventwatch;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cz.zweistein.gw2.api.GW2API;
import cz.zweistein.gw2.api.dto.Event;
import cz.zweistein.gw2.api.util.SupportedLanguage;
import cz.zweistein.gw2.app.eventwatch.gui.EventDialog;

public class EventWatcher {

	public static void main(String[] args) throws RemoteException {

		GW2API api = new GW2API();

		SupportedLanguage language = SupportedLanguage.resolve(Locale.getDefault().getLanguage());

		Map<String, String> eventNames = api.getEventNames(language);
		Map<Long, String> worldNames = api.getWorldNames(language);

		EventDialog ed = new EventDialog(eventNames, worldNames);

		while (true) {

			List<Event> eventState = api.getEvents(ed.getSelectedEvent(), null, ed.getSelectedWorld());

			if (eventState.size() > 0) {
				ed.setEventState(eventState.get(0).getEventState());
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}

		}
	}

}
