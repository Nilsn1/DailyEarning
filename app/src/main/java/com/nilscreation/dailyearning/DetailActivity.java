package com.nilscreation.dailyearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;

public class DetailActivity extends AppCompatActivity {

    ImageView appImg, share;
    TextView title, appTitle, appBonus, appDescription;
    Button btnDownload;
    String mdescription, mappUrl;
    int mbonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.title);
        share = findViewById(R.id.share);
        appImg = findViewById(R.id.appImg);
        appTitle = findViewById(R.id.appTitle);
        appBonus = findViewById(R.id.appBonus);
        appDescription = findViewById(R.id.appDescription);
        btnDownload = findViewById(R.id.btnDownload);

        Intent intent = getIntent();
        if ((intent != null)) {
            mdescription = intent.getStringExtra("Description");
            mappUrl = intent.getStringExtra("AppUrl");
            mbonus = intent.getIntExtra("Bonus", 0);

            Glide.with(this).load(intent.getStringExtra("ImgUrl")).into(appImg);
            appTitle.setText(intent.getStringExtra("Title"));
            title.setText(intent.getStringExtra("Title"));
            appBonus.setText("₹" + intent.getIntExtra("Bonus", 0) + " Bonus");
            appDescription.setText(intent.getStringExtra("Description"));
        }

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) appImg.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                shareImageandText(bitmap);
            }
        });
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mappUrl));
                startActivity(intent);
            }
        });
    }

    public void shareImageandText(Bitmap bitmap) {
        Uri uri = getImageToShare(bitmap);
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_STREAM, uri);

        intent.putExtra(Intent.EXTRA_TEXT, "Download App and Get ₹" + mbonus + " Bonus.\n" + mappUrl
//                + "\n\n" + mdescription + "\n\n" + mappUrl
        );

        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

        intent.setType("image/png");

        startActivity(Intent.createChooser(intent, "Share Via"));
    }

    private Uri getImageToShare(Bitmap bitmap) {
        File imagefolder = new File(getCacheDir(), "images");
        Uri uri = null;
        try {
            imagefolder.mkdirs();
            File file = new File(imagefolder, "DailyEarning.jpg");
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(DetailActivity.this, "com.nilscreation.dailyearning", file);
        } catch (Exception e) {
            Toast.makeText(DetailActivity.this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return uri;
    }
}