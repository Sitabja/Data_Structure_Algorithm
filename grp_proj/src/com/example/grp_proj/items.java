package com.example.grp_proj;



//import com.example.login.DBAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class items extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);
    }
    public void laptop(View v) {
		startActivity(new Intent("com.example.laptop"));
	}
    public void camera(View v) {
		startActivity(new Intent("com.example.camera"));
	}
    public void tablet(View v) {
		startActivity(new Intent("com.example.tablet"));
	}
    public void mobile(View v) {
		startActivity(new Intent("com.example.mobile"));
	}
    
    public void home(View v)
    {	items.this.finish();
    }
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
			startActivity(new Intent("com.example.laptop"));
			startActivity(new Intent("com.example.camera"));
			
			
		}
		return false;
	}
	
}
  
