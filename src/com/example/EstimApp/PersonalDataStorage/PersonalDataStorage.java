package com.example.EstimApp.PersonalDataStorage;

/**
 * Created by sersajur on 11.12.2015.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class PersonalDataStorage {

    public static PersonalDataStorage getInstance() {
        return ourInstance;
    }

    private static PersonalDataStorage ourInstance = new PersonalDataStorage();

    private PersonalDataStorage() {
    }

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
}
