package com.example.grp_proj;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter1 {     
	protected static final String TAG = "DataAdapter";
	private final Context context;
	private SQLiteDatabase db;
    DatabaseHelper DBHelper;    
    
    public DBAdapter1(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    
    public DBAdapter1 createDatabase() throws SQLException {
        try {
        	DBHelper.createDataBase();
        }catch (IOException e) {
            Log.e(TAG, e.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DBAdapter1 open() throws SQLException {
    	try {
    		DBHelper.openDataBase();
    		DBHelper.close();
            db = DBHelper.getReadableDatabase();
        }catch (SQLException e) {
            Log.e(TAG, "open >>"+ e.toString());
            throw e;
        }
        return this;
    }

    public void close() { DBHelper.close(); }
    
    public Cursor getTestData(String id, String pwd) {
        try {
            String sql ="SELECT * FROM customer_details where customer_id='"+id
            					+"' and contact_no='"+pwd+"'";
            Cursor mCur = db.rawQuery(sql, null);
            if (mCur!=null) {
               mCur.moveToNext();
            }
            return mCur;
            
        }catch (SQLException e) {
            Log.e(TAG, "getTestData >>"+ e.toString());
            throw e;
        }
    }
   
    /*public long insertData(String id, String pwd) {
        ContentValues initialValues = new ContentValues();        
        initialValues.put("id", id); 
        initialValues.put("pwd", pwd);
        return db.insert("users", null, initialValues); 
    }*/
    
    /*public Cursor getContact(String txtid, String txtpwd) throws SQLException {
        Cursor mCursor = db.query(true, "users", new String[] {"id", "pwd"}, 
        									"id='" + txtid + "' and pwd='" + txtpwd + "'", null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }    */
}
