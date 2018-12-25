/*
 * Copyright (c) Rosdyana Kusuma - 2018.
 */

package com.sleepybear.myitinerary.db;

import android.provider.BaseColumns;

public class DbContract {
    static String TABLE_ITENERARY = "table_itenerary";

    static final class IteneraryColumns implements BaseColumns{
        static String COL_CATEGORY = "category";
        static String COL_TITLE = "title";
        static String COL_DESC = "description";
        static String COL_DATE = "datetime";
        static String COL_LONGITUDE = "longitude";
        static String COL_LATITUDE = "latitude";
        static String COL_STATUS = "status";
    }
}
