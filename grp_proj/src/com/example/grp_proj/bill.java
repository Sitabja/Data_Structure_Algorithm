package com.example.grp_proj;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bill extends Activity{
	TextView x1;
	TextView x2;
	TextView x3;
	TextView x4;
	TextView x5;
	lap_imageActivity im=new lap_imageActivity();
    cam_imageActivity cm=new  cam_imageActivity();
    mob_imageActivity mm=new  mob_imageActivity();
    tab_imageActivity tm=new  tab_imageActivity();

	

	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bill);
	    }
	public void back(View v)
    {	bill.this.finish();
    }
	
 public void bill1(View v)
 {   // Toast.makeText(getApplicationContext(),"abc" ,Toast.LENGTH_LONG).show();
	 	// lap_imageActivity im=new lap_imageActivity();
        // cam_imageActivity cm=new  cam_imageActivity();
        // mob_imageActivity mm=new  mob_imageActivity();
        // tab_imageActivity tm=new  tab_imageActivity();
 
		x1 = (TextView)findViewById(R.id.textView1);
		x2=(TextView)findViewById(R.id.textView2);
		x3=(TextView)findViewById(R.id.textView3);
		x4=(TextView)findViewById(R.id.textView4);
		x5=(TextView)findViewById(R.id.textView6);
		 if(im.h!="LAPTOP"||cm.h2!="CAMERA"||mm.h3!="MOBILE"||tm.h4!="TABLET") 
		 {
		if (lap_imageActivity.h!="LAPTOP(S)") {
			x1.setText(im.h);
			 // Toast.makeText(getApplicationContext(),"im.h = "+im.h ,Toast.LENGTH_LONG).show();
		}
		else {
			 im.h=null;
		}
		
		if ( cam_imageActivity.h2!="CAMERA(S)"){
			x2.setText(cm.h2);
		}
		else {
			 cm.h2=null;
		}
		if ( mob_imageActivity.h3!="MOBILE(S)")
		{  // Toast.makeText(getApplicationContext(),"mm.h3 = "+mm.h3 ,Toast.LENGTH_LONG).show();
			x3.setText(mm.h3);
		}		
		else {
			 mm.h3=null;
		}
		if (tab_imageActivity.h4!="TABLET(S)"){
			x4.setText(tm.h4);
		}
		else {
			 tm.h4=null;
		}
		if (labels1.total()>0) {
			 // Toast.makeText(getApplicationContext(),"kidsbvhsvbiksvbisdu"+labels1.total(),Toast.LENGTH_LONG).show();
			x5.setText("total "+" "+"="+" "+ Integer.toString(labels1.total()));
		}
		 }
		 else
		 {  Toast.makeText(getApplicationContext(),"no bill",Toast.LENGTH_LONG).show();
			}
		
} 
 public void sms(View v)
 { Purchase p=new Purchase();
	 String phoneNo=p.phno;
	 String t="\n total =  " +Integer.toString(labels1.total());
	 String sms="your bill is \n";
	
	// Toast.makeText(getApplicationContext(),phoneNo,Toast.LENGTH_LONG).show();
	 String[] a={im.h,cm.h2, mm.h3, tm.h4,t};
	 for(int i=0;i<=4;i++)
		if(a[i]!=null)
		{ sms=sms+a[i] + "\n"  ;
		 
		}
	 
	 if(im.h!=null||cm.h2!=null||mm.h3!=null||tm.h4!=null)
	 {	 sms=sms+"the product(s) will be delivered within 3 working days ";
	 Toast.makeText(getApplicationContext(),sms,Toast.LENGTH_LONG).show();
		try { 
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo, null, sms, null, null);
			Toast.makeText(getApplicationContext(), "SMS Sent!",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"SMS faild, please try again later!",
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	 }
		else {
			 Toast.makeText(getApplicationContext(),"no bill",Toast.LENGTH_LONG).show();
		}
	 }
	 }

