package com.example.mangeshaher.softapplication;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by mangeshaher on 2/11/17.
 */

public class BackGround extends AsyncTask<String,Row,String> {

    Context context;
    ListAdapter ls;
    Activity activity;
    ListView lv;
    BackGround(Context context){

        this.context=context;
        activity=(Activity)context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        DbMethods dbMethods=new DbMethods(context);
        String method =params[0];

        if(method.equals("add_info")){
            String name=params[1];
            int price=Integer.parseInt(params[2]);
            int rating=Integer.parseInt(params[3]);
            SQLiteDatabase db = dbMethods.getWritableDatabase();
            dbMethods.addInformations(db,name,price,rating);
            return "One Row Inserted............";
        }
        else if(method.equals("get_info")){
            lv = (ListView) activity.findViewById(R.id.customlist);
            SQLiteDatabase db =dbMethods.getReadableDatabase();
            Cursor cursor = dbMethods.getInformations(db);
            ls = new ListAdapter(context,R.layout.customlist);
            String name;
            int price , rating;
            while(cursor.moveToNext()){
                name = cursor.getString(cursor.getColumnIndex(DatabaseStructure.ProductEntry.NAME));
                price = cursor.getInt(cursor.getColumnIndex(DatabaseStructure.ProductEntry.PRICE));
                rating = cursor.getInt(cursor.getColumnIndex(DatabaseStructure.ProductEntry.RATING));
                Row r = new Row(name,price,rating);
                publishProgress(r);
            }
            return "get_info";
        }
        else if(method.equals("price")){
            lv = (ListView) activity.findViewById(R.id.customlist);
            SQLiteDatabase db =dbMethods.getReadableDatabase();
            Cursor cursor = dbMethods.getPriceSorted(db);
            ls = new ListAdapter(context,R.layout.customlist);
            String name;
            int price , rating,val;
            String limit =params[1];
            if(limit.length()!=0){
                val=Integer.parseInt(limit);
            }
            else{
                val=0;
            }
            while(cursor.moveToNext()){
                name = cursor.getString(cursor.getColumnIndex(DatabaseStructure.ProductEntry.NAME));
                price = cursor.getInt(cursor.getColumnIndex(DatabaseStructure.ProductEntry.PRICE));
                rating = cursor.getInt(cursor.getColumnIndex(DatabaseStructure.ProductEntry.RATING));
                if(price>=val&&val!=0) {
                    Row r = new Row(name, price, rating);
                    publishProgress(r);
                }
                else if (val==0){
                    Row r = new Row(name, price, rating);
                    publishProgress(r);
                }
            }
            return "price";
        }
        else if(method.equals("rating")){
            lv = (ListView) activity.findViewById(R.id.customlist);
            SQLiteDatabase db =dbMethods.getReadableDatabase();
            Cursor cursor = dbMethods.getRatingSorted(db);
            ls = new ListAdapter(context,R.layout.customlist);
            String name;
            int price , rating,val;
            String limit =params[1];
            if(limit.length()!=0){
                val=Integer.parseInt(limit);
            }
            else{
                val=0;
            }
            while(cursor.moveToNext()){
                name = cursor.getString(cursor.getColumnIndex(DatabaseStructure.ProductEntry.NAME));
                price = cursor.getInt(cursor.getColumnIndex(DatabaseStructure.ProductEntry.PRICE));
                rating = cursor.getInt(cursor.getColumnIndex(DatabaseStructure.ProductEntry.RATING));
                if(rating<=val&&val!=0) {

                    Row r = new Row(name, price, rating);
                    publishProgress(r);
                }
                else if (val==0){
                    Row r = new Row(name, price, rating);
                    publishProgress(r);
                }
            }
            return "rating";
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Row... values) {
        ls.add(values[0]);
    }

    @Override
    protected void onPostExecute(String res) {
        if(res.equals("get_info")){
            lv.setAdapter(ls);
        }
        else if(res.equals("price")){
            lv.setAdapter(ls);
        }
        else if(res.equals("rating")){
            lv.setAdapter(ls);
        }
        else{
            Toast.makeText(context,res, Toast.LENGTH_LONG).show();
        }

    }
}
