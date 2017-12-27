package com.example.mangeshaher.softapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mangeshaher on 2/11/17.
 */

public class DbMethods extends SQLiteOpenHelper {
    private static final int DB_VERSION =1;
    private static final String DB_NAME ="product_info.db";
    private static final String QUERY ="create table "+ DatabaseStructure.ProductEntry.TABLE_NAME+
            "("+ DatabaseStructure.ProductEntry.NAME+ " text,"+DatabaseStructure.ProductEntry.PRICE+
             " integer,"+ DatabaseStructure.ProductEntry.RATING+ " integer);";
    DbMethods(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        Log.d("Database methods","Database Created....");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY);
        Log.d("Database Operations","Table Created.....");
    }

    public void addInformations(SQLiteDatabase db,String name,int rating ,int price){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseStructure.ProductEntry.NAME,name);
        contentValues.put(DatabaseStructure.ProductEntry.PRICE,price);
        contentValues.put(DatabaseStructure.ProductEntry.RATING,rating);
        db.insert(DatabaseStructure.ProductEntry.TABLE_NAME,null,contentValues);
        Log.d("Database Operations","One Row Inserted");

    }


    public Cursor getInformations(SQLiteDatabase db){
        String[] projections ={DatabaseStructure.ProductEntry.NAME,DatabaseStructure.ProductEntry.PRICE,DatabaseStructure.ProductEntry.RATING};
        Cursor cursor= db.query(DatabaseStructure.ProductEntry.TABLE_NAME,projections,null,null,null,null,null );
        return cursor;
    }

    public Cursor getPriceSorted(SQLiteDatabase db){
        String[] projections ={DatabaseStructure.ProductEntry.NAME,DatabaseStructure.ProductEntry.PRICE,DatabaseStructure.ProductEntry.RATING};
        Cursor cursor= db.query(DatabaseStructure.ProductEntry.TABLE_NAME,projections,null,null,null,null, DatabaseStructure.ProductEntry.PRICE + " DESC");
        return cursor;
    }

    public Cursor getRatingSorted(SQLiteDatabase db){
        String[] projections ={DatabaseStructure.ProductEntry.NAME,DatabaseStructure.ProductEntry.PRICE,DatabaseStructure.ProductEntry.RATING};
        Cursor cursor= db.query(DatabaseStructure.ProductEntry.TABLE_NAME,projections,null,null,null,null,DatabaseStructure.ProductEntry.RATING + " ASC");
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
