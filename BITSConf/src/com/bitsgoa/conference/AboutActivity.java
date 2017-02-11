package com.bitsgoa.conference;

import android.os.Bundle;

public class AboutActivity extends MasterLayout
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);

	    setContentView (R.layout.about_layout);
	    setTitleFromActivityLabel(R.id.title_text);
	}

}
