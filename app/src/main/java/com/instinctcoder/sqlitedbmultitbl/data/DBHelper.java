package com.instinctcoder.sqlitedbmultitbl.data;

/**
 * Created by Tan on 1/26/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.instinctcoder.sqlitedbmultitbl.app.App;
import com.instinctcoder.sqlitedbmultitbl.data.model.Course;
import com.instinctcoder.sqlitedbmultitbl.data.model.Major;
import com.instinctcoder.sqlitedbmultitbl.data.model.Student;
import com.instinctcoder.sqlitedbmultitbl.data.model.StudentCourse;
import com.instinctcoder.sqlitedbmultitbl.data.repo.CourseRepo;
import com.instinctcoder.sqlitedbmultitbl.data.repo.MajorRepo;
import com.instinctcoder.sqlitedbmultitbl.data.repo.StudentCourseRepo;
import com.instinctcoder.sqlitedbmultitbl.data.repo.StudentRepo;


public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION =8;
    // Database Name
    private static final String DATABASE_NAME = "sqliteDBMultiTbl.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL(CourseRepo.createTable());
        db.execSQL(StudentRepo.createTable());
        db.execSQL(MajorRepo.createTable());
        db.execSQL(StudentCourseRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Course.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Major.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + StudentCourse.TABLE);
        onCreate(db);
    }

}