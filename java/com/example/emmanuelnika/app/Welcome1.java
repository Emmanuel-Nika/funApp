package com.example.emmanuelnika.app;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.emmanuelnika.app.DBHelper;
import com.example.emmanuelnika.app.R;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Welcome1 extends ListActivity {

    protected TextView eun;
    protected SQLiteDatabase DB;
    protected Cursor cursor;
    protected ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome1);


        DB = (new DBHelper(this)).getWritableDatabase();
        // searchText = (EditText) findViewById (R.id.searchText);

        eun = (TextView) findViewById(R.id.textV);
        Bundle bundle = getIntent().getExtras();

        String UName = bundle.getString("UserName");

        eun.setText(UName);
    }

    public void search(View view)
    {
        cursor = DB.rawQuery("SELECT _id, gender, username FROM app WHERE username LIKE ?",
                new String[] {"%" + eun.getText().toString() + "%"});
        adapter = new SimpleCursorAdapter(
                this, R.layout.dtl, cursor, new String[] {"gender","username"},
                new int[] {R.id.sgender , R.id.suname});
        setListAdapter(adapter);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent i = new Intent(Welcome1.this, LoginActivity.class);
        startActivity(i);
    }
}