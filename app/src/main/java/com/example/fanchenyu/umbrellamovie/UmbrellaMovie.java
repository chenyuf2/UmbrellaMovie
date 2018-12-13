package com.example.fanchenyu.umbrellamovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.TextView;

public final class UmbrellaMovie extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Lab11:Main";

    /** Request queue for our API requests. */
    /**
     * Run when this activity comes to the foreground.
     */
    private ImageButton click;
    /**
     * asd.
     */
    /**
     * asd.
     */
    public static TextView city;
    public static TextView country;
    public static TextView descrip;
    public static TextView temp;
    public static TextView small;
    public static TextView big;
    public static TextView flood;
    public static TextView pl;

    @Override
    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umbrella_movie);
        final EditText textInputCity = (EditText) findViewById(R.id.needCity);
        city = (TextView) findViewById(R.id.City);
        country = (TextView) findViewById(R.id.Country);
        descrip = (TextView) findViewById(R.id.main);
        temp = (TextView) findViewById(R.id.temp);
        small = (TextView) findViewById(R.id.min);
        big = (TextView) findViewById(R.id.max);
        flood = (TextView) findViewById(R.id.humidity);
        pl = (TextView) findViewById(R.id.plot);
        click = (ImageButton) findViewById(R.id.clickme);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                fetchData process = new fetchData(textInputCity.getText().toString().trim());
                process.execute();
            }
        });



    }



    }


