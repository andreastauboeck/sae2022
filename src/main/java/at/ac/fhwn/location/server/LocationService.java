package at.ac.fhwn.location.server;

import at.ac.fhwn.nmea.SaePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class LocationService {

    Hashtable<Integer, List<SaePoint>> locations = new Hashtable<>();

    public void addLocation(int id, SaePoint location){
        if(locations.containsKey(id)){
            List<SaePoint> userLocations = locations.get(id);
            userLocations.add(0,location);
        }else {
            List<SaePoint> userLocations = new ArrayList<>();
            userLocations.add(location);
            locations.put(id,userLocations);
        }
    }

    public SaePoint getLocation(int id, int index){
        return locations.get(id).get(index);
    }

    public List<SaePoint> getLocations(int id){
        return locations.get(id);
    }

    public Hashtable<Integer, List<SaePoint>> getAllLocations(){
        return locations;
    }
}
