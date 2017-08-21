package com.instinctcoder.sqlitedbmultitbl.data.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.instinctcoder.sqlitedbmultitbl.data.DatabaseManager;
import com.instinctcoder.sqlitedbmultitbl.data.model.Student;

import java.util.List;

/**
 * Created by Tan on 1/26/2016.
 */
public class StudentRepo  {

    private Student student;

    public StudentRepo(){

        student= new Student();

    }


    public static String createTable(){
        return "CREATE TABLE " + Student.TABLE  + "("
                + Student.KEY_StudID  + " TEXT PRIMARY KEY  ,"
                + Student.KEY_Name + " TEXT, "
                + Student.KEY_MajorId  + " TEXT )";
    }



    public void insert(Student student) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Student.KEY_StudID, student.getStudentId());
        values.put(Student.KEY_Name, student.getName());
        values.put(Student.KEY_MajorId, student.getMajor());

        // Inserting Row
        db.insert(Student.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Student.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }





}
