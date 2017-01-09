package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }

    public void onregisterbuttonClick(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
        finish();
    }

    public void onmultiplayerbuttonClick (View view) {
        Intent intent = new Intent(this, MultiplayerRegister.class);
        startActivity(intent);
        finish();
    }
    public void onscoreboardbuttonClick (View view) {
        Intent intent = new Intent(this, Scoreboard.class);
        startActivity(intent);
        finish();
    }
}