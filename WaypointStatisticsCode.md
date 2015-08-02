
```

package dummy;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cz.zweistein.gw2.api.GW2API;
import cz.zweistein.gw2.api.dto.MapAreaFloor;
import cz.zweistein.gw2.api.dto.MapFloor;
import cz.zweistein.gw2.api.dto.MapRegion;
import cz.zweistein.gw2.api.dto.PointOfInterest;
import cz.zweistein.gw2.api.dto.enums.PoIType;
import cz.zweistein.gw2.api.util.SupportedLanguage;

public class Main {

	public static void main(String[] args) throws RemoteException {

		GW2API api = new GW2API();

		MapFloor floor = api.getMapFloor(1L, 1L, SupportedLanguage.ENGLISH);

		Map<Long, MapRegion> regions = floor.getRegions();

		List<PointOfInterest> wps = new ArrayList<PointOfInterest>();

		for (Entry<Long, MapRegion> entry : regions.entrySet()) {
			for (Entry<Long, MapAreaFloor> map : entry.getValue().getMaps().entrySet()) {
				for (PointOfInterest poi : map.getValue().getPois()) {
					if (PoIType.WAYPOINT.equals(poi.getType())) {
						wps.add(poi);
					}
				}

			}
		}

		PointOfInterest a = wps.get(0);
		PointOfInterest b = wps.get(wps.size() - 1);

		for (PointOfInterest pointOfInterestA : wps) {
			for (PointOfInterest pointOfInterestB : wps) {

				if (distance(a, b) > distance(pointOfInterestA, pointOfInterestB)
						&& distance(pointOfInterestA, pointOfInterestB) > 0) {
					a = pointOfInterestA;
					b = pointOfInterestB;
				}

			}
		}

		System.out.println("Closest waypoints are " + a.getName() + " and " + b.getName() + ".");

		for (PointOfInterest pointOfInterestA : wps) {
			for (PointOfInterest pointOfInterestB : wps) {

				if (distance(a, b) < distance(pointOfInterestA, pointOfInterestB)
						&& distance(pointOfInterestA, pointOfInterestB) > 0) {
					a = pointOfInterestA;
					b = pointOfInterestB;
				}

			}
		}

		System.out.println("Mosts distant waypoints are " + a.getName() + " and " + b.getName() + ".");

		List<PointOfInterest> pois = new ArrayList<PointOfInterest>();

		for (Entry<Long, MapRegion> entry : regions.entrySet()) {
			for (Entry<Long, MapAreaFloor> map : entry.getValue().getMaps().entrySet()) {
				for (PointOfInterest poi : map.getValue().getPois()) {
					if (PoIType.POINT_OF_INTEREST.equals(poi.getType())) {
						pois.add(poi);
					}
				}

			}
		}

		double maxDistance = 0;

		for (PointOfInterest pointOfInterestA : wps) {
			double distance = Double.MAX_VALUE;
			for (PointOfInterest pointOfInterestB : pois) {
				if (distance > distance(pointOfInterestA, pointOfInterestB)
						&& distance(pointOfInterestA, pointOfInterestB) > 0) {
					distance = distance(pointOfInterestA, pointOfInterestB);
				}
			}

			if (maxDistance < distance) {
				maxDistance = distance;
				a = pointOfInterestA;
			}
		}

		System.out.println(a.getName() + " is most remote waypoint from points of interest.");

		List<PointOfInterest> all = new ArrayList<PointOfInterest>();

		for (Entry<Long, MapRegion> entry : regions.entrySet()) {
			for (Entry<Long, MapAreaFloor> map : entry.getValue().getMaps().entrySet()) {
				for (PointOfInterest poi : map.getValue().getPois()) {
					all.add(poi);
				}

			}
		}

		maxDistance = 0;

		for (PointOfInterest pointOfInterestA : wps) {
			double distance = Double.MAX_VALUE;
			for (PointOfInterest pointOfInterestB : all) {
				if (distance > distance(pointOfInterestA, pointOfInterestB)
						&& distance(pointOfInterestA, pointOfInterestB) > 0) {
					distance = distance(pointOfInterestA, pointOfInterestB);
				}
			}

			if (maxDistance < distance) {
				maxDistance = distance;
				a = pointOfInterestA;
			}
		}

		System.out.println(a.getName() + " is most remote waypoint.");

	}

	private static double distance(PointOfInterest a, PointOfInterest b) {

		if (a.equals(b)) {
			return 0;
		} else {
			double dx = a.getLocation().getX() - b.getLocation().getX();
			double dy = a.getLocation().getY() - b.getLocation().getY();

			return Math.sqrt(dx * dx + dy * dy);

		}

	}

}

```