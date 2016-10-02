
import java.util.ArrayList;




import java.util.ArrayList;

/**
 * Created by David on 10/1/2016.
 */
public class BouyDataList {
    private ArrayList<BouyData> list;

    public BouyDataList() {
        this.list = new ArrayList<BouyData>();
    }

    public void add(BouyData given) {
        list.add(given);
    }

    public int size() {
        return list.size();
    }

   public BouyData get(int index) {
        return list.get(index);
    }




    public static Forecast createForecast(BouyDataList dataList) {


        //System.out.println(dataList.size());

        String[] pressureStrings = new String[dataList.size()];

        for (int i = 0; i < dataList.size(); i++) {
            pressureStrings[i] = (dataList.get(i).getPressure());
        }

        double[] pressures = new double[dataList.size()];

        for (int i =0; i<dataList.size();i++){
            pressures[i]=Double.parseDouble(pressureStrings[i]);
        }

        int currentPressureState;

        if (pressures[0] < 29.80) currentPressureState = 1;
        else if (pressures[0] < 30.20) currentPressureState = 2;
        else currentPressureState = 3;

        int pressureChangeDir;

        double pressureChange = pressures[0] - pressures[1];
        //System.out.println("change: "+pressureChange);

        if (pressureChange <= -0.08) pressureChangeDir = -2;
        else if (pressureChange <= -0.03) pressureChangeDir = -1;
        else if (pressureChange >= 0.03) pressureChangeDir = 1;
        else if (pressureChange >= 0.08) pressureChangeDir = 2;
        else pressureChangeDir = 0;

        int weatherRating = 5;
        String description = "Failure";

        switch (currentPressureState){
            case 1:
                switch (pressureChangeDir) {
                    case -2:
                        weatherRating = 0;
                        description = "Storm";
                        break;
                    case -1:
                        weatherRating = 3;
                        description = "Precipitation";
                        break;
                    default:
                        weatherRating = 8;
                        description = "Clearing, cooler";
                        break;
                }
                break;
            case 2:
                switch (pressureChangeDir){
                    case -2:
                        weatherRating = 3;
                        description = "Precipitation likely";
                        break;
                    case -1:
                        weatherRating = 6;
                        description = "Little change";
                        break;
                    default:
                        weatherRating = 7;
                        description = "Same as present";
                        break;
                }
                break;
            case 3:
                switch (pressureChangeDir){
                    case -2:
                        weatherRating = 7;
                        description = "Cloudy, warmer";
                        break;
                    case -1:
                        weatherRating = 8;
                        description = "Fair";
                        break;
                    default:
                        weatherRating = 10;
                        description = "Continued fair";
                        break;
                }
                break;
        }



        Forecast prediction = new Forecast(weatherRating,description);
        return prediction;
    }


    public static void main(String args[]) {

        Forecast temp;

        BouyDataList myData = new BouyDataList();


        BouyData data1 = new BouyData("10", "01", "2:57 am", "NNE", "11", "12", "30.09");
        BouyData data2 = new BouyData("10", "01", "2:53 am", "NNE", "11", "12", "30.20");
        myData.add(data1);
        myData.add(data2);

        temp = createForecast(myData);

        System.out.println(temp);

    }
}