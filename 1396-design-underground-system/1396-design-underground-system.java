import java.util.HashMap;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        long totalTime;
        int count;

        Route(long totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    HashMap<Integer, CheckIn> checkIns;
    HashMap<String, Route> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        String route = checkIn.station + "#" + stationName;
        int travelTime = t - checkIn.time;

        if (routes.containsKey(route)) {
            Route r = routes.get(route);
            r.totalTime += travelTime;
            r.count++;
        } else {
            routes.put(route, new Route(travelTime, 1));
        }

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;

        Route r = routes.get(route);

        return (double) r.totalTime / r.count;
    }
}