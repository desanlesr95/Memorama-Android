package com.example.luis.memorama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.pass);
        button=(Button)findViewById(R.id.aceptar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(editText.getText().toString().equals("vomito")){
            Intent intent=new Intent(this,Game.class);
            startActivity(intent);
            finish();
        }
    }
}
