import java.util.*;
import edu.duke.*;

public class EarthQuakeClient
{

    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    //code for finding big Earthquakes
    public ArrayList<QuakeEntry> filterByMagnitude(
          ArrayList<QuakeEntry> quakeData, double magMin) {
        
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData){
            if(qe.getMagnitude() > magMin){
                answer.add(qe);
                //System.out.println(answer);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO

        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }
    
    //code for finding big Earthquakes
    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        /*
        for(QuakeEntry qe : list){            
            if(qe.getMagnitude() > 5.0){
                System.out.println(qe); 
            }
        }
        */
       ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
       for(QuakeEntry qe : listBig){
           System.out.println(qe);
       }
       System.out.println("Found " + listBig.size() + " that match that criteria");
    }

    //Code for finding Earthquakes in under 1000km
    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        // Location city =  new Location(38.17, -118.82);

        // TODO
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }
    
    //hack tester
        public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany){
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        // TO DO

        return ret;
    }
       
        public void findClosestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("Read data for "+list.size() + " citys.");

        //Location jakarta  = new Location(-6.211,106.845);
        
        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        
        ArrayList<QuakeEntry> close = getClosest(list,city,25);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000000,entry);
        }
        System.out.println("number found: "+close.size());
    }
    
    public static double distance(double lat1, double lat2, double lon1,
            double lon2, double el1, double el2) {
    
        final int R = 6371; // Radius of the earth
    
        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
    
        double height = el1 - el2;
    
        distance = Math.pow(distance, 2) + Math.pow(height, 2);
    
        return Math.sqrt(distance);
    }
    
}
