/**
 * Created by David on 10/1/2016.
 */

/**
 * Class to represent map coordinates.
 */
public class Coords {
  private Double north;
  private Double west;

  public Coords(Double north, Double west){
    this.north = north;
    this.west = west;
  }

  public String toString(){
    return this.north + " , " + this.west;
  }
}
