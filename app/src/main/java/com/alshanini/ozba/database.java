package com.alshanini.ozba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import androidx.annotation.Nullable;


public class database extends SQLiteOpenHelper {
    public int count1 = 130;

    public static final String dbname = "database.db";

    public database(@Nullable Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable(id TEXT,phone TEXT,phone1 TEXT,phone2 TEXT,id1 INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("create table mytable1(id TEXT,phone TEXT,phone1 TEXT,phone2 TEXT,id1 INTEGER PRIMARY KEY AUTOINCREMENT)");




    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mytable");
        db.execSQL("DROP TABLE IF EXISTS mytable1");
        onCreate(db);
    }


    public boolean insert1(String id, String phone) {
        count1++;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", id);
        contentValues.put("phone", phone);
        long result = db.insert("mytable1", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }


    public String getstr(Integer id) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where id=?", new String[]{String.valueOf(id)});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(4);

            str1 = t2;
            res.moveToNext();
        }
        return str1;

    }
    public ArrayList getAllrecords1() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable  ", null);
        res.moveToNext();
        while (res.isAfterLast() == false) {
            String t1 = res.getString(0);
            String t2 = res.getString(1);
            String t3 = res.getString(2);
            String t4 = res.getString(4);

            arrayList.add(t1 + ":" + t2 + "   " + t3+"  "+t4);
            res.moveToNext();
        }
        return arrayList;
    }



    public boolean insertdata(String id, String phone) {
        count1++;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", id);
        contentValues.put("phone", phone);
        long result = db.insert("mytable", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }


    public String getstring(String phone) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where Phone=?", new String[]{phone});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(0);

            str1 = t2;
            res.moveToNext();
        }
        return str1;

    }

    public String getstring1(String phone1) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where Phone1=?", new String[]{phone1});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(0);

            str1 = t2;
            res.moveToNext();
        }
        return str1;


    }
    public String getstring2(String phone2) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where Phone2=?", new String[]{phone2});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(0);

            str1 = t2;
            res.moveToNext();
        }
        return str1;


    }
    public String getphone(String id) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where id=?", new String[]{id});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(1);

            str1 = t2;
            res.moveToNext();
        }
        return str1;

    }
    public String getphone1(String id) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where id=?", new String[]{id});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(2);

            str1 = t2;
            res.moveToNext();
        }
        return str1;

    }
    public String getphone2(String id) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where id=?", new String[]{id});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(3);

            str1 = t2;
            res.moveToNext();
        }
        return str1;

    }



    public Integer delete(String phone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("mytable","phone=?",new String[]{phone});
    }


    public ArrayList getAllrecords(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from mytable  ",null);
        res.moveToNext();
        while (res.isAfterLast()==false){
            String t2=res.getString(1);

            arrayList.add(t2);
            res.moveToNext();
        }
        return arrayList;

    }

}

