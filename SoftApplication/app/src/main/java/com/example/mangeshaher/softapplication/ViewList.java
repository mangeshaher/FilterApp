package com.example.mangeshaher.softapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mangeshaher on 2/11/17.
 */

public class ViewList extends Activity {
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlist);
        BackGround bg = new BackGround(this);
        ed=findViewById(R.id.editText);
        String x=(String) ed.getText().toString();
        bg.execute("get_info",x);
    }
    public void onpriceClicked(View view){
        String x=ed.getText().toString();
        BackGround bg = new BackGround(this);
        bg.execute("price",x);
    }
    public void onratingClicked(View view){
        String x=ed.getText().toString();
        BackGround bg = new BackGround(this);
        bg.execute("rating",x);
    }

}
