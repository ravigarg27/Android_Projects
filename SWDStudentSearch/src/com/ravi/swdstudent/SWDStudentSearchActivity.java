package com.ravi.swdstudent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SWDStudentSearchActivity extends Activity {
    /** Called when the activity is first created. */
	Spinner hostelSpinner;
	Spinner branchSpinner;
    String _name="";
    String _id="";
    String _room_no="";
    String _branch="";
    String _hostel="";
    Button search;
    EditText id_no;
    EditText name;
    EditText room_no;
   // int count=0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        name = (EditText) findViewById(R.id.editText1);
        id_no = (EditText) findViewById(R.id.editText2);
        room_no = (EditText) findViewById(R.id.editText3);
        hostelSpinner = (Spinner) findViewById(R.id.spinner1);
        branchSpinner = (Spinner) findViewById(R.id.spinner2);
        search = (Button) findViewById(R.id.button1);
        
        
        populateSpinners();
        

        // get hostel no
        
        hostelSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				_hostel = arg0.getItemAtPosition(arg2).toString();
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				_hostel = "";
			}     
        });
        
        
        // get the branch
        
        branchSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				switch(arg2){
				case 0:
					_branch = "";
					break;
				case 1:
					_branch = "C6";
					break;
				case 2:
					_branch = "A1";
					break;
				case 3:
					_branch = "A7";
					break;
				case 4:
					_branch = "A4";
					break;
				case 5:
					_branch = "A3";
					break;
				case 6:
					_branch = "A8";
					break;
				case 7:
					_branch = "B1";
					break;
				case 8:
					_branch = "B2";
					break;
				case 9:
					_branch = "B3";
					break;
				case 10:
					_branch = "B4";
					break;
				case 11:
					_branch = "B5";
					break;
				case 12:
					_branch = "H";
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				_branch = "";
			}     
        });

        
        
        search.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				_name = name.getText().toString();
				_id = id_no.getText().toString();
				_room_no = room_no.getText().toString();		
				
				
				// connect to net for post action
				
				Intent in = new Intent(getApplicationContext(), ListResultActivity.class);
				
				in.putExtra("name",_name);
				in.putExtra("id_no",_id);
				in.putExtra("room_no",_room_no);
				in.putExtra("branch",_branch);
				in.putExtra("hostel",_hostel);
				//in.putExtra("COUNT", (int)count);
				startActivity(in);
				
				
			}        	
        });
        
    }

	private void populateSpinners() {
		// TODO Auto-generated method stub
		ArrayAdapter<CharSequence> hAdapter;
		hAdapter = ArrayAdapter.createFromResource(this, R.array.hostel,android.R.layout.simple_spinner_item);
				int spinner_dd_item = android.R.layout.simple_spinner_dropdown_item;
				hAdapter.setDropDownViewResource(spinner_dd_item);
				hostelSpinner .setAdapter(hAdapter);
	
		ArrayAdapter<CharSequence> bAdapter;
		bAdapter = ArrayAdapter.createFromResource(this, R.array.branch,android.R.layout.simple_spinner_item);
				int spinner_dd_item1 = android.R.layout.simple_spinner_dropdown_item;
				hAdapter.setDropDownViewResource(spinner_dd_item1);
				branchSpinner .setAdapter(bAdapter);
	}
}