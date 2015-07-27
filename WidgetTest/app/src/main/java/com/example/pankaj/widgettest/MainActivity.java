package com.example.pankaj.widgettest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
RadioGroup radioGroup;
    CheckBox mCheckBox;
    Switch mASwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.radioButton1:
                    Toast.makeText(getApplicationContext(),"Radio1",Toast.LENGTH_LONG).show();
                   break;
                case R.id.radioButton2:
                    Toast.makeText(getApplicationContext(),"Radio2",Toast.LENGTH_LONG).show();
                    break;
                case R.id.radioButton3:
                    Toast.makeText(getApplicationContext(),"Radio3",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    });
    mCheckBox = (CheckBox)findViewById(R.id.checkbox1);
       mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_LONG).show();
            }

           }
       });
    mASwitch = (Switch)findViewById(R.id.switchtest);
        mASwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_LONG).show();
                }
            }
        });
        RatingBar mRatingBar = (RatingBar)findViewById(R.id.ratingBar1);
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),rating+"",Toast.LENGTH_SHORT).show();
            }
        });

        Spinner sp = (Spinner)findViewById(R.id.spinner1);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                String s1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
