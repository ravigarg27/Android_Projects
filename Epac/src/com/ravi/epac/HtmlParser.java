package com.ravi.epac;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlParser {
	public List<article> articlelist = new ArrayList<article>();
	public List<article> eventlist = new ArrayList<article>();
	int i=0;
	
	public void parser(){
	try{
		Document doc = Jsoup.connect("http://www.bits-epac.org/epac/").get();
		Elements e = doc.select("ul.latestnews > li");
		Log.d(null, "No of articles found " + e.size());
		for(Element e1 : e ){
			Elements e2 = e1.select("a[href]");
			String link = e2.attr("href");
			String title = e1.text();
			Log.d(null,link);
			Log.d(null,title);
			article a1 = new article (link,title);
			i++;
			if(i<=5){ articlelist.add(a1);}
			else{eventlist.add(a1); }
		}
	}
catch(IOException e){}
	}
	public List<article> getArticles(){	
		parser();
		return articlelist;
}
	public List<article> getevents(){
		parser();
		return eventlist;
	}
		}
