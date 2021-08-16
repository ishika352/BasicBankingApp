package com.example.basicbankingapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "accounts.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 2;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'yogesh kumar', 'yogesh@gmail.com','8584','9595623138', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'samar varshney', 'samar@gmail.com','2258','9263561542', 18000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'nilesh chandel', 'nilesh@gmail.com','4896','7595645896', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'ayush jain', 'ayush@gmail.com','9752','9995640038', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'rachel green', 'rachel@gmail.com','1669','7425192032', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'farha joshi', 'farha@gmail.com','5985','8855640238', 8500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'garv gupta', 'garv@gmail.com','7207','8895640215', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'rajat sharma', 'rajat@gmail.com','3522','9985021539', 20500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Ritika Suryavanshi', 'ritika@gmail.com','6582','9309565238', 20500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohan mehra', 'rohan@gmail.com','1450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'mohit kumar', 'mohit@gmail.com','2656','9015641200', 9100)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Himani garg', 'himani@gmail.com','1203','9247154829', 1800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'jahnvi sharma', 'jahnvi@gmail.com','5566','7119541001', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Gaurav vats', 'gaurav@gmail.com','2236','8254642205', 8600)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Faheem zone', 'faheem@gmail.com','6692','8893641266', 4310)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}