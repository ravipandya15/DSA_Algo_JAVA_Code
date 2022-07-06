package HashMap;

import java.util.HashMap;
import javafx.util.Pair;

// class Pair
// {
//     String first;
//     int second;

//     Pair(){}
//     Pair(String first, int second)
//     {
//         this.first = first;
//         this.second = second;
//     }
// }

class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> checkInMap;
    HashMap<String, Pair<Double, Integer>> checkOutMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        checkOutMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = checkInMap.get(id);
        String key = pair.getKey() + "_" + stationName;
        int value = t - pair.getValue();

        Pair<Double, Integer> route = checkOutMap.getOrDefault(key, new Pair<>(0.0, 0));

        checkOutMap.put(key, new Pair<>(route.getKey() + value, route.getValue() + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Integer> route = checkOutMap.get(startStation + "_" + endStation);
        return route.getKey() / route.getValue();
    }
}

public class Design_Underground_System_1396 {
    
}
