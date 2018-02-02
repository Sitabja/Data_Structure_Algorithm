package com.example.grp_proj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Labels {
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "spinnerExample.db";
    private static String DB_PATH="";
 
    // Labels table name
    private static final String TABLE_LABELS = "labels";
 
    // Labels Table Columns names
    private static final String KEY_ROWID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_QTY = "quantity";
    DatabaseHelper DBHelper;
    final Context context;
    SQLiteDatabase db;
    
    public Labels(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    
    private static class DatabaseHelper extends SQLiteOpenHelper {
    	 private Context context;

		DatabaseHelper(Context context) {        	
    	    	super(context, DATABASE_NAME, null, 1);// 1? its Database Version
    	        if(android.os.Build.VERSION.SDK_INT >= 4.2) {        	
    	        	DB_PATH = context.getApplicationInfo().dataDir + "/databases/";         
    	        } else {        	
    	        	//DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
    	        	DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
    	        }
    	        this.context = context;
    	    }
    
        public void createDataBase() throws IOException {
            //If database not exists copy it from the assets
            boolean mDataBaseExist = checkDataBase();
            if(!mDataBaseExist) {
                this.getReadableDatabase();
                this.close();
                try {
                    //Copy the database from assets
                    copyDataBase();
                     // Log.e(TAG, "createDatabase database created");
                }catch (IOException e) {
                    throw new Error("ErrorCopyingDataBase");
                }
            }
        }
        private boolean checkDataBase() {
            File dbFile = new File(DB_PATH + DATABASE_NAME);
            //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
            return dbFile.exists();
        }
        
        //Copy the database from assets
        private void copyDataBase() throws IOException {
            InputStream mInput = context.getAssets().open(DATABASE_NAME);
            String outFileName = DB_PATH + DATABASE_NAME;
            OutputStream mOutput = new FileOutputStream(outFileName);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while ((mLength = mInput.read(mBuffer)) > 0) {
                mOutput.write(mBuffer, 0, mLength);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();
        }
        @Override
        //Creates a new database if the required database is not present.
        public void onCreate(SQLiteDatabase db) {
            try {
            	String TAB = "CREATE TABLE " + TABLE_LABELS + "(_id integer primary key autoincrement, " 
            							+ KEY_NAME + " TEXT," + KEY_QTY + " INTEGER)";
                db.execSQL(TAB);
            } catch (SQLException e) { e.printStackTrace(); }
        }

        @Override
        //Called when the database needs to be upgraded.
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("ppp", "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }
    
    public void open() throws SQLException {    	
        db = DBHelper.getWritableDatabase();
        //return this;
    }
    
    public void close() { 
    	DBHelper.close(); 
    }
    
    /**
     * Inserting new lable into lables table
     * */
    public void insertLabel(String item_name, int qty){    	
    	ContentValues values = new ContentValues();
    	values.put(KEY_NAME, item_name);
    	values.put(KEY_QTY, qty); 
        db.insert(TABLE_LABELS, null, values);        
    }
    
    public Cursor getALabel(String label) throws SQLException {
        Cursor mCursor = db.query(true, TABLE_LABELS, new String[] {KEY_ROWID, KEY_NAME, KEY_QTY}, 
        								KEY_NAME + "='" + label+"'", null, null, null, null, null); 
        if (mCursor.moveToFirst()) {
            return mCursor;
        }else
        	return null;        
    }
    
    public Cursor getAllLabels1() {
        return db.query(TABLE_LABELS, new String[] {KEY_NAME, KEY_QTY}, null, null, null, null, null);
    }
  
    public boolean updateLabel_Qty(long rowId, int cur_qty, int add_qty) {
        ContentValues args = new ContentValues();
        args.put(KEY_QTY, Integer.toString(cur_qty+add_qty));
        return db.update(TABLE_LABELS, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
   
    public List<String> getAllLabels2(){
    	//db.open(); 
    	List<String> labels = new ArrayList<String>();      
        //SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_LABELS, null);     
        if (cursor.moveToFirst()) {
            do {
            	labels.add(cursor.getString(1)+"   -   "+cursor.getInt(2));
            } while (cursor.moveToNext());
        }        
        cursor.close();
        //db.close();    	
    	return labels;
    }

	public Cursor rawQuery(String sql, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createDataBase() {
		// TODO Auto-generated method stub
		
	}
}

