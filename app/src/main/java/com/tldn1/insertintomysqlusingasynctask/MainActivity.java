package com.tldn1.insertintomysqlusingasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = (EditText)findViewById(R.id.edtName);
        edtNumber = (EditText)findViewById(R.id.edtNumber);


    }
    public void SaveData(View view){
        String name = edtName.getText().toString();
        String number =edtNumber.getText().toString();
        Background background = new Background(this);
        background.execute(name,number);
        edtName.setText("");
        edtNumber.setText("");
    }
}
