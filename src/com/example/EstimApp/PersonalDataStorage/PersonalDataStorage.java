package com.example.EstimApp.PersonalDataStorage;

/**
 * Created by sersajur on 11.12.2015.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;

public class PersonalDataStorage {

    public static PersonalDataStorage getInstance(Context context) {
        if (instance == null)
            instance = new PersonalDataStorage(context);
        return instance;
    }

    public void StoreUserItemEstim(UserItemEstim userItemEstim){
        ContentValues values = new ContentValues();
        values.put(MySQLiteOpenHelper.COLUMN_LOGIN, userItemEstim.GetLogin());
        values.put(MySQLiteOpenHelper.COLUMN_WORK_ITEM_TITLE, userItemEstim.GetItemName());
        values.put(MySQLiteOpenHelper.COLUMN_ESTIM, userItemEstim.GetEstim());
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        long insertedItemId = db.insert(MySQLiteOpenHelper.TABLE_ESTIM_HISTORY, null, values);
    }

    public ArrayList<UserItemEstim> GetStoredUserItemEstims(){
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor query_result = db.rawQuery(SELECT_TABLE_ESTIM_HISTORY, null);
        ArrayList<UserItemEstim> userItemEstimArray = new ArrayList<UserItemEstim>();
        query_result.moveToFirst();
        while(query_result.isAfterLast() == false){
            UserItemEstim userItemEstim = new UserItemEstim(
                query_result.getString(query_result.getColumnIndex(dbhelper.COLUMN_LOGIN)),
                query_result.getString(query_result.getColumnIndex(dbhelper.COLUMN_WORK_ITEM_TITLE)),
                query_result.getInt(query_result.getColumnIndex(dbhelper.COLUMN_ESTIM)));
            userItemEstimArray.add(userItemEstim);
            query_result.moveToNext();
        }
        return userItemEstimArray;
    }

    private PersonalDataStorage(Context context) {
        dbhelper = new MySQLiteOpenHelper(context);
    }

    private static PersonalDataStorage instance;

    // db related:
    private MySQLiteOpenHelper dbhelper;
    private static final String SELECT_TABLE_ESTIM_HISTORY = "select * "
            + "from " + MySQLiteOpenHelper.TABLE_ESTIM_HISTORY;

    private class MySQLiteOpenHelper extends SQLiteOpenHelper {

        public static final String TABLE_ESTIM_HISTORY = "EstimHistory";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_WORK_ITEM_TITLE = "work_item_title";
        public static final String COLUMN_ESTIM = "estimation";

        public MySQLiteOpenHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database){
            database.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ESTIM_HISTORY);
            onCreate(db);
        }

        private static final String DATABASE_NAME = "PersonalData.db";
        private static final int DATABASE_VERSION = 1; //if you change db structure -- change db version.

        private static final String DATABASE_CREATE = "create table "
                + TABLE_ESTIM_HISTORY
                + "("
                + COLUMN_ID + " integer primary key autoincrement, "
                + COLUMN_LOGIN + " text not null, "
                + COLUMN_WORK_ITEM_TITLE + " text not null, "
                + COLUMN_ESTIM + " integer not null);";
    }
    public void SetCurrentLogin(String login){
        current_login = login;
    }
    public String GetCurrentLogin(){
        return current_login;
    }

    private String current_login;
}
