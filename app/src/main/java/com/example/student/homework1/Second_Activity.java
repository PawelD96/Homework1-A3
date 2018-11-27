package com.example.student.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Second_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent anydata = getIntent();
    }

    public void touch1(View view) {
        EditText rr = (EditText) findViewById(R.id.R);
        int dr = rr.getText().toString().isEmpty() ? 0 : Integer.parseInt(rr.getText().toString());
            dr = dr>255 ? 255 : dr;

        EditText gg = (EditText) findViewById(R.id.G);
        int dg = gg.getText().toString().isEmpty() ? 0 : Integer.parseInt(gg.getText().toString());
        dg = dg>255 ? 255 : dg;

        EditText bb = (EditText) findViewById(R.id.B);
        int db = bb.getText().toString().isEmpty() ? 0 : Integer.parseInt(bb.getText().toString());
        db = db>255 ? 255 : db;

        Intent anydata = new Intent();
        int a[] = { dr,dg,db };
        anydata.putExtra("color",a);

        setResult(RESULT_OK,anydata);

        finish();
    }

    public void touchcancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
