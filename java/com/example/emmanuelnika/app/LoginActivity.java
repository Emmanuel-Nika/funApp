package com.example.emmanuelnika.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class LoginActivity extends Activity implements OnClickListener{

    Button mLogin;
    Button mRegister;

    EditText muname;
    EditText mpassword;

    DBHelper DB = null;

    /** Called when the activity is first created. **/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);

        mRegister = findViewById(R.id.register);
        mRegister.setOnClickListener(this);

        mLogin = findViewById(R.id.button);
        mLogin.setOnClickListener(this);
    }

    public void onClick (View v){
        switch (v.getId())
        {
            case R.id.register:
                startActivity(new Intent(getBaseContext(), Registration.class));
                break;
            case R.id.button:
                muname = findViewById(R.id.editUserName);
                mpassword = findViewById(R.id.editPassword);

                String username = muname.getText().toString();
                String password = mpassword.getText().toString();

                if(username.equals(" "))
                {
                    Toast.makeText(getApplicationContext(), "Please enter User Name", Toast.LENGTH_LONG).show();
                } else if (password.equals(" "))
                {
                    Toast.makeText(getApplicationContext(), "Please enter Password", Toast.LENGTH_LONG).show();
                } else
                {
                    boolean validLogin = validateLogin(username, password, getBaseContext());
                    if(validLogin)
                    {
                        //System.out.println("Invalid");
                        Intent in = new Intent(getBaseContext(), FunApp.class);
                        in.putExtra("UserName", muname.getText().toString());

                        //Starts FunApp
                        startActivity(in);
                        //finish();
                    }
                }
                break;
        }
    }

    private boolean validateLogin(String username, String password, Context baseContext){
        DB = new DBHelper(getBaseContext());
        SQLiteDatabase db = DB.getReadableDatabase();

        String[] columns = { "_id"};

        String selection = "username=? AND password=?";
        String[] selectionArgs = {username,password};

        Cursor cursor = null;
        try {
            cursor = db.query(DBHelper.DATABASE_TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            startManagingCursor(cursor);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        int numberOfRows = cursor.getCount();


        if (numberOfRows<=0)
        {
            Toast.makeText(getApplicationContext(), "Username and Password miss match...\nPlease Try Again",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);
            return false;
        }
        
        return true;
    }

    public void onDestroy(){
        super.onDestroy();
        DB.close();
    }

    /**
     * @Override
     * protected void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); }
     *
     * @Override
     * protected void onRestoreInstanceState(Bundle savedInstanceState) {
     *      super.onRestoreInstanceState(savedInstanceState);
     * }
     */

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new
                AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.decisionExit);
        alertDialogBuilder.setPositiveButton(R.string.positive_button,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        moveTaskToBack(true);
                        LoginActivity.this.finish();
                    }
                });
        alertDialogBuilder.setNegativeButton(R.string.negative_button,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent negativeActivity = new
                                Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(negativeActivity);
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}