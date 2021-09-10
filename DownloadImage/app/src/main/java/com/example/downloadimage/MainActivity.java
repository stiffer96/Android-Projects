package com.example.downloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Image image;


    class Image extends AsyncTask<String,Void, Bitmap>{
        Bitmap bitmap;
        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL myUrl = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);


            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }

    public void downloadImage(View view){
        String url = "https://i.pinimg.com/originals/14/fc/03/14fc030a45875ea3021063e18d433ea5.png";
        image = new Image();
        try {
          Bitmap  myBitmap = image.execute(url).get();
          ImageView imageView = findViewById(R.id.imageView);
          imageView.setImageBitmap(myBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}