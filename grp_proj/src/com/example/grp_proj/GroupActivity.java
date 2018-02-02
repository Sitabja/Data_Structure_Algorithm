package com.example.grp_proj;



//import com.example.login.DBAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GroupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
    }
    public void onClick1(View view) {
  
		GroupActivity.this.finish();
    }
    
   public void onClick2(View v) {
	   Toast.makeText(this,"abc",Toast.LENGTH_LONG).show();
		EditText edID = (EditText)findViewById(R.id.editText1);
		EditText edContact = (EditText)findViewById(R.id.editText2);
		String s1 = edID.getText().toString();
	  String s2 = edContact.getText().toString();

		
		if (s1.trim().length() > 0) {
			DBAdapter db = new DBAdapter(this);
			// db.createDatabase(); 
             db.open();
			        try {
			        	db.open();
			        	Cursor mCur = db.getALabel(s1);
			        	if (mCur==null) {
			        	
		                  
		                   db.insertContact(s1, s2);
		                   db.close();
		                   Toast.makeText(this,"registration successful",Toast.LENGTH_SHORT).show();
		                 GroupActivity.this.finish();
		
                     } else 
                     {   Toast.makeText(this,"oops!already registered",Toast.LENGTH_SHORT).show();
                     }
			            // }
			        }catch (SQLException e) {			            
			            throw e;
			        }			 
			        db.close(); 
			        } 	
   }
}
	         		




    