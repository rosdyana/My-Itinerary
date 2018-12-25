/*
 * Copyright (c) Rosdyana Kusuma - 2018.
 */

package com.sleepybear.myitinerary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.sleepybear.myitinerary.model.IteneraryModel;

import java.util.ArrayList;

public class IteneraryHelper {
    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public IteneraryHelper(Context context) {
        this.context = context;
    }

    public IteneraryHelper open() throws SQLException {
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<IteneraryModel> getValueByCategory(String category) {
        ArrayList<IteneraryModel> arrayList = new ArrayList<>();
        IteneraryModel iteneraryModel;
        Cursor cursor = sqLiteDatabase.query(DbContract.TABLE_ITENERARY,
                null,
                DbContract.IteneraryColumns.COL_CATEGORY + " like ?",
                new String[]{category},
                null, null,
                DbContract.IteneraryColumns._ID + " ASC", null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                iteneraryModel = new IteneraryModel();
                iteneraryModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns._ID)));
                iteneraryModel.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_TITLE)));
                iteneraryModel.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_CATEGORY)));
                iteneraryModel.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_DESC)));
                iteneraryModel.setDatetime(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_DATE)));
                iteneraryModel.setLatitude(cursor.getFloat(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_LATITUDE)));
                iteneraryModel.setLongitude(cursor.getFloat(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_LONGITUDE)));
                iteneraryModel.setStatus(cursor.getInt(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_STATUS)));

                arrayList.add(iteneraryModel);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public Cursor queryAllData() {
        return sqLiteDatabase.rawQuery("SELECT * FROM "
                + DbContract.TABLE_ITENERARY + " ORDER BY "
                + DbContract.IteneraryColumns._ID + " ASC", null);
    }

    public ArrayList<IteneraryModel> getAllData() {
        ArrayList<IteneraryModel> arrayList = new ArrayList<>();
        IteneraryModel iteneraryModel;

        Cursor cursor = queryAllData();
        cursor.moveToNext();
        if (cursor.getCount() > 0) {
            do {
                iteneraryModel = new IteneraryModel();
                iteneraryModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns._ID)));
                iteneraryModel.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_TITLE)));
                iteneraryModel.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_CATEGORY)));
                iteneraryModel.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_DESC)));
                iteneraryModel.setDatetime(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_DATE)));
                iteneraryModel.setLatitude(cursor.getFloat(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_LATITUDE)));
                iteneraryModel.setLongitude(cursor.getFloat(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_LONGITUDE)));
                iteneraryModel.setStatus(cursor.getInt(cursor.getColumnIndexOrThrow(DbContract.IteneraryColumns.COL_STATUS)));

                arrayList.add(iteneraryModel);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(IteneraryModel iteneraryModel) {
        ContentValues cv = new ContentValues();
        cv.put(DbContract.IteneraryColumns.COL_TITLE, iteneraryModel.getTitle());
        cv.put(DbContract.IteneraryColumns.COL_CATEGORY, iteneraryModel.getCategory());
        cv.put(DbContract.IteneraryColumns.COL_DATE, iteneraryModel.getDatetime());
        cv.put(DbContract.IteneraryColumns.COL_DESC, iteneraryModel.getDescription());
        cv.put(DbContract.IteneraryColumns.COL_LONGITUDE, iteneraryModel.getLongitude());
        cv.put(DbContract.IteneraryColumns.COL_LATITUDE, iteneraryModel.getLatitude());
        cv.put(DbContract.IteneraryColumns.COL_STATUS, iteneraryModel.getStatus());
        return sqLiteDatabase.insert(DbContract.TABLE_ITENERARY, null, cv);
    }

    public int update(IteneraryModel iteneraryModel) {
        ContentValues cv = new ContentValues();
        cv.put(DbContract.IteneraryColumns.COL_TITLE, iteneraryModel.getTitle());
        cv.put(DbContract.IteneraryColumns.COL_CATEGORY, iteneraryModel.getCategory());
        cv.put(DbContract.IteneraryColumns.COL_DATE, iteneraryModel.getDatetime());
        cv.put(DbContract.IteneraryColumns.COL_DESC, iteneraryModel.getDescription());
        cv.put(DbContract.IteneraryColumns.COL_LONGITUDE, iteneraryModel.getLongitude());
        cv.put(DbContract.IteneraryColumns.COL_LATITUDE, iteneraryModel.getLatitude());
        cv.put(DbContract.IteneraryColumns.COL_STATUS, iteneraryModel.getStatus());
        return sqLiteDatabase.update(DbContract.TABLE_ITENERARY, cv,
                DbContract.IteneraryColumns._ID + "='"
                        + iteneraryModel.getId() + "'", null);
    }

    public int delete(int id){
        return sqLiteDatabase.delete(DbContract.TABLE_ITENERARY, DbContract.IteneraryColumns._ID + " = '" + id + "'", null);
    }
}
