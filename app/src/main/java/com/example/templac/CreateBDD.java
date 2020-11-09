package com.example.templac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class CreateBDD extends SQLiteOpenHelper
{
    public CreateBDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,name,factory, version);
    }


    //TABLE LAC ------------------------------------------------------------------------------------

    private static final String TABLE_LAC = "tlac";
    static final String COL_IDLAC = "_idLac";
    private static final String COL_NOM = "nomLac";
    private static final String COL_LATITUDE = "latitudeLac";
    private static final String COL_LONGITUDE = "longitudeLac";
    private static final String CREATE_TABLE_LAC = "CREATE TABLE " + TABLE_LAC + " ("+COL_IDLAC+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM + " TEXT NOT NULL, " + COL_LATITUDE + " TEXT NOT NULL, " + COL_LONGITUDE + " TEXT NOT NULL);";

    //TABLE RELEVE ---------------------------------------------------------------------------------

    private static final String TABLE_RELEVE = "treleve";
    static final String COL_IDRELEVE = "_idReleve";
    private static final String COL_LAC = "idLac";
    private static final String COL_dateReleve = "dateReleve";
    private static final String COL_heureReleve = "heureReleve";
    private static final String COL_tempReleve = "tempReleve";
    private static final String CREATE_TABLE_RELEVE = "CREATE TABLE " + TABLE_RELEVE + " ("+COL_IDRELEVE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_LAC + " TEXT NOT NULL, " + COL_dateReleve + " TEXT NOT NULL, " + COL_heureReleve+ " TEXT NOT NULL, " + COL_tempReleve + " TEXT NOT NULL);";


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_LAC);
        db.execSQL(CREATE_TABLE_RELEVE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LAC + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RELEVE + ";");
        onCreate(db);
    }
}
