package at.ac.fhwn.nmea;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NmeaService {
    public List<SaePoint> getSaePoints(File file) {
        NmeaReader reader = new NmeaReader(file);
        List<SaePoint> saePointList = new ArrayList<>();

        boolean endOfFile = false;
        while (!endOfFile){

            SaePoint saePoint = reader.readPoint();
            if(saePoint == null){
                endOfFile=true;
            }else {
                saePointList.add(saePoint);
            }
        }
        return saePointList;
    }
}
