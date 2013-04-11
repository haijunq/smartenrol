/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.course;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import smartenrol.model.Building;


/**
 *
 * @author Jeremy
 */
public class WalkingDistance {

  private String building1 = "2229+Wesbrook+Mall+Vancouver";
  private String building2 = "1000+Wesbrook+Mall+Vancouver";
  private String duration;
  private String distance;
  
  public WalkingDistance(Building one, Building two) {
  
      building1 = one.getAddr1().replace(" ","+")+"+"+one.getCity()+"+"+one.getProvince()+"+"+one.getCountry();
      building2 = two.getAddr1().replace(" ","+")+"+"+two.getCity()+"+"+two.getProvince()+"+"+two.getCountry();
      try {
          run();
      } catch (IOException ex) {
          Logger.getLogger(WalkingDistance.class.getName()).log(Level.SEVERE, null, ex);
      } catch (JSONException ex) {
          Logger.getLogger(WalkingDistance.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public WalkingDistance() {
      try {
          run();
      } catch (IOException ex) {
          Logger.getLogger(WalkingDistance.class.getName()).log(Level.SEVERE, null, ex);
      } catch (JSONException ex) {
          Logger.getLogger(WalkingDistance.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  private String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
 
  public void run() throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("http://maps.googleapis.com/maps/api/distancematrix/json?origins="+building1+"&destinations="+building2+"&mode=walking&language=en-En&sensor=false");
    System.out.println(json);
    JSONObject elements = json.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0);
    JSONObject duration = elements.getJSONObject("duration");
    JSONObject distance = elements.getJSONObject("duration");
    this.duration = duration.get("text").toString();
    this.distance = distance.get("text").toString();
  }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @return the distance
     */
    public String getDistance() {
        return distance;
    }

}
