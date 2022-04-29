package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class ConversionActivity extends AppCompatActivity {


    TextView inrTxt, euroTxt, usdTxt, cnrTxt, japTxt;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        inrTxt = findViewById(R.id.inrTxt);
        euroTxt = findViewById(R.id.euroTxt);
        usdTxt = findViewById(R.id.usdTxt);
        cnrTxt = findViewById(R.id.cnrTxt);
        japTxt = findViewById(R.id.japTxt);

        textToSpeech = new TextToSpeech(ConversionActivity.this, (TextToSpeech.OnInitListener) i -> {

            // if No error is found then only it will run
            if(i!=TextToSpeech.ERROR){
                // To Choose language of speech
                textToSpeech.setLanguage(Locale.UK);
            }
        });

        Intent intent = getIntent();
        int value = Integer.parseInt(intent.getStringExtra("money"));

        inrTxt.setText("INR: " + value);
        usdTxt.setText("USD: " + Math.round((value / 75.62) * 100.0) / 100.0);
        euroTxt.setText("Euro: " + Math.round((value / 83.99) * 100.0) / 100.0);
        cnrTxt.setText("CNR: " + Math.round((value / 60.78) * 100.0) / 100.0);
        japTxt.setText("JAP: " + Math.round((value / 0.62) * 100.0) / 100.0);

        inrTxt.setOnClickListener(view -> {
            textToSpeech.speak(inrTxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        });
        usdTxt.setOnClickListener(view -> {
            textToSpeech.speak(usdTxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        });
        euroTxt.setOnClickListener(view -> {
            textToSpeech.speak(euroTxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        });
        cnrTxt.setOnClickListener(view -> {
            textToSpeech.speak(cnrTxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        });
        japTxt.setOnClickListener(view -> {
            textToSpeech.speak(japTxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        });



    }
}