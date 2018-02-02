package com.example.grp_proj;



//import com.example.login.DBAdapter;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class stocks extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stocks);
    }

    public void laptop_image(View v) {
		startActivity(new Intent("com.example.lap_imageActivity"));
	}
    public void camera_image(View v) {
		startActivity(new Intent("com.example.cam_imageActivity"));
	}
    public void tablet_image(View v) {
		startActivity(new Intent("com.example.tab_imageActivity"));
	}
    public void mobile_image(View v) {
		startActivity(new Intent("com.example.mob_imageActivity"));
	}
    public void total(View v) {
    	startActivity(new Intent("com.example.bill"));
	}
    
    public void home(View v)
    {	stocks.this.finish();
    }
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
			startActivity(new Intent("com.example.lap_imageActivity"));
			startActivity(new Intent("com.example.cam_imageActivity"));
			startActivity(new Intent("com.example.tab_imageActivity"));
			startActivity(new Intent("com.example.mob_imageActivity"));
			startActivity(new Intent("com.example.bill"));
			
		}
		return false;
	}
	

}