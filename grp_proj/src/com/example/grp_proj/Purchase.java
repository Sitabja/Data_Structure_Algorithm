package com.example.grp_proj;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Purchase extends Activity {
	public static String phno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.purchase);
	}
	


    public void onclick(View v)
    { Purchase.this.finish();
 
    }


	public void login_onclick(View v) {
		EditText edID = (EditText)findViewById(R.id.editText1);
		EditText edPWD = (EditText)findViewById(R.id.editText2);
		
		DBAdapter1 db = new DBAdapter1(this);
		
		db.createDatabase(); 
        db.open();
        
		//---Is the user valid?---		
        //Cursor c = db.getContact(edID.getText().toString(), edPWD.getText().toString());
        Cursor c = db.getTestData(edID.getText().toString(), edPWD.getText().toString());
        
        if (c.moveToFirst())
        {   phno=edPWD.getText().toString();
        	Toast.makeText(this, "Valid user...", Toast.LENGTH_LONG).show();
        	startActivity(new Intent("com.example.stocks"));
        
        }
        

        else
        	Toast.makeText(this, "Invalid user!!!", Toast.LENGTH_LONG).show();
        db.close();
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
			startActivity(new Intent("com.example.items"));
			
		}
		return false;
}}
