package com.bitsgoa.conference;

import android.os.Bundle;

public class Contacts extends MasterLayout
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView (R.layout.contacts_layout);
	    setTitleFromActivityLabel (R.id.title_text);
	}

}
