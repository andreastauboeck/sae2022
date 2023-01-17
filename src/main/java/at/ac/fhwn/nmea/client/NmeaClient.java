package at.ac.fhwn.nmea.client;

import at.ac.fhwn.nmea.NmeaReader;
import at.ac.fhwn.nmea.NmeaService;
import at.ac.fhwn.nmea.SaePoint;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

public class NmeaClient {

    public static void main(String[] args) throws InterruptedException {
        File file = new File(NmeaReader.class.getClassLoader().getResource("auto2.txt").getFile());
        List<SaePoint> saePointList = new NmeaService().getSaePoints(file);
        int id = 42;
        PointClientService pointClientService = new PointClientService(id);

        System.out.println(pointClientService.get("http://localhost:8080"));

        for(SaePoint saePoint : saePointList){
            System.out.println("Sent point: "+pointClientService.sendLocation(saePoint));
            Thread.sleep(1000);
        }
//
//        for(int i = 0; i<400; i++) {
//            System.out.println("Received point "+2+": " + pointClientService.getLocation(i));
//        }
//
//        for (SaePoint saePoint :
//                pointClientService.getLocations()) {
//            System.out.println("Received point: " + saePoint);
//        }

        for (Map.Entry<Integer, List<SaePoint>> pointListEntry: pointClientService.getAllLocations().entrySet()) {
            System.out.println("This are locations for id " + pointListEntry.getKey());
            for (SaePoint saePoint: pointListEntry.getValue()) {
                System.out.println(saePoint);
            }
        }
    }
}
