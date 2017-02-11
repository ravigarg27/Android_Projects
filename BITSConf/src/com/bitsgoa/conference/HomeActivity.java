package com.bitsgoa.conference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends MasterLayout {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
	public void onClickFeature (View v)
	{
	    int id = v.getId ();
	    switch (id) {
	      case R.id.home_btn_feature1 :
	           startActivity (new Intent(getApplicationContext(), Maps.class));
	           break;
	      case R.id.home_btn_feature2 :
	           startActivity (new Intent(getApplicationContext(), Schedule.class));
	           break;
	      case R.id.home_btn_feature3 :
	           startActivity (new Intent(getApplicationContext(), Speakers.class));
	           break;
	      case R.id.home_btn_feature4 :
	           startActivity (new Intent(getApplicationContext(), Contacts.class));
	           break;
	      case R.id.home_btn_feature5 :
	           startActivity (new Intent(getApplicationContext(), TourHelp.class));
	           break;
	      case R.id.home_btn_feature6 :
	           startActivity (new Intent(getApplicationContext(), Notifiers.class));
	           break;
	      default: 
	    	   break;
	    }
	}

   
    
}
