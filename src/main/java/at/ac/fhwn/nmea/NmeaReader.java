package at.ac.fhwn.nmea;

import java.io.*;
import java.util.Scanner;

public class NmeaReader {

    private Scanner scanner;
    private final File nmeaFile;

    public static void main(String[] args) {

//        new NmeaReader()
    }
    public NmeaReader(File nmeaFile) {

        this.nmeaFile = nmeaFile;
        try {
            assert nmeaFile.exists();
            FileInputStream fis=new FileInputStream(nmeaFile);
            scanner=new Scanner(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String read(File nmeaFile) throws IOException{
        try {
            assert nmeaFile.exists();
            FileInputStream fis=new FileInputStream(nmeaFile);//wirft IOException (checked)
            Scanner scanner=new Scanner(fis);
            return scanner.nextLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public SaePoint readPoint() {
        SaePoint saePoint = null;

        while (saePoint == null && scanner.hasNext()) {
            String line;
            line = scanner.nextLine();
            if(line==null){
                return null;
            }
            saePoint = readMessage(line);
        }
        if(!scanner.hasNextLine()){
            assert nmeaFile.exists();
            FileInputStream fis= null;
            try {
                fis = new FileInputStream(nmeaFile);

            scanner=new Scanner(fis);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return this.readPoint();
        }

        return saePoint;
    }

    private SaePoint readMessage(String line) {
        String[] values = line.split(",");

        if (values[0].equals("$GNGGA")) {
            String time = values[1];
            double latitude = Double.parseDouble(values[2].substring(0,2)) +
                    Double.parseDouble(values[2].substring(2))/60;
            double longitude = Double.parseDouble(values[4].substring(0,3)) +
                    Double.parseDouble(values[4].substring(3))/60;
            int fixQuality = Integer.parseInt(values[6]);
            int nrOfSatellites = Integer.parseInt(values[7]);

            return new SaePoint(time,latitude,longitude, nrOfSatellites,fixQuality);
        }
        return null;
    }
}
