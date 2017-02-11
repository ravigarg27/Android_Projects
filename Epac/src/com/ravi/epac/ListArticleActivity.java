package com.ravi.epac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ListArticleActivity extends ListActivity {

	public ProgressDialog pDialog;
	HtmlParser htmlparser = new HtmlParser();
	List<article> articlelist = new ArrayList<article>();
	ArrayList<HashMap<String, String>> articleItemList = new ArrayList<HashMap<String,String>>();
	private static String TAG_TITLE = "title";
	private static String TAG_LINK = "link";
	String link;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_list);
		
		new loadItems().execute();
		
		ListView lv = getListView();
		
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				TextView link1 = (TextView) view.findViewById(R.id.link);
				link = (String) link1.getText();
				link = link.toString();
				Log.d(null,link);
				new AlertDialog.Builder(ListArticleActivity.this)
                .setTitle("Select View")
                .setMessage("View The Articles In")
                .setPositiveButton("Website View", new AlertDialog.OnClickListener() {
                	public void onClick(DialogInterface dialog, int which) {
                		
                		Intent in = new Intent(getApplicationContext(), WebViewArticle.class);
        				in.putExtra("link", link);
        				Log.d(null,link);
                        startActivity(in);
                		
                		}})
                .setNegativeButton("Native View", new AlertDialog.OnClickListener() {
                	public void onClick(DialogInterface dialog, int which) {
                		
                		Intent in = new Intent(getApplicationContext(), ArticleView.class);
        				in.putExtra("link", link);
        				Log.d(null,link);
                        startActivity(in);
                		
            		}})
                .show();
			}
		});
	}
	
	
	class loadItems extends AsyncTask<String, String, String>{
		
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(
					ListArticleActivity.this);
			pDialog.setMessage("Loading recent articles...");
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
			articlelist = htmlparser.getArticles();
			
			for(article a1 : articlelist){
				HashMap<String, String> map = new HashMap<String, String>();
				Log.d(null,a1.getTitle());
				map.put(TAG_TITLE, a1.getTitle());
				map.put(TAG_LINK, a1.getLink());
			
			articleItemList.add(map);
			}
		// updating UI from Background Thread
		runOnUiThread(new Runnable() {
			public void run() {
				
				ListAdapter adapter = new SimpleAdapter(
						ListArticleActivity.this,
						articleItemList, R.layout.item_list_row,
						new String[] { TAG_LINK, TAG_TITLE, },
						new int[] { R.id.link, R.id.title });

				
				setListAdapter(adapter);
			}
		});
		return null;
	}
}
}