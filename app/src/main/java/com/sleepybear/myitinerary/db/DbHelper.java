/*
 * Copyright (c) Rosdyana Kusuma - 2018.
 */

package com.sleepybear.myitinerary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "itenerary.db";
    private static final int DB_VERSION = 1;

    private static String CREATE_TABLE_ITENERARY = "create table "
            + DbContract.TABLE_ITENERARY + " ("
            + DbContract.IteneraryColumns._ID + " integer primary key autoincrement, "
            + DbContract.IteneraryColumns.COL_TITLE + " text not null, "
            + DbContract.IteneraryColumns.COL_CATEGORY + " text not null, "
            + DbContract.IteneraryColumns.COL_DESC + " text not null, "
            + DbContract.IteneraryColumns.COL_DATE + " text not null, "
            + DbContract.IteneraryColumns.COL_LONGITUDE + " real not null, "
            + DbContract.IteneraryColumns.COL_LATITUDE + " real not null, "
            + DbContract.IteneraryColumns.COL_STATUS + " integer not null);";

    public  DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ITENERARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + DbContract.TABLE_ITENERARY);
        onCreate(sqLiteDatabase);
    }
}
