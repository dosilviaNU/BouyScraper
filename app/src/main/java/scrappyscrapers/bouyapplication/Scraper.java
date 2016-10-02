import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {


    public Scraper() {
    }


    public static BouyDataList pullData(String bouyUrl) {
        BouyDataList bouyData = new BouyDataList();

        Document doc = null;

        try {
            doc = Jsoup.connect(bouyUrl).get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Element div = doc.getElementById("contenttable");
        Element topTable = div.getElementById("contenttable");
        Elements tables = topTable.getElementsByTag("table");


        Elements rows = tables.get(5).getElementsByTag("tr");
        for (int i = 3; i < rows.size(); i++) {
            Elements tds = rows.get(i).getElementsByTag("td");
            BouyData temp = new BouyData(tds.get(0).text(), tds.get(1).text(), tds.get(2).text(),
                    tds.get(4).text(), tds.get(5).text(), tds.get(6).text(), tds.get(11).text());
            bouyData.add(temp);

        }
        return bouyData;
    }

    public static Coords pullCoords(String bouyUrl){

        double north;
        double west;

        north = 0;
        west = 0;

        Document doc = null;
        try {
            doc = Jsoup.connect(bouyUrl).get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Element div = doc.getElementById("contenttable");
        Element topTable = div.getElementById("contenttable");
        Elements ps = topTable.getElementsByTag("p");
        Elements bs = ps.get(1).getElementsByTag("b");

        String northText = bs.get(2).text().substring(0,7);
        String westText  = bs.get(2).text().substring(8,15);

        north = Double.parseDouble(northText);
        west  = Double.parseDouble(westText);

        Coords mapCoords = new Coords(north,west);
        return mapCoords;
    }


  public static void main(String args[]) {

    new Scraper();

  }
}
