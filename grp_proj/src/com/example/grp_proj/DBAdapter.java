package com.example.grp_proj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//import com.example.login.DBAdapter;
//import com.example.login.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    static final String KEY_ROWID = "row_id";
    static final String KEY_id = "customer_id";
    static final String KEY_contact = "contact_no";
    static final String TAG = "DBAdapter";
    private static String DB_PATH = ""; 
    static final String DATABASE_NAME = "customer.db";
    static final String DATABASE_TABLE = "customer_details";
    static final int DATABASE_VERSION = 1;
    //static final int DATABASE_VERSION = 2;

   
     //SQLiteDatabase has methods to create, delete, execute SQL commands, 
    //and perform other common database management tasks. 
    SQLiteDatabase db;
    DatabaseHelper DBHelper;
    private final Context context;

    public DBAdapter(Context ctx) {
        context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    public DBAdapter createDatabase() throws SQLException {
        try {
        	DBHelper.createDataBase();        	
        }catch (IOException e) {
            Log.e(TAG, e.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }
    
    private static class DatabaseHelper extends SQLiteOpenHelper {
    	private Context context;
    	
        DatabaseHelper(Context context) {
        	super(context, DATABASE_NAME, null, DATABASE_VERSION);
        	this.context=context;
        	//Create a helper object to create, open, and/or manage a database. 
        	//The database is not actually created or opened until one of 
        	//getWritableDatabase() or getReadableDatabase() is called.
            
            if(android.os.Build.VERSION.SDK_INT >= 4.2) {        	
            	DB_PATH = context.getApplicationInfo().dataDir + "/databases/";         
            } else {        	
            	//DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
            	DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
            }
            
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
                    Log.e(TAG, "createDatabase database created");
                }catch (IOException e) {
                    throw new Error("ErrorCopyingDataBase");
                }
            }
        }
        
      //Check that the database exists here: /data/data/your package/databases/Da Name
        private boolean checkDataBase() {
            File dbFile = new File(DB_PATH + DATABASE_NAME);
            //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
            return dbFile.exists();
        }
        
      //Copy the database from assets
        private void copyDataBase() throws IOException {
            InputStream mInput = context.getAssets().open(DATABASE_NAME);
            Log.e(TAG, "checkDataBase ............"+DB_PATH);
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
		public void onCreate(SQLiteDatabase arg0) {
			// TODO Auto-generated method stub
			
		}




		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
    }

    //---opens the database---
    public DBAdapter open() throws SQLException {
    	//Create and/or open a database that will be used for reading and writing. 
    	//The first time this is called, the database will be opened and 
    	//onCreate(SQLiteDatabase), onUpgrade(SQLiteDatabase, int, int) 
    	//and/or onOpen(SQLiteDatabase) will be called. 
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() { 
    	//Close any open database object. 
    	DBHelper.close(); 
    }

    //---insert a contact into the database---
    public void insertContact(String s1, String s2) {
    	//Creates an empty set of values using the default initial size. 
        ContentValues initialValues = new ContentValues();        
        initialValues.put(KEY_id, s1); //Adds a value to the set.
        initialValues.put(KEY_contact, s2);
        //Inserts a row into the database.
        //Returns the row ID of the newly inserted row, or -1 if an error occurred 
        db.insert(DATABASE_TABLE, null, initialValues); 
    }

	  public Cursor getALabel(String label) throws SQLException {
        Cursor mCursor = db.query(true,DATABASE_TABLE  , new String[] {KEY_ROWID,KEY_id,KEY_contact}, 
        								KEY_id + "='" + label+"'", null, null, null, null, null); 
        if (mCursor.moveToFirst()) {
            return mCursor;
        }else
        	return null;        
    }

    
   
 
   
}