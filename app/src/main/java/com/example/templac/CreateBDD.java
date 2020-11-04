package com.example.templac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CreateBDD extends SQLiteOpenHelper

{
    public CreateBDD( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //TABLE LAC ------------------------------------------------------------------------------------

    private static final String TABLE_LAC = "tlac";
    static final String COL_ID = "_id";
    private static final String COL_NOM = "nomLac";
    private static final String COL_LONGITUDE = "longitudeLac";
    private static final String COL_LATITUDE = "latitudeLac";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_LAC + " ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM + " TEXT NOT NULL, " + COL_LONGITUDE + " TEXT NOT NULL, " + COL_LATITUDE + " TEXT NOT NULL);";

//

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
