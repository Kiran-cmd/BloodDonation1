package com.example.kiran.blooddonation1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";
    public static final String COL_1="ID";
    public static final String COL_2="UserName";
    public static final String COL_3="PhoneNO";
    public static final String COL_4="BloodGroup";
    public static final String COL_5="Password";
    public static final String COL_6 = "Location";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, UserName TEXT, PhoneNO INTEGER, BloodGroup TEXT, Password TEXT,Location TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser(String userName, String PhoneNo, String BloodGrp, String Pass, String loc)
    {
        SQLiteDatabase sdb = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("UserName",userName);
        contentValues.put("PhoneNO",PhoneNo);
        contentValues.put("BloodGroup",BloodGrp);
        contentValues.put("Password",Pass);
        contentValues.put("Location", loc);
        long res= sdb.insert("registeruser",null,contentValues);
        sdb.close();
        return res;
    }

//to check weather user exist or not...

    public boolean chckuser(String userName, String Password){
        String[] coloums = { COL_1 };
        SQLiteDatabase db= getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_5 + "=?";
        String[] selectionArgs={ userName,Password };
        Cursor cursor= db.query(TABLE_NAME,coloums,selection,selectionArgs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return  true;
        else
            return false;

    }

   public  Cursor addData(){
                SQLiteDatabase db1 = this.getWritableDatabase();
                Cursor cursor=db1.rawQuery("select BloodGroup from TABLE_NAME", null);

        return cursor;
    }


    public ArrayList<HashMap<String, String>> GetSearchBloodResult(String loc, String bgrp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT userName, PhoneNO, BloodGroup, Location FROM " + TABLE_NAME + " WHERE Location='" + loc + "' AND BloodGroup='" + bgrp + "'";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("name", cursor.getString(cursor.getColumnIndex(COL_2)));
            user.put("phoneNO", cursor.getString(cursor.getColumnIndex(COL_3)));
            user.put("location", cursor.getString(cursor.getColumnIndex(COL_6)));
            user.put("bloodgroup", cursor.getString(cursor.getColumnIndex(COL_4)));
            userList.add(user);
        }
        return userList;
    }

}
