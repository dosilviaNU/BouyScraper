/**
 * Created by David on 10/1/2016.
 */

import java.util.HashMap;

/**
 * Class to map coordinates to data for bouy at that location.
 */
public class BouyDataMap {
  private HashMap<Coords, BouyDataList> map = new HashMap<Coords,BouyDataList>();

  public BouyDataMap(){

  }

   public void put(Coords key, BouyDataList value){
    map.put(key,value);
  }

}
