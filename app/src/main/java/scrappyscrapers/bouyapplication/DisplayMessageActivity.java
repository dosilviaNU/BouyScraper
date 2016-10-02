package scrappyscrapers.bouyapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        textView =  new TextView(this);
        Intent intent = getIntent();
        new GetDataTask().execute("hello");

    }

    private class GetDataTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            BouyDataList data = Scraper.pullData("http://www.ndbc.noaa.gov/station_page.php?station=waxm3");
            String message = data.get(1).toString();
            return message;
        }

        protected void onPostExecute(String result) {
            String message = (String) result;

            textView.setTextSize(40);
            textView.setText(message);
            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
            layout.addView(textView);
        }
    }}




