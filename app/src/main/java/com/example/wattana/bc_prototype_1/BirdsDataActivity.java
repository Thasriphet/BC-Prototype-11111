package com.example.wattana.bc_prototype_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BirdsDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birds_data, menu);
        return true;
    }
    public  void keepbird (View view){
        Intent itn1 = new Intent(this,KeepbirdActivity.class);

        startActivity(itn1);
    }
    public  void  birdData (View view){
        Intent itn2 = new Intent(this,BirdsDataActivity.class);

        startActivity(itn2);
    }
    public  void  birdcollection (View view){
        Intent itn3 = new Intent(this,CollectionActivity.class);

        startActivity(itn3);
    }
    public  void  openposition (View view){
        Intent itn4 = new Intent(this,MapsActivity.class);

        startActivity(itn4);
    }



    /*-------*/
    public void gotobird (View view){
        Intent itn5 = new Intent(this,DetailActivity.class);

        startActivity(itn5);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
