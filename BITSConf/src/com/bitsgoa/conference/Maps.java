package com.bitsgoa.conference;

import android.os.Bundle;

public class Maps extends MasterLayout 
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView (R.layout.map_layout);
	    setTitleFromActivityLabel (R.id.title_text);
	}

}
