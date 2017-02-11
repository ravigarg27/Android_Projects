package com.bitsgoa.conference;

import android.os.Bundle;

public class Speakers extends MasterLayout
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView (R.layout.speakers_layout);
	    setTitleFromActivityLabel (R.id.title_text);
	}

}
