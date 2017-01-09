package com.example.aakash.gkquiz;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;

public class Scoreboard extends AppCompatActivity {

    SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        //Database relevant code here

        myDatabase=openOrCreateDatabase("ScoreDB", Context.MODE_PRIVATE, null);
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS score_keeping(score INTEGER,name VARCHAR,newline VARCHAR);");
        //writeRow();
        displayData();
        String name;
        int score;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            score = extras.getInt("Score");
            writeRow(name,score);
            displayData();
        }

    }
    public void writeRow(String param1, int param2){
        int value1 = param2;
        String value2 = param1;
        String value3 = "\n";//just for a nicer view of the scores

        myDatabase.execSQL("INSERT INTO student VALUES('"+value1+"','"+value2+"','"+value3+"');");
    }
    public void displayData(){
        Cursor c=myDatabase.rawQuery("SELECT * FROM student ORDER BY score DESC", null);
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append(c.getString(0));
            buffer.append("   scored by player   ");
            buffer.append(c.getString(1));
            buffer.append(c.getString(2));
        }
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText(buffer.toString());


    }
    public void backToMenu (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();}

}