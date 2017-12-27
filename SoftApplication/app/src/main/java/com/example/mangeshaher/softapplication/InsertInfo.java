package com.example.mangeshaher.softapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by mangeshaher on 2/11/17.
 */

public class InsertInfo extends Activity {
    EditText a,b,c;
    String name,price,rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        a=(EditText)findViewById(R.id.editText);
        b=(EditText)findViewById(R.id.editText1);
        c=(EditText)findViewById(R.id.editText2);
    }

    public void insertData(View view){
        name=a.getText().toString();
        price=b.getText().toString();
        rating=c.getText().toString();
        BackGround bg = new BackGround(this);
        bg.execute("add_info",name,price,rating);
    }
}
