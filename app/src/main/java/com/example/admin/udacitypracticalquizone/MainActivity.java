package com.example.admin.udacitypracticalquizone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button nextBtn;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Description = "descriptionKey";
    public static final String Email = "emailKey";

    EditText nameEt;
    EditText emailEt;
    EditText descriptionEt;

    String nameStr  = "";
    String emailStr  = "";
    String descriptionStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            nameStr = savedInstanceState.getString(Name);
            emailStr = savedInstanceState.getString(Email);
            descriptionStr = savedInstanceState.getString(Description);
        } else {
            // Probably initialize members with default values for a new instance
            nameStr = "";
            emailStr = "";
            descriptionStr = "";
        }
        nextBtn = (Button) findViewById(R.id.btn_next);

        nameEt = (EditText) findViewById(R.id.et_user_name);
        emailEt = (EditText) findViewById(R.id.et_email);
        descriptionEt = (EditText) findViewById(R.id.et_about_urs);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                nameStr  = nameEt.getText().toString();
                emailStr  = emailEt.getText().toString();
                descriptionStr  = descriptionEt.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, nameStr);
                editor.putString(Description, descriptionStr);
                editor.putString(Email, emailStr);
                editor.commit();

                Intent detailInt = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(detailInt);
            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        nameStr  = nameEt.getText().toString();
        emailStr  = emailEt.getText().toString();
        descriptionStr  = descriptionEt.getText().toString();
        savedInstanceState.putString(Name, nameStr);
        savedInstanceState.putString(Email, emailStr);
        savedInstanceState.putString(Description, descriptionStr);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent detailInt = new Intent(MainActivity.this, DetailsActivity.class);
        startActivity(detailInt);
        finish();
        return true;
    }
}
