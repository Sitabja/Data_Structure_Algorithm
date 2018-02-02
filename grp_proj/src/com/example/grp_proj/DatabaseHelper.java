package com.example.grp_proj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
	private static String DB_PATH = ""; 
	private static final String DB_NAME = "customer.db";
	private SQLiteDatabase db;
    private final Context context;
    
    DatabaseHelper(Context context) {        	
    	super(context, DB_NAME, null, 1);// 1? its Database Version
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
                Log.e(TAG, "createDatabase database created");
            }catch (IOException e) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    
    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }
    
    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
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

  //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        db = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return db != null;
    }

    @Override
    public synchronized void close() {
        if(db != null)
        	db.close();
        super.close();
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}	     
}