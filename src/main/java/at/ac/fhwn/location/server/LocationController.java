package at.ac.fhwn.location.server;

import at.ac.fhwn.nmea.SaePoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.List;

@RestController
public class LocationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("getAllLocations")
    public Hashtable<Integer, List<SaePoint>> getAllLocations() {

        return locationService.getAllLocations();
    }

    @GetMapping("getLocations")
    public List<SaePoint> getLocations(
            @RequestParam(name = "id") int id
    ) {
        return locationService.getLocations(id);
    }

    @GetMapping("getLocation")
    public SaePoint getLocation(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "index", required = false) Integer index
    ) {
        if (index == null) {
            return locationService.getLocation(id, 0);
        }
        return locationService.getLocation(id, index);
    }

    @GetMapping("setLocation")
    public SaePoint setLocation(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "lat") double latitude,
            @RequestParam(name = "lon") double longitude,
            @RequestParam(name = "time") String time,
            @RequestParam(name = "satNr") int satNr,
            @RequestParam(name = "fixQ") int fixQ) {
        SaePoint saePoint = new SaePoint(time, latitude, longitude, satNr, fixQ);
        this.locationService.addLocation(id, saePoint);

        logger.info("Point received: "+ latitude + ";"+longitude);
        return saePoint;
    }

}
