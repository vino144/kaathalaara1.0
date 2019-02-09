package com.vino.raven.kaathalaara.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;

import com.vino.raven.kathalara.R;

public class Details_Page extends AppCompatActivity {
    AppCompatTextView title,kavithai;
    String title_d,kavithai_d;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__page);
        title=findViewById(R.id.title_details);
        kavithai=findViewById(R.id.kavithai_details);

        if (getIntent()!=null) {
            if (getIntent().getExtras() != null) {
                title_d = getIntent().getExtras().getString("title");
                kavithai_d = getIntent().getExtras().getString("kavithai");
            }
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("DETAILS");
            System.out.println("CHECK_GETSUPPORTBAR");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // this sets the button to the    back icon
            getSupportActionBar().setHomeButtonEnabled(true); // makes it clickable
        }


        if (title_d!=null&kavithai_d!=null) {
            title.setText(title_d);
            kavithai.setText(kavithai_d);
        }
    }
}
