package com.example.sleep.base.activity;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sleep.R;


public class WelcomeActivity extends AppCompatActivity {
private TextView welcome;
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView( R.layout.activity_welcome );
    initViews();
}

    private void initViews() {
    welcome=findViewById( R.id.textView);
    }
}



