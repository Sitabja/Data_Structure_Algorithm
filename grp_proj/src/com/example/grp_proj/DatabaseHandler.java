package com.example.grp_proj;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "spinnerExample";
 
    // Labels table name
    private static final String TABLE_LABELS = "labels";
 
    // Labels Table Columns names

    private static final String KEY_NAME = "name";
    private static final String KEY_QTY = "quantity";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	// Category table create query
    	String TAB = "CREATE TABLE " + TABLE_LABELS + "(" + KEY_NAME + " TEXT," + KEY_QTY + " INTEGER PRIMARY KEY)";
    	db.execSQL(TAB);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LABELS);
 
        // Create tables again
        onCreate(db);
    }
    
    /**
     * Inserting new lable into lables table
     * */
    public void insertLabel(String item_name, int qty){
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put(KEY_NAME, item_name);
    	values.put(KEY_QTY, qty); 
    	// Inserting Row
        db.insert(TABLE_LABELS, null, values);
        db.close(); // Closing database connection
    }
  
    /**
     * Getting all labels
     * returns list of labels
     * */
    public List<String> getAllLabels(){
    	List<String> labels = new ArrayList<String>();
    	
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LABELS;
     
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	labels.add(cursor.getString(0)+"   -   "+cursor.getString(1));
            } while (cursor.moveToNext());
        }
        
        // closing connection
        cursor.close();
        db.close();
    	
    	// returning lables
    	return labels;
    }

	public Cursor rawQuery(String sql, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
