package com.bitsgoa.conference;

import android.os.Bundle;

public class Schedule extends MasterLayout
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView (R.layout.schedule_layout);
	    setTitleFromActivityLabel (R.id.title_text);
	}

}
