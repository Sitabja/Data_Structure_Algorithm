package com.example.grp_proj;

import java.util.ArrayList;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GrpProjActivity extends Activity {

	private Context myContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grp_proj);
	}

	public void OnClick7(View view) {
		startActivity(new Intent("com.example.ProviderActivity"));
	}
	
	public void OnClick8(View view) {
		
		
		EditText txt1 = (EditText)findViewById(R.id.editText1);
		EditText txt2 = (EditText)findViewById(R.id.editText2);
		String s1=txt1.getText().toString();
		String s2=txt2.getText().toString();

		
		ArrayList<ContentProviderOperation> ops = new ArrayList < ContentProviderOperation > ();
		 ops.add((ContentProviderOperation.newInsert( ContactsContract.RawContacts.CONTENT_URI)).withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
		 .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null) .build()); 

		//------------------------------------------------------ Names 
		 if (s1!= null) { 
		 ops.add(((Builder) ContentProviderOperation.newInsert( ContactsContract.Data.CONTENT_URI))
		  .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
		  .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
		  .withValue( ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, s1).build());
		  } 
		 
		//------------------------------------------------------ Mobile Number 
		 if (s2!= null) { 
		 ops.add(ContentProviderOperation. newInsert(ContactsContract.Data.CONTENT_URI) 
		 .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0) 
		 .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
		  .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, s2) 
		 .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE) .build()); 
		 } 

		 Toast.makeText(this,"added successfully",Toast.LENGTH_SHORT).show();
		 
		// Asking the Contact provider to create a new contact
		 try 
		{ getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops); } 
		catch (Exception e) 
		{ e.printStackTrace(); Toast.makeText(myContext, "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show(); } 


		 
	}
	

}
