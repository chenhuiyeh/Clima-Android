package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //links java code to layout file
        setContentView(R.layout.change_city_layout);
        //two views to link to the activity
        final EditText editTextField = (EditText) findViewById(R.id.queryET);
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // dropped from device memory
            }
        });

        editTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                String newCity = editTextField.getText().toString();
                Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);
                //package city name to intent as Extra
                newCityIntent.putExtra("City", newCity);
                startActivity(newCityIntent);

                return false;
            }
        });

    }
}
