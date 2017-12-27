package com.example.mangeshaher.softapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Firebase fRef;
    ListView listView;
    EditText et ;
    private ArrayList<String> qname=new ArrayList<>();
    private ArrayList<String> rname=new ArrayList<>();
    private ArrayList<String> sname=new ArrayList<>();
    private ArrayList<String> qkeys=new ArrayList<>();
    private ArrayList<String> rkeys=new ArrayList<>();
    private ArrayList<String> skeys=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.customlist);
        Custom_List cl=new Custom_List();


        fRef = new Firebase("https://softapp-ffd7c.firebaseio.com/items/name");

        final ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,qname);

        fRef.addChildEventListener(new com.firebase.client.ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String val =dataSnapshot.getValue().toString();
                qname.add(val);
                String key = dataSnapshot.getKey();
                qkeys.add(key);
                adp.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue().toString();
                String key=dataSnapshot.getKey();
                int index = qkeys.indexOf(key);
                qname.set(index,value);
                adp.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        listView.setAdapter(adp);

        fRef = new Firebase("https://softapp-ffd7c.firebaseio.com/items/rating");

        final ArrayAdapter<String> bdp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rname);

        fRef.addChildEventListener(new com.firebase.client.ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String val =dataSnapshot.getValue().toString();
                rname.add(val);
                String key = dataSnapshot.getKey();
                rkeys.add(key);
                bdp.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue().toString();
                String key=dataSnapshot.getKey();
                int index = rkeys.indexOf(key);
                rname.set(index,value);
                bdp.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        listView.setAdapter(bdp);
        fRef = new Firebase("https://softapp-ffd7c.firebaseio.com/items/price");

        final ArrayAdapter<String> cdp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rname);

        fRef.addChildEventListener(new com.firebase.client.ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String val =dataSnapshot.getValue().toString();
                sname.add(val);
                String key = dataSnapshot.getKey();
                skeys.add(key);
                cdp.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue().toString();
                String key=dataSnapshot.getKey();
                int index = skeys.indexOf(key);
                sname.set(index,value);
                cdp.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        listView.setAdapter(cdp);
        listView.setAdapter(cl);

    }

    public class Custom_List extends BaseAdapter {

        @Override
        public int getCount() {
            return qname.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_list,null);
            TextView name=(TextView) view.findViewById(R.id.name);
            TextView rating=(TextView)view.findViewById(R.id.rating);
            TextView price=(TextView)view.findViewById(R.id.price);
            name.setText(qname.get(i));
            rating.setText(rname.get(i));
            price.setText(sname.get(i));
            return view;
        }
    }

    public void onCheckbox1Clicked(View view){
        et=(EditText)view.findViewById(R.id.aher);
        int limit = Integer.parseInt(String.valueOf(et.getText()));
        ArrayList<String> tname=new ArrayList<>();
        ArrayList<String> uname=new ArrayList<>();
        ArrayList<String> vname=new ArrayList<>();
        String x;
        int count=0;
        for(int i=0;i<rname.size();i++){
            x=rname.get(i);
            int rate=Integer.parseInt(x);
            if(rate>limit){
                tname.add(x);
                count++;
            }
        }

    }

}
