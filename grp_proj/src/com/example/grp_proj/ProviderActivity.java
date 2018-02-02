package com.example.grp_proj;

import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

public class ProviderActivity extends ListActivity {
    /** Called when the activity is first created. */
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Uri allContacts = Uri.parse("content://contacts/people");
       
        Cursor c; 
        if (android.os.Build.VERSION.SDK_INT < 11) {  //---before Honeycomb---        	
        	c = managedQuery(allContacts, null, null, null, null); 
        	// Same as: 
        	// c = getContentResolver().query(allContacts, null, null, null, null);
        	// startManagingCursor(c); //---allows the activity to manage the Cursor’s lifecycle based on the activity’s lifecycle---
        	
        } else {  //---Honeycomb and later---        	
        	CursorLoader cursorLoader = new CursorLoader(this, allContacts, null, null, null, null);           
        	// The CursorLoader class (only available beginning with Android API level 11 and later) performs 
        	// the cursor query on a background thread and hence does not block the application UI.
            c = cursorLoader.loadInBackground();        	
        }
        
        String[] columns = new String[] { ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts._ID };        
        int[] views = new int[] { R.id.contactName, R.id.contactID };
        // The SimpleCursorAdapter object maps a cursor to TextViews (or ImageViews) defined in your XML
        // file (main.xml). It maps the data (as represented by columns) to views (as represented by views).
        SimpleCursorAdapter adapter;
        
        if (android.os.Build.VERSION.SDK_INT <11) {  //---before Honeycomb---        	
        	adapter = new SimpleCursorAdapter(this, R.layout.main, c, columns, views);
        } else {  //---Honeycomb and later---        	
        	adapter = new SimpleCursorAdapter(this, R.layout.main, c, columns, views, 
        												CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);        	
        }        
        this.setListAdapter(adapter);
    }   
}