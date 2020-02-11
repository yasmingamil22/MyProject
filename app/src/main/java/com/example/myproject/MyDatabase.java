package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME="student";
    public static final String CLM_ID="id";
    public static final String CLM_NAME="name";
    public static final String CLM_PHONE="phone";
    public static final String CLM_ADDRESS="adress";

    public static final int VERION=1;

    public MyDatabase(Context context){
        super(context,DB_NAME,null,VERION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL("CREATE TABLE "+DB_NAME+"("+CLM_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
    +CLM_NAME +" TEXT , "+CLM_PHONE +" TEXT , "+ CLM_ADDRESS +" Text )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
    onCreate(sqLiteDatabase);
    }
    public  boolean insert (Student student){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(CLM_NAME,student.getName());
        values.put(CLM_PHONE,student.getPhone());
        values.put(CLM_ADDRESS,student.getAddress());
        long result=db.insert(DB_NAME,null,values);
        return result!=-1;
    }
    public  boolean update (Student student){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(CLM_NAME,student.getName());
        values.put(CLM_PHONE,student.getPhone());
        values.put(CLM_ADDRESS,student.getAddress());
        String args[]={student.getName()+""};
        long result=db.update(DB_NAME,values,CLM_NAME+"=?",args);
        return result!=0;
    }

    public long gatStudentCount(){
        SQLiteDatabase db=getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db,DB_NAME);
    }

    public  boolean delete (Student student){
        SQLiteDatabase db=getWritableDatabase();
        String args[]={student.getName()+""};
        int result=db.delete(DB_NAME,CLM_NAME+"=?",args);
        return result>0;
    }
}
