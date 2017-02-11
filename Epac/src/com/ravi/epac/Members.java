package com.ravi.epac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class Members extends ListActivity {
	public ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.members);
		new loadItems().execute();
			
	}
	
class loadItems extends AsyncTask<String, String, String>{
	List<String> members= new ArrayList<String>();
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(
					Members.this);
			pDialog.setMessage("Loading members list...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}
		
		protected void onPostExecute(String args) {
			// dismiss the dialog after getting all products
			pDialog.dismiss();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			try{
				Document doc = Jsoup.connect("http://www.bits-epac.org/epac/index.php/our-team/").get();
				Elements e = doc.select("div.leading-0 > ul > li");
				Log.d(null,"No of member" + e.size());
				for(Element e1 : e){
					String member = e1.text();
					
					members.add(member);
				}
			}
			catch(IOException e){}
			// updating UI from Background Thread
			runOnUiThread(new Runnable() {
				public void run() {
					
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(Members.this, android.R.layout.simple_list_item_1, members);
			
			setListAdapter(adapter);	
			
				}});
			return null;
		}
}
}
