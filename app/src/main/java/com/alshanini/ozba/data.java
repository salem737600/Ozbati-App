package com.alshanini.ozba;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import androidx.annotation.Nullable;


public class data extends SQLiteOpenHelper {
    public int count1=130;

    public static final String dbname="data.db";

    public data(@Nullable Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,phone TEXT)");
        db.execSQL("create table mytable2(name INTEGER)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mytable");
        db.execSQL("DROP TABLE IF EXISTS myresult");
        onCreate(db);
    }

    public Cursor alldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select *from mytable ",null);
        return cursor;
    }




    public boolean insertdata(String name,String phone){
        count1++;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("name",name);
        contentValues.put("phone",phone);

        long result=db.insert("mytable",null,contentValues);
        if (result==-1)
            return false;
        else
            return  true;


    }

    public String getstr(Integer id) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where id=?", new String[]{String.valueOf(id)});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(2);

            str1 = t2;
            res.moveToNext();
        }
        return str1;

    }



    public String getsring(Integer id) {

        String str1 = new String();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable where id=?", new String[]{Integer.toString(id)});
        res.moveToNext();


        while (res.isAfterLast() == false) {

            String t2 = res.getString(1);

            str1 = t2;
            res.moveToNext();
        }
        return str1;


    }


    public ArrayList getAllrecords1(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from mytable  ",null);
        res.moveToNext();
        while (res.isAfterLast()==false){
            String t1=res.getString(0);
            String t2=res.getString(1);
            String t3=res.getString(2);
            arrayList.add(t1+":"+t2+"   "+t3);
            res.moveToNext();
        }
        return arrayList;

    }


    public  boolean updateData(String id,String name,String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        db.update("mytable", contentValues, "id=?", new String[]{id});
        return true;
    }


    public  Integer updateData2(String id,Integer name,String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        db.update("mytable", contentValues, "id=?", new String[]{id});
        return name;
    }
    public Integer delete(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("mytable","id=?",new String[]{id});
    }


}

