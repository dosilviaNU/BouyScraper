/**
 * Created by David on 10/1/2016.
 */

/**
 * Container object for buoy data scraped from the National Data Buoy Center.
 */
public class BouyData {
  private String month;
  private String day;
  private String time;
  private String windDir;
  private String windSpeed;
  private String gustSpeed;
  private String pressure;

  public BouyData(String month, String day, String time, String windDir, String windSpeed,
                  String gustSpeed, String pressure){
    this.month = month;
    this.day = day;
    this.time = time;
    this.windDir = windDir;
    this.windSpeed = windSpeed;
    this.gustSpeed = gustSpeed;
    this.pressure = pressure;
  }

  public String toString(){
    return this.month + " " + this.day + " " + this.time + " " + this.windDir + " " + this.windSpeed + " " + this.gustSpeed + " " + this.pressure;
  }

  public String getPressure(){return pressure;}
  public String getWindDirection() {return windDir.substring(0,1);}


}
