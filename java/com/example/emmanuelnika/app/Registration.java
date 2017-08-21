package com.example.emmanuelnika.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.emmanuelnika.app.DBHelper;
import com.example.emmanuelnika.app.R;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Registration extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    // Variable Declaration should be in onCreate()
    private Button mSubmit;
    private Button mCancel;

    private EditText mUsername;
    private EditText mPassword;
    private Spinner mGender;
    private String Gen;

    protected DBHelper DB = new DBHelper(Registration.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Assignment of UI fields to the variables
        mSubmit = (Button) findViewById(R.id.submit);
        mSubmit.setOnClickListener(this);

        mCancel = (Button) findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);

        mUsername = (EditText) findViewById(R.id.reuname);
        mPassword = (EditText) findViewById(R.id.repass);

        mGender = (Spinner) findViewById(R.id.spinner1);

        // Spinner method to read the on selected value
        ArrayAdapter<State> spinnerArrayAdapter = new ArrayAdapter<State>(this,
                android.R.layout.simple_spinner_item, new State[]{
                new State("Male"),
                new State("Female")});
        mGender.setAdapter(spinnerArrayAdapter);
        mGender.setOnItemSelectedListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.cancel:
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(i);
                //finish();
                break;

            case R.id.submit:

                String uname = mUsername.getText().toString();
                String pass = mPassword.getText().toString();

                boolean invalid = false;

                if (uname.equals("")) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(), "Please enter your Username", Toast.LENGTH_SHORT).show();
                } else if (pass.equals("")) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_SHORT).show();
                } else if (invalid == false) {
                    addEntry(Gen, uname, pass);
                    Intent i_register = new Intent(Registration.this, LoginActivity.class);
                    startActivity(i_register);
                    //finish();
                }

                break;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        DB.close();
    }

    private void addEntry(String Gen, String uname, String pass)
    {

        SQLiteDatabase db = DB.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("gender", Gen);
        values.put("username", uname);
        values.put("password", pass);

        try
        {
            db.insert(DBHelper.DATABASE_TABLE_NAME, null, values);

            Toast.makeText(getApplicationContext(), "Your details were submitted successfully...", Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // Get the currently selected State object from the spinner
        State st = (State)mGender.getSelectedItem();

        // Show it via a toast
        toastState( "onItemSelected", st );
    }

    public void toastState(String name, State st)
    {
        if ( st != null )
        {
            Gen = st.name;
            //Toast.makeText(getBaseContext(), Gen, Toast.LENGTH_SHORT).show();

        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}