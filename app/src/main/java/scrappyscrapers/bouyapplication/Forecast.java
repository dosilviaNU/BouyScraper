import javax.swing.text.Highlighter;

/**
 * Created by Owner on 10/1/2016.
 */
public class Forecast {
    private int weatherRating; //integer 1-10 ranks how nice the weather will be
    private String description; //description of the forecast

    public Forecast(int weatherRating, String description) {
        this.weatherRating = weatherRating;
        this.description = description;
    }


    public String toString() {
        return this.weatherRating + "/10 " + this.description;
    }
}
