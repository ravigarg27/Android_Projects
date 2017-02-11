package com.ravi.swdstudent;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class Imageview extends Activity {
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.imageview);
	       // Settings.System.putString(getContentResolver(), Settings.System.HTTP_PROXY, "10.1.9.36:8080");
	        ImageView i = (ImageView) findViewById(R.id.imageView1);
	        Intent in = getIntent();
	        
	       String imageurl = in.getStringExtra("imageurl");
	       Log.d(null, imageurl);
	        Bitmap bitmap = loadImageFromUrl(imageurl);
			 
			  i.setImageBitmap(bitmap);
	        	Toast.makeText(this, "ImageLoaded", Toast.LENGTH_LONG).show();
	    }

		private Bitmap loadImageFromUrl(String imageurl) {
			URL m;
	        InputStream i = null;
	        BufferedInputStream bis = null;
	        ByteArrayOutputStream out =null;
	        try {
	            m = new URL(imageurl);
	            i = (InputStream) m.getContent();
	            bis = new BufferedInputStream(i,1024 * 8);
	            out = new ByteArrayOutputStream();
	            int len=0;
	            byte[] buffer = new byte[1024];
	            while((len = bis.read(buffer)) != -1){
	                out.write(buffer, 0, len);
	            }
	            out.close();
	            bis.close();
	        } catch (MalformedURLException e1) {
	            e1.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        byte[] data = out.toByteArray();
	        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
	        //Drawable d = Drawable.createFromStream(i, "src");
	        return bitmap;

		}
}
