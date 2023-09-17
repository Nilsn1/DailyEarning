package com.nilscreation.dailyearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    ImageView appImg;
    TextView appTitle, appBonus, appDescription;
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        appImg = findViewById(R.id.appImg);
        appTitle = findViewById(R.id.appTitle);
        appBonus = findViewById(R.id.appBonus);
        appDescription = findViewById(R.id.appDescription);
        btnDownload = findViewById(R.id.btnDownload);

        Intent intent = getIntent();
        if ((intent != null)) {
            Glide.with(this).load(intent.getStringExtra("ImgUrl")).into(appImg);
            appTitle.setText(intent.getStringExtra("Title"));
            appBonus.setText("₹" + intent.getIntExtra("Bonus", 0) + " Bonus");
            appDescription.setText(intent.getStringExtra("Description"));
        }

    }
}