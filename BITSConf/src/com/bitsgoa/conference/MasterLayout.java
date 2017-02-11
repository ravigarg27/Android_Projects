package com.bitsgoa.conference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public abstract class MasterLayout extends Activity 
{
	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	}
	protected void onDestroy ()
	{
	   super.onDestroy ();
	}

	protected void onPause ()
	{
	   super.onPause ();
	}

	protected void onRestart ()
	{
	   super.onRestart ();
	}

	protected void onResume ()
	{
	   super.onResume ();
	}

	protected void onStart ()
	{
	   super.onStart ();
	}
	protected void onStop ()
	{
	   super.onStop ();
	}
	public void onClickHome (View v)
	{
	    goHome (this);
	}

	public void onClickSearch (View v)
	{
	    startActivity (new Intent(getApplicationContext(), SearchActivity.class));
	}
	public void onClickAbout (View v)
	{
	    startActivity (new Intent(getApplicationContext(), AboutActivity.class));
	}
	public void goHome(Context context) 
	{
	    final Intent intent = new Intent(context, HomeActivity.class);
	    intent.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    context.startActivity (intent);
	}

	public void setTitleFromActivityLabel (int textViewId)
	{
	    TextView tv = (TextView) findViewById (textViewId);
	    if (tv != null) tv.setText (getTitle ());
	    
	} 
	public void toast (String msg)
	{
	    Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
	} 
	public void trace (String msg) 
	{
	    Log.d("Demo", msg);
	    toast (msg);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
	   getMenuInflater().inflate(R.menu.activity_home, menu);
	   return true;
	}

}
