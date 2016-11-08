package com.th.samsen.tunyaporn.showpicturefromurl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        SynLoadImage synLoadImage = new SynLoadImage(imageView);
        synLoadImage.execute();
    }

    private class SynLoadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView view;

        public SynLoadImage(ImageView view) {
            this.view = view;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlString = "http://service.eternity.co.th/tmspxd/images/photos/user1.png";
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new java.net.URL(urlString).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            view.setImageBitmap(bitmap);
        }
    }

}
