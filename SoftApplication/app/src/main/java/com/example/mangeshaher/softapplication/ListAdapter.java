package com.example.mangeshaher.softapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mangeshaher on 2/11/17.
 */

public class ListAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public ListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }


    public void add(@Nullable Row object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ProductHolder ph;
        if(row==null){
            LayoutInflater li = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = li.inflate(R.layout.customlist,parent,false);
            ph=new ProductHolder();

            ph.a = (TextView) row.findViewById(R.id.name);
            ph.b = (TextView) row.findViewById(R.id.price);
            ph.c = (TextView) row.findViewById(R.id.rating);

            row.setTag(ph);
        }
        else{
            ph = (ProductHolder)row.getTag();
        }

        Row product = (Row)getItem(position);
        ph.a.setText(product.getName().toString());
        ph.b.setText(Integer.toString(product.getPrice()));
        ph.c.setText(Integer.toString(product.getRating()));

        return row;
    }

    static class ProductHolder{
        TextView a,b,c;

    }
}
