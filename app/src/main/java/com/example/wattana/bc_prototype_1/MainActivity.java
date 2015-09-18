package com.example.wattana.bc_prototype_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* button = (Button) findViewById(R.id.btnKeepbird);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keepIntent = new Intent(MainActivity.this,KeepbirdActivity.class);
            }
        });*/
    }
    public  void keepBirds (View view){
        Intent itn = new Intent(this,KeepbirdActivity.class);

        startActivity(itn);
    }
    public  void  birdData (View view){
        Intent itn = new Intent(this,BirdsDataActivity.class);

        startActivity(itn);
    }
    public  void  collection (View view){
        Intent itn = new Intent(this,CollectionActivity.class);

        startActivity(itn);
    }
    public  void  openMap (View view){
        Intent itn = new Intent(this,MapsActivity.class);

        startActivity(itn);
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

