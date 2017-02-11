package com.ravi.epac;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class GoaGreenathon extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.goagreenathon);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
 
        switch (item.getItemId())
        {
        case R.id.rules:
        	Intent i = new Intent(getApplicationContext(), RulesActivity.class);
        	startActivity(i);
            return true;
 
        case R.id.projects_list:
        	 i = new Intent(getApplicationContext(), ProjectList.class);
        	//startActivity(i);
            return true;
 
        case R.id.contact_us:
        	//i = new Intent(getApplicationContext(), DeleteItems.class);
        	//startActivity(i);
            return true;
 
        case R.id.register:
        	i = new Intent(getApplicationContext(), Register.class);
        	startActivity(i);
            return true;
 
        case R.id.evaluation:
        	i = new Intent(getApplicationContext(), Evaluation.class);
        	startActivity(i);
            return true;
       
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
}
