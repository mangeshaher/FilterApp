package com.example.mangeshaher.softapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mangeshaher on 3/11/17.
 */

public class Main extends Activity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Name=(EditText) findViewById(R.id.etName);
        Password=(EditText) findViewById(R.id.etPassword);
        Login=(Button) findViewById(R.id.btnLogin);
        Info=(TextView) findViewById(R.id.tvInfo) ;

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate(String userName,String userPassword)
    {
        if(userName.equals("Admin") && userPassword.equals("12345"))
        {
            startActivity(new Intent(this,MainActivity.class));
        }
        else
        {
            counter--;

            Info.setText("Incorrect Info");
            if(counter==0)
            {
                Login.setEnabled(false);
            }
        }
    }

    public void view (View view){
        startActivity(new Intent(this,ViewList.class));
    }

}
