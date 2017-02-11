package com.ravi.epac;

import java.util.ArrayList;
import java.util.HashMap;

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
import android.widget.AdapterView.OnItemClickListener;

public class ContactUs extends ListActivity {
	ArrayList<HashMap<String, String>> contactsList = new ArrayList<HashMap<String, String>>();
	String[] names = new String[] { "Tanmaya Sanghavi", "Ankit Vikrant",
			"Ravi Garg" };
	String[] posts = new String[] { "Co-ordinator", "Secretary",
			"App Developer" };
	String[] branch = new String[] { "B.E CompSci | MSc Economics",
			"B.E CompSci | MSc Physics", "B.E CompSci | MSc Biology" };
	String[] emailId = new String[] { "tanmaya.bpgc@gmail.com",
			"ankitvikrant74@gmail.com", "ravigarg27@gmail.com" };
	private static String NAME = "name";
	private static String POSTS = "posts";
	private static String BRANCH = "branch";
	private static String EMAILID = "emailid";
	String link;
	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		Log.d(null, "here");
		for (i = 0; i <= 2; i++) {
			Log.d(null, names[i]);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put(NAME, names[i]);
			map.put(POSTS, posts[i]);
			map.put(BRANCH, branch[i]);
			map.put(EMAILID, emailId[i]);

			contactsList.add(map);
		}

		ListAdapter adapter = new SimpleAdapter(this, contactsList,
				R.layout.contact_list_row, new String[] { NAME, POSTS, BRANCH,
						EMAILID }, new int[] { R.id.name, R.id.post,
						R.id.branch, R.id.emailId });

		setListAdapter(adapter);

		ListView lv = getListView();

		lv.setOnItemClickListener(new OnItemClickListener() {
			
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				TextView link1 = (TextView) view.findViewById(R.id.emailId);
				link = (String) link1.getText();
				link = link.toString();
				
				Intent in = new Intent(Intent.ACTION_SEND);
				in.setType("text/plain");
				in.putExtra(Intent.EXTRA_EMAIL, new String[] {link});
				Intent chooser = Intent.createChooser(in, "Select Application");
				startActivity(chooser);
			}
		});

	}
}
