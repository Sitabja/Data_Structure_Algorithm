package com.example.grp_proj;


import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class lap_imageActivity extends Activity {

	private static final int DIALOG_ALERT = 10;
	private static final int DIALOG_ALERT1 =12;
	private static final int DIALOG_ALERT2 =13;
	private static final int DIALOG_ALERT3 =14;
	 private static final String KEY_ROWID = "_id";
	 private static final String KEY_NAME = "name";
	    private static final String KEY_QTY = "quantity";
	    private CheckBox cb1;
		 private CheckBox cb2; 
		 private CheckBox cb3;
		 private CheckBox cb4;
		 
// Input text
EditText inputLabel;
EditText inputLabel1;
static int id;
DBAdapter db;
public static String h="LAPTOP(S)";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lap_image);	
		cb1=(CheckBox)findViewById(R.id.checkBox1);
		cb2=(CheckBox)findViewById(R.id.checkBox2);
		cb3=(CheckBox)findViewById(R.id.checkBox3);
		cb4=(CheckBox)findViewById(R.id.checkBox4);
		
		
	}
	public void cbd(View v){
		if (cb4.isChecked())
		{ 
	       cb1.setChecked(false);
	       cb2.setChecked(false);
	       cb3.setChecked(false);
	      
		}
		
		}
		public void cbb(View v){
		if (cb2.isChecked())
		{ 
		   cb1.setChecked(false);
	       cb4.setChecked(false);
	       cb3.setChecked(false);
	      
		
		}
		}
		public void cbc(View v){
		
		if (cb3.isChecked())
		{ 
		   cb1.setChecked(false);
	       cb2.setChecked(false);
	       cb4.setChecked(false);
	      
		}
		}
		public void cba(View v){
		if (cb1.isChecked())
		{ 
		   cb4.setChecked(false);
	       cb2.setChecked(false);
	       cb3.setChecked(false);   
		}
		}
	//public lap_imageActivity() {
	//	buy0();
	//}

	public void buy(View v){
		db = new DBAdapter(this);
		db.open();

		// Spinner element



		// new label input field


		// Spinner click listener

		// Loading spinner data from database


		/**
		 * Add new label button click listener
		 * 
		 * */

       int i = 0;
       int a=0;
       int b=0;
       int c=0;
       int d=0;
       int j=0;

		String label=null;
		if (cb1.isChecked())
		{ label="HP_G6";
           i=40000;
           a=1;


		
		}
		if (cb2.isChecked())
		{ label="LENEVO_Z580";
		  i=35000; 
		 b=1;


		}
		if (cb3.isChecked())
		{ label="SONY_VAIO";
		 i=50000;
		c=1;


		}
		if (cb4.isChecked())
		{ label="DELL_STUDIO";
		 i=45000;
		d=1;


		}
		
		
		if(label!=null)	
		{	inputLabel1 = (EditText) findViewById(R.id.editText2);
		 
		    String label1;
		    label1 = inputLabel1.getText().toString();
		  //  Toast.makeText(getApplicationContext(), label1,Toast.LENGTH_SHORT).show();
		
		    	  	//Toast.makeText(getApplicationContext(), "PLEASE ENTER QUANTITY",Toast.LENGTH_SHORT).show();
		     
	//	Toast.makeText(getApplicationContext(),"Rs " +i+"*"+Integer.parseInt(label1)+"="+Integer.parseInt(label1)*i ,Toast.LENGTH_LONG).show();
		if(label1.matches(""))
		{ Toast.makeText(getApplicationContext(), "PLEASE ENTER QUANTITY",Toast.LENGTH_SHORT).show();
		
		}
		else
		{
	if (label.trim().length() > 0) {
			
			labels1 db = new labels1(getApplicationContext());
			        try {
			        	db.open();
			            //String sql ="SELECT * FROM TABLE_LABELS where KEY_NAME='"+label	+"'";
			            //Cursor mCur = db.rawQuery(sql, null);
			        	Cursor mCur = db.getALabel(label);
			        	int curr_qty=mCur.getInt(mCur.getColumnIndex(KEY_QTY));
			        	if (Integer.parseInt(label1)>curr_qty) {
				        	
			        		//db.insertLabel(label,Integer.parseInt(label1));
			        		Toast.makeText(getApplicationContext(), "out of stock \n current stock is =" +curr_qty + "",Toast.LENGTH_LONG).show();

			        	} else
			        		{ 
			            //if (mCur!=null) {
			               //mCur.moveToFirst();
			              id = mCur.getInt(mCur.getColumnIndex(KEY_ROWID));
			              // int curr_qty=mCur.getInt(mCur.getColumnIndex(KEY_QTY));
			            //   Toast.makeText(getApplicationContext(), "abc",Toast.LENGTH_LONG).show();
			               //mCur.close();
				          db.updateLabel_Qty(id, curr_qty, Integer.parseInt(label1)); 
				          //	Toast.makeText(getApplicationContext(), "sold!",Toast.LENGTH_LONG).show();
					      	Toast.makeText(getApplicationContext(),"sold! \n Rs " +i+"*"+Integer.parseInt(label1)+"="+Integer.parseInt(label1)*i ,Toast.LENGTH_SHORT).show();

			        	
			        	
			        	    j=Integer.parseInt(label1)*i;
			        		h=h+ "\n" +label1+" "+label +" "+"="+" "+Integer.parseInt(label1)*i ;
			        		Toast.makeText(getApplicationContext(),h ,Toast.LENGTH_LONG).show();
			        	    db.lap_total(j);
			        	    
			        		// lap_imageActivity.this.finish();
			        		}
			        	// Toast.makeText(getApplicationContext(), "sold!",Toast.LENGTH_LONG).show();

				        
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
		} 
		     }
			inputLabel1.setText("");

			// Hiding the keyboard
					} 
		else {
			Toast.makeText(getApplicationContext(), "Please click one item",
					Toast.LENGTH_SHORT).show();
		} 		
	}
	
	
	








	 @SuppressWarnings("deprecation")
	public void hp(View v){
		 showDialog(DIALOG_ALERT);
		 
		}
	 @SuppressWarnings("deprecation")
	public void vaio(View v) {
		 showDialog(DIALOG_ALERT1);
		 
		}
	 @SuppressWarnings("deprecation")
	public void lenovo(View v) {
		 showDialog(DIALOG_ALERT2);
		 
		}
	 @SuppressWarnings("deprecation")
	public void dell(View v) {
		 showDialog(DIALOG_ALERT3);
		 
		}
	 @SuppressWarnings("deprecation")
	@Override
		protected Dialog onCreateDialog(int id) {
			switch (id) {
			
			
			case DIALOG_ALERT1:
				// Create out AlterDialog
				Builder builder1 = new AlertDialog.Builder(this);
				builder1.setMessage("SONY VAIO\nPrice:Rs. 50000.00");
				builder1.setCancelable(true);
				//builder.setPositiveButton("I agree", new OkOnClickListener());
				builder1.setNegativeButton("Next", new CancelOnClickListener());
				AlertDialog dialog1 = builder1.create();
				dialog1.show();
				return super.onCreateDialog(id);
			case DIALOG_ALERT3:
				// Create out AlterDialog
				Builder builder3 = new AlertDialog.Builder(this);
				builder3.setMessage("DELL STUDIO\nPrice:Rs. 45000.00");
				builder3.setCancelable(true);
				//builder.setPositiveButton("I agree", new OkOnClickListener());
				builder3.setNegativeButton("Next", new CancelOnClickListener());
				AlertDialog dialog3 = builder3.create();
				dialog3.show();
				return super.onCreateDialog(id);
			case DIALOG_ALERT2:
				// Create out AlterDialog
				Builder builder2 = new AlertDialog.Builder(this);
				builder2.setMessage("LENEVO Z580\nPrice:Rs. 35000.00");
				builder2.setCancelable(true);
				//builder.setPositiveButton("I agree", new OkOnClickListener());
				builder2.setNegativeButton("Next", new CancelOnClickListener());
				AlertDialog dialog2 = builder2.create();
				dialog2.show();
				return super.onCreateDialog(id);
			case DIALOG_ALERT:
				// Create out AlterDialog
				Builder builder = new AlertDialog.Builder(this);
				builder.setMessage("HP-G6\nPrice:Rs. 40000.00");
				builder.setCancelable(true);
				//builder.setPositiveButton("I agree", new OkOnClickListener());
				builder.setNegativeButton("Next", new CancelOnClickListener());
				AlertDialog dialog = builder.create();
				dialog.show();
				return super.onCreateDialog(id);
			}
			return super.onCreateDialog(id);
		}
	 private final class CancelOnClickListener implements
		DialogInterface.OnClickListener {
	public void onClick(DialogInterface dialog, int which) {
		Toast.makeText(getApplicationContext(), "GREAT CHOICE!",
				Toast.LENGTH_SHORT).show();
	}
}
	
	
}




	


