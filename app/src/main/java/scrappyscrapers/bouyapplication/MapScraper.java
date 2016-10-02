import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by David on 10/1/2016.
 */
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.*; // Only needed if scraping a local File.
import java.util.ArrayList;

public class MapScraper {


  public MapScraper() {}

  public static BouyDataMap constructMap(){

    BouyDataMap map = new BouyDataMap();

    Coords waquoit = new Coords(41.582, 70.525);
    Coords nantucketSound = new Coords(41.443, 70.187);
    Coords nantucket = new Coords(42.285, 70.096);
    Coords woodsHole = new Coords(41.524, 70.671);
    Coords blockIsland = new Coords(40.969, 71.727);

    String waquoitAddress = "http://www.ndbc.noaa.gov/station_page.php?station=waxm3";
    String nantucketSoundAddress = "http://www.ndbc.noaa.gov/station_page.php?station=44020";
    String nanutucketAddress = "http://www.ndbc.noaa.gov/station_page.php?station=ntkm3";
    String woodsHoleAddress = "http://www.ndbc.noaa.gov/station_page.php?station=BZBM3";
    String blockIslandAddress = "http://www.ndbc.noaa.gov/station_page.php?station=44097";

    Coords[] coordList = {waquoit,nantucketSound,nantucket,woodsHole,blockIsland};
    String[] addressList = {waquoitAddress,nantucketSoundAddress,nanutucketAddress,woodsHoleAddress,blockIslandAddress};

    for (int i = 0; i<addressList.length; i++){
      map.put(Scraper.pullCoords(addressList[i]), Scraper.pullData(addressList[i]));
    }
    return map;
  }
  

//public static Forecast[]

  public static void main(String args[]) {


  }
}
