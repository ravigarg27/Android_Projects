package com.bitsgoa.conference;

import android.os.Bundle;

public class SearchActivity extends MasterLayout
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView (R.layout.search_layout);
	    setTitleFromActivityLabel (R.id.title_text);
	}

	
}
