package com.ravi.epac;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EpacActivity extends Activity {
    

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {        
            	Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            	startActivity(intent);
            }});
        
        b2.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View view){
        		Intent i = new Intent(getApplicationContext(), ContactUs.class);
        		startActivity(i);
        	}
        });
        
        b3.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View view){
        		Intent i = new Intent(getApplicationContext(), Members.class);
        		startActivity(i);
        	}
        });
        
        b4.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View view){
        		Intent i = new Intent(getApplicationContext(), ImageGallery.class);
        		startActivity(i);
        	}
        });
    }
}