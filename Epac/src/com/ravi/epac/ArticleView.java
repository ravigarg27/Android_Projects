package com.ravi.epac;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ArticleView extends Activity {
	TextView title;
	TextView description;
	public String page_url;
	public String TITLE;
	public String DESCRIPTION="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.articleview);
		Intent i = getIntent();
		page_url = i.getStringExtra("link");
		page_url = "http://www.bits-epac.org/" + page_url;
		parser();
		title = (TextView) findViewById(R.id.textView1);
		description = (TextView) findViewById(R.id.textView2);
		
		title.setText(TITLE);
		description.setText(DESCRIPTION);
	}
	public void parser(){
		try{
			Document doc = Jsoup.connect(page_url).get();
			Elements Title = doc.select("div.item-page > h2 > a");
			TITLE = Title.text();
			
			Elements e2 = doc.select("div.item-page > p");
			for(Element e : e2){
				DESCRIPTION = DESCRIPTION + e.text() + "\n";
				
				
			}				
		}
		catch(IOException e){}		
	}
}
