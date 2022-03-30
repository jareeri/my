package com.example.login12;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBConnections extends SQLiteOpenHelper {

    public static final String DBName="users";
    public static final int Verson=1;



    public DBConnections(Context context){
        super(context,DBName,null,Verson);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists admin (id INTEGER primary key ,name TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldv, int newv) {
        db.execSQL("Drop table if EXISTS admin");
        onCreate(db);

    }

    public void InsertRowAdmin (String userid ,String pass){

        ContentValues contentValues=new ContentValues();
        SQLiteDatabase db=this.getWritableDatabase();
        contentValues.put("userid",userid);
        contentValues.put("pass", pass);
        db.insert("users",null,contentValues);

    }

    @SuppressLint("Range")
    public ArrayList getuser(){
        SQLiteDatabase db =this.getReadableDatabase();
        ArrayList arrayuser=new ArrayList();
        Cursor res =db.rawQuery("select userid from users",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            arrayuser.add(res.getString(res.getColumnIndex("userid")));
        }
        return arrayuser;
    }

    @SuppressLint("Range")
    public ArrayList getpass(){
        SQLiteDatabase db =this.getReadableDatabase();
        ArrayList arraypass=new ArrayList();
        Cursor res =db.rawQuery("select pass from users",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            arraypass.add(res.getString(res.getColumnIndex("pass")));
        }
        return arraypass;
    }

    @SuppressLint("Range")
    public ArrayList getAllrecord(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res =db.rawQuery("select * from users",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
        arrayList.add(res.getString(res.getColumnIndex("name")));

        }
        return arrayList;
    }

}
