package com.ravi.epac;

public class article {
		String _link;
		String _title;
		
		public article(){
		}
		
		public article(String link, String title){
			this._link=link;
			this._title=title;
		}
		
		public void setTitle(String title){
			this._title=title;
		}
		public void setLink(String link){
			this._link=link;
		}
		public String getTitle(){
			return this._title;
		}
		public String getLink(){
			return this._link;
		}
}
