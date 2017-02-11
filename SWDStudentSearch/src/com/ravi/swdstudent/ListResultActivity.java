package com.ravi.swdstudent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListResultActivity extends ListActivity {

	private String _name;
	private String _id;
	private String _hostel;
	private String _room_no;
	private String _branch;
	ArrayList<HashMap<String, String>> articleItemList = new ArrayList<HashMap<String,String>>();
	private String _NAME;
	private String _ID;
	private String _HOSTEL;
	private String _ROOMNO;
	List<String> list = new ArrayList<String>();
	int count=0;
	String url = "http://swd.bits-goa.ac.in/css/studentImg/";
	//List<String> urlImagelist = new ArrayList<String>();
	//String url1;
	//ImageView imageview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//Settings.System.putString(getContentResolver(), Settings.System.HTTP_PROXY, "10.1.9.36:8080");
		Bundle extras = getIntent().getExtras();
		Intent in = getIntent();
		_name = in.getStringExtra("name");
		_id = in.getStringExtra("id_no");
		_hostel = in.getStringExtra("hostel");
		_room_no = in.getStringExtra("room_no");
		_branch = extras.getString("branch");
		//_count = extras.getInt("COUNT");
		//imageview = (ImageView) findViewById(R.id.imageView1);
		if(_name.equals("")){
			count++;}
		if(_id.equals("")){
			count++;}
		if(_room_no.equals("")){
			count++;}
		if(_hostel.equals("")){
			count++;}
		if(_branch.equals("")){
			count++;}
		
		count = 5 - count;
		Log.d(null, Integer.toString(count));
		Log.d(null, Integer.toString(count));
		Log.d(null, _name);
		Log.d(null, _id);
		Log.d(null, _room_no);
		Log.d(null, _hostel);
		Log.d(null, _branch);
		try {
			Document doc = Jsoup.connect("http://swd.bits-goa.ac.in/search1.php").data("name",_name,"id",_id,"hostel",_hostel,"room",_room_no,"branch",_branch,"search","Search").post();
			Elements e1 = doc.select("tbody > tr > td#contact1");
			for(Element e : e1){
				Log.d(null, e.text());
				list.add(e.text());
			}
			int n = list.size();
			int i=count;
			while(i<n){
				_NAME = list.get(i+1);
				_ID = list.get(i);
				_HOSTEL= list.get(i+2);
				_ROOMNO = list.get(i+3);
				i=i+4;
				HashMap<String, String> map = new HashMap<String, String>();
				
				map.put("NAME", _NAME);
				map.put("ID", _ID);
				map.put("HOSTEL", _HOSTEL);
				map.put("ROOM", _ROOMNO);
			
			
				//url1 = url + _ID + ".jpg";
				//Bitmap bitmap = loadImageFromUrl(url1);
				  //imageview.setImageBitmap(bitmap);
				
				
				articleItemList.add(map);
			}			
			
			ListAdapter adapter = new SimpleAdapter(
					ListResultActivity.this,
					articleItemList, R.layout.listresultrow,
					new String[] { "NAME", "ID", "HOSTEL", "ROOM"},
					new int[] { R.id.name, R.id.id, R.id.hostel, R.id.room});

			
			setListAdapter(adapter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Toast.makeText(ListResultActivity.this, "name " + _name + "\nHostel " + _hostel +"\nbranch "+ _branch +"\nId "+ _id + "\nroomno "+_room_no, Toast.LENGTH_LONG).show();
	
	ListView lv = getListView();
	lv.setOnItemClickListener(new OnItemClickListener(){
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			url = "http://swd.bits-goa.ac.in/css/studentImg/";
			TextView tv = (TextView) view.findViewById(R.id.id);
			String temp = tv.getText().toString();
			temp = temp.substring(0, temp.length()-1);
			url = url + temp + ".jpg";
			Log.i(null, url);
			Intent i = new Intent(ListResultActivity.this, Imageview.class);
			i.putExtra("imageurl", url);
			startActivity(i);
			}
		});
	}
	
}
