package com.example.grp_proj;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class labels1 {
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "spinnerExample.db";
 
    // Labels table name
    private static final String TABLE_LABELS = "labels";
 
    // Labels Table Columns names
    private static final String KEY_ROWID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_QTY = "quantity";
    DatabaseHelper DBHelper;
    final Context context;
    SQLiteDatabase db;
  static int w=0,x=0,y=0,z=0;
  
    public void lap_total(int i )
    { w=w+i;
    
    }
    public void cam_total(int i )
    { x+=i;
    
    }
    public  void mob_total(int i )
    { y+=i;
     
    }
    public  void tab_total(int i )
    { z+=i;
    
    }
    
    public labels1(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
        	//Create a helper object to create, open, and/or manage a database. 
        	//The database is not actually created or opened until one of 
        	//getWritableDatabase() or getReadableDatabase() is called.
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        
        //Creates a new database if the required database is not present.
     /**   public void onCreate(SQLiteDatabase db) {
            try {
            	String TAB = "CREATE TABLE " + TABLE_LABELS + "(_id integer primary key autoincrement, " 
            							+ KEY_NAME + " TEXT," + KEY_QTY + " INTEGER)";
                db.execSQL(TAB);
            } catch (SQLException e) { e.printStackTrace(); }
        }**/

        
        //Called when the database needs to be upgraded.
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("ppp", "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }


		@Override
		public void onCreate(SQLiteDatabase arg0) {
			// TODO Auto-generated method stub
			
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
  /**  public void insertLabel(String item_name, int qty){    	
    	ContentValues values = new ContentValues();
    	values.put(KEY_NAME, item_name);
    	values.put(KEY_QTY, qty); 
        db.insert(TABLE_LABELS, null, values);      
    }**/
    
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
    public static int total() {    
    	//Log.w("ppp", "1111111111111111 w="+w);
      int total=w+x+y+z;
      return total;
    }
  
    public boolean updateLabel_Qty(long rowId, int cur_qty, int add_qty) {
        ContentValues args = new ContentValues();
        args.put(KEY_QTY, Integer.toString(cur_qty-add_qty));
        return db.update(TABLE_LABELS, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
   
 /**   public List<String> getAllLabels2(){
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
**/
	public Cursor rawQuery(String sql, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}


