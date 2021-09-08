package com.java.sd.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

  private static final String DBNAME="Offline.db";
    private static final int DBVERSION=35;
    SQLiteDatabase db;
   public Database (Context context)
   {
       super(context,DBNAME,null,DBVERSION);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table  if not exists 'high' (NAME TEXT,ATT TEXT)");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF  EXISTS 'high'");
    onCreate(db);
    }

    public String[] getName()
    {
        db = this.getReadableDatabase();
        String[] Columns = {"NAME","ATT"};
        String MyData = null;
        Cursor cursor = db.query("high", Columns, null, null, null, null, "ATT ASC");
            int Index=0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex("NAME")) != null) {
                if(MyData==null)
                MyData=cursor.getString(cursor.getColumnIndex("NAME"))+" \t\t\t\t "+cursor.getString(cursor.getColumnIndex("ATT"));
                else{
                    MyData=MyData+"#"+cursor.getString(cursor.getColumnIndex("NAME"))+"\t\t\t\t"+cursor.getString(cursor.getColumnIndex("ATT"));
                }

            }
        }


        try {
            String toReturn[] = MyData.split("#");
            return toReturn;
        }
        catch (Exception e)
        {
            return null;
        }

    }



    public void putName(String Name,String Attempts)
    {
        try {
            db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("NAME", Name);
            cv.put("ATT", Attempts);
            long login = db.insert("high", null, cv);
            db.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }




}

