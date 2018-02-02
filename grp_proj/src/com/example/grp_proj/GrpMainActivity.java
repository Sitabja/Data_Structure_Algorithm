package com.example.grp_proj;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;

public class GrpMainActivity extends Activity {
	String tag = "Events";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grp_main);
	}
	public void onclick(View view) {
		startActivity(new Intent("com.example.GroupActivity"));
	}
	public void onclick3(View view) {
		startActivity(new Intent("com.example.Purchase"));
	}
	public void onclick4(View view) {
		startActivity(new Intent("com.example.c_purchase"));
	}
	public void onclick5(View view) {
		startActivity(new Intent("com.example.GrpProjActivity"));
	}
	public void onclick6(View view) {
		startActivity(new Intent("com.example.items"));
	}
	
	//fired whenever the user presses one of the keys on the device
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
			startActivity(new Intent("com.example.GroupActivity"));
			startActivity(new Intent("com.example.Purchase"));
			startActivity(new Intent("com.example.c_purchase"));
			startActivity(new Intent("com.example.GrpProjActivity"));
		}
		return false;
	}

}


