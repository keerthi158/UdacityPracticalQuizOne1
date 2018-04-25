package com.example.admin.udacitypracticalquizone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Description = "descriptionKey";
    public static final String Email = "emailKey";

    TextView userNameTv;
    TextView emailTv;
    TextView descriptionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences settings = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String nameStr = settings.getString(Name, "");
        String descriptionStr = settings.getString(Description, "");
        String emailStr = settings.getString(Email, "");


        userNameTv = (TextView) findViewById(R.id.tv_user_name);
        emailTv = (TextView) findViewById(R.id.tv_email);
        descriptionTv = (TextView) findViewById(R.id.tv_description);

        userNameTv.setText(nameStr);
        emailTv.setText(emailStr);
        descriptionTv.setText(descriptionStr);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
