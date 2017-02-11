package com.bitsgoa.conference;

import android.os.Bundle;

public class Notifiers extends MasterLayout
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView (R.layout.notifiers_layout);
	    setTitleFromActivityLabel (R.id.title_text);
	}

}
