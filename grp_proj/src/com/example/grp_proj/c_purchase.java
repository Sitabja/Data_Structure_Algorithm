package com.example.grp_proj;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class c_purchase extends Activity implements
OnItemSelectedListener {
	 private static final String KEY_ROWID = "_id";
	 private static final String KEY_NAME = "name";
	    private static final String KEY_QTY = "quantity";
	 

// Spinner element
Spinner spinner;

// Add button
Button btnAdd;

// Input text
EditText inputLabel;
EditText inputLabel1;
static int id;
DBAdapter db;

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.c_purchase);

db = new DBAdapter(this);
db.open();

// Spinner element
spinner = (Spinner) findViewById(R.id.spinner);

// add button
btnAdd = (Button) findViewById(R.id.btn_add);

// new label input field

inputLabel = (EditText) findViewById(R.id.input_label);
inputLabel1 = (EditText) findViewById(R.id.editText1);
// Spinner click listener
spinner.setOnItemSelectedListener(this);

// Loading spinner data from database
loadSpinnerData();

/**
 * Add new label button click listener
 * 
 * */



btnAdd.setOnClickListener(new View.OnClickListener() {	
	@Override
	public void onClick(View arg0) {
		String label = inputLabel.getText().toString();
		String label1 = inputLabel1.getText().toString();
		if (label.trim().length() > 0) {
			Labels db = new Labels(getApplicationContext());
			        try {
			        	db.open();
			            //String sql ="SELECT * FROM TABLE_LABELS where KEY_NAME='"+label	+"'";
			            //Cursor mCur = db.rawQuery(sql, null);
			        	Cursor mCur = db.getALabel(label);
			        	if (mCur==null) {
			        	
			        		db.insertLabel(label,Integer.parseInt(label1));
			        		//Toast.makeText(getApplicationContext(), "insertLabel",Toast.LENGTH_LONG).show();

			        	} else
			        		{ 
			            //if (mCur!=null) {
			               //mCur.moveToFirst();
			              id = mCur.getInt(mCur.getColumnIndex(KEY_ROWID));
			               int curr_qty=mCur.getInt(mCur.getColumnIndex(KEY_QTY));
			            //   Toast.makeText(getApplicationContext(), "abc",Toast.LENGTH_LONG).show();
			               //mCur.close();
				          db.updateLabel_Qty(id, curr_qty, Integer.parseInt(label1)); 
				         
			        		}
			        	// Toast.makeText(this, "You selected: " + label,Toast.LENGTH_LONG).show();


			           // }
			           // else {
				       //        Toast.makeText(getApplicationContext(), "elseelseelseelse",Toast.LENGTH_LONG).show();

			            	//db.insertLabel(label,Integer.parseInt(label1));
			           // }
			        }catch (SQLException e) {			            
			            throw e;
			        }			 
			        db.close(); 
			// making input filed text to blank
			inputLabel.setText("");
			inputLabel1.setText("");

			// Hiding the keyboard
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);
			// Hiding the keyboard
						InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm1.hideSoftInputFromWindow(inputLabel1.getWindowToken(), 0);

			// loading spinner with newly added data
			loadSpinnerData();
		} else {
			Toast.makeText(getApplicationContext(), "Please enter label name",
					Toast.LENGTH_SHORT).show();
		}
		
		
	}
	
});
String label = null;
//Showing selected spinner item
Toast.makeText(this, "You selected: " + label,
		Toast.LENGTH_LONG).show();

}
public void done(View v)
{c_purchase.this.finish();
}

/**
* Function to load the spinner data from SQLite database
* */
private void loadSpinnerData() {
// database handler
Labels db = new Labels(this);
db.open();
// Spinner Drop down elements
List<String> lables = db.getAllLabels2();

// Creating adapter for spinner
ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, lables);

// Drop down layout style - list view with radio button
dataAdapter
		.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// attaching data adapter to spinner
spinner.setAdapter(dataAdapter);
db.close();
}

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position,
	long id) {
// On selecting a spinner item
String label = parent.getItemAtPosition(position).toString();

// Showing selected spinner item
Toast.makeText(parent.getContext(), "You selected: " + label,
		Toast.LENGTH_LONG).show();

}

@Override
public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

}
}

