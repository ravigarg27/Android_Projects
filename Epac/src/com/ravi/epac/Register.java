package com.ravi.epac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	
	
	private EditText name_of_school;
	private EditText school_phone;
	private EditText team_leader;
	private EditText school_add;
	private EditText email_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		Button b1 = (Button) findViewById(R.id.widget55);
		b1.setOnClickListener(new OnClickListener(){
			
			

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				name_of_school = (EditText) findViewById(R.id.widget38);
				school_add = (EditText) findViewById(R.id.widget42);
				school_phone = (EditText) findViewById(R.id.widget48);
				team_leader = (EditText) findViewById(R.id.widget49);
				email_id = (EditText) findViewById(R.id.widget52);
				
				BufferedReader br;
				String br1 = null;
				HttpClient httpClient = new DefaultHttpClient();
				HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 1000000000);
				HttpConnectionParams.setSoTimeout(httpClient.getParams(), 1000000000);
				HttpPost httpPost = new HttpPost("http://www.bits-epac.org/epac/index.php/registration");  
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
				nameValuePairs.add(new BasicNameValuePair("m4j-1", name_of_school.getText().toString())); 
				nameValuePairs.add(new BasicNameValuePair("m4j-2", school_add.getText().toString()));
				nameValuePairs.add(new BasicNameValuePair("m4j-3", school_phone.getText().toString()));
				nameValuePairs.add(new BasicNameValuePair("m4j-4", team_leader.getText().toString()));
				nameValuePairs.add(new BasicNameValuePair("m4j-5", "98654"));
				nameValuePairs.add(new BasicNameValuePair("m4j-6", email_id.getText().toString()));
				
				
				try {
					httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpClient.execute(httpPost);
					 br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()), 8096);
					while(br.readLine() != null){
					br1 = br1 + br.readLine();  br1=br1+"\n";}
					 
							Toast.makeText(Register.this, br1, Toast.LENGTH_LONG).show();
							Log.d(null, br1);
						
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				

				
				
			}
		});
	}

}
