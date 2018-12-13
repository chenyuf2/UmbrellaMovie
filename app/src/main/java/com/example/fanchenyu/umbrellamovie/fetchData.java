package com.example.fanchenyu.umbrellamovie;

import android.os.AsyncTask;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * asd.
 */
public class fetchData extends AsyncTask<Void, Void, Void> {
    /**
     * asd.
     */
    private String data = "";
    /**
     * asd.
     */
    private String dataParsed = "";
    /**
     * asd.
     */
    private String tomato = "";
    private String mycountry = "";
    private String imdb = "";
    private String director = "";
    private String actor = "";
    public String language = "";
    private String name = "";
    private String finalactor = "";
    public int id = 0;
    public String pl = "";
    /**
     * asd.
     */
    private String input;

    /**
     * asd.
     * @param temp
     */
    fetchData(final String temp) {
        input = temp;
    }

    /**
     * asd.
     */
    fetchData() {
    }
    @Override
    /**
     * asd.
     * @param voids
     * @return
     */

    protected Void doInBackground(final Void... voids) {
        try {
            input.replaceAll(" ", "+");
            URL url = new URL("http://www.omdbapi.com/?t=" + input + "&apikey=b2ac4536");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }
            JSONObject js = new JSONObject(data);
            name += js.getString("Title");
            language += js.getString("Language");
            actor += js.getString("Actors");
            List<String> templist = Arrays.asList(actor.split(","));
            for (int i = 0; i < templist.size(); i++) {
                finalactor += templist.get(i) + "\n";
            }
            director += js.getString("Director");
            imdb += "IMDB Rating: " + js.getString("imdbRating");
            tomato += "Rotten Rating: " + js.getString("Metascore");
            mycountry += js.getString("Country");
            pl += js.getString("Plot");
            pl = pl.substring(4);
            pl= "\n" + pl;

        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(final Void aVoid) {
        super.onPostExecute(aVoid);
        if (this.mycountry.isEmpty()) {
            UmbrellaMovie.city.setText("Movie is not found");
        } else {
            UmbrellaMovie.city.setText(this.name);
        }
        UmbrellaMovie.country.setText(this.mycountry);
        UmbrellaMovie.descrip.setText(this.tomato);
        UmbrellaMovie.temp.setText(this.imdb);
        UmbrellaMovie.small.setText(this.finalactor);
        UmbrellaMovie.big.setText(this.director);
        UmbrellaMovie.flood.setText(this.language);
        UmbrellaMovie.pl.setText(this.pl);
    }
}

