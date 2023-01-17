package at.ac.fhwn.nmea;

import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class NmeaMain {

    public static void main(String[] args){
        File file = new File(NmeaReader.class.getClassLoader().getResource("nmea.txt").getFile());
        List<SaePoint> saePointList = new NmeaService().getSaePoints(file);

        System.out.printf("%9s|%9s|%9s|%5s|%2s%n","time","latitude", "longitude","satNr","fix");
        for(SaePoint saePoint : saePointList){
            System.out.printf("%9s|%2.6f|%3.6f|%3d|%3d%n",
                    saePoint.getTime(),
                    saePoint.getLatitude(),
                    saePoint.getLongitude(),
                    saePoint.getNrOfSatellites(),
                    saePoint.getFixQuality());
        }
    }
}
