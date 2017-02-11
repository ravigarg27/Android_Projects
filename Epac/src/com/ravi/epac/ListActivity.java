package com.ravi.epac;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ListActivity extends TabActivity{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list);

	        TabHost tabHost = getTabHost();
	        
	        TabSpec articlespec = tabHost.newTabSpec("articles");
	        TabSpec eventspec = tabHost.newTabSpec("events");
	        TabSpec greenathonspec = tabHost.newTabSpec("greenathon");
	        
	        
	        articlespec.setIndicator("Articles", getResources().getDrawable(R.drawable.article));
	        eventspec.setIndicator("Events", getResources().getDrawable(R.drawable.events));
	        greenathonspec.setIndicator("Goa Greenathon");
	        
	        Intent articleintent = new Intent(this, ListArticleActivity.class);
	        Intent eventintent = new Intent(this, ListEventsActivity.class);
	        Intent goagreenathonintent = new Intent(this, GoaGreenathon.class);
	        
	        articlespec.setContent(articleintent);
	        eventspec.setContent(eventintent);
	        greenathonspec.setContent(goagreenathonintent);
	        
	        tabHost.addTab(articlespec);
	        tabHost.addTab(eventspec);
	        tabHost.addTab(greenathonspec);
}
}