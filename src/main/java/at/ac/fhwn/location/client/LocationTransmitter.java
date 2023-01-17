package at.ac.fhwn.location.client;

import at.ac.fhwn.nmea.NmeaReader;
import at.ac.fhwn.nmea.SaePoint;
import at.ac.fhwn.nmea.client.PointClientService;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LocationTransmitter {

    public static void main(String[] args) {

        File file = new File(NmeaReader.class.getClassLoader().getResource("auto2.txt").getFile());

        NmeaReader nmeaReader = new NmeaReader(file);

        PointClientService clientService = new PointClientService(42);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SaePoint saePoint = nmeaReader.readPoint();
                System.out.println("Time : " + new Date());
                clientService.sendLocation(saePoint);
            }
        };

        Timer timer = new Timer("timerTask");

        timer.scheduleAtFixedRate(timerTask, 1000, 1000);



    }
}
