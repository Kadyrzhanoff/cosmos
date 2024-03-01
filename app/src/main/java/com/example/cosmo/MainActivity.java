package com.example.cosmo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        shareButton = findViewById(R.id.share_button);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToShare = editText.getText().toString();

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "Поделиться через"));
            }
        });

        Button showButton = findViewById(R.id.write_button);


        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareButton.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                showButton.setVisibility(View.INVISIBLE);
            }
        });

    }
}