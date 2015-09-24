package com.example.wattana.bc_prototype_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_birdcollection) {
            Intent birdcollect = new Intent(this,CollectionActivity.class);

            startActivity(birdcollect);

            return true;
        }else if (id == R.id.menu_keep){
            Intent keepbird = new Intent(this,KeepbirdActivity.class);

            startActivity(keepbird);
        }else if (id == R.id.menu_map){
            Intent map = new Intent(this,MapsActivity.class);

            startActivity(map);
        }

        return super.onOptionsItemSelected(item);
    }
}
