package com.example.wattana.bc_prototype_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collection, menu);
        return true;
    }
    public  void keepbird (View view){
        Intent itn = new Intent(this,KeepbirdActivity.class);

        startActivity(itn);
    }
    public  void  birddata (View view){
        Intent itn = new Intent(this,BirdsDataActivity.class);

        startActivity(itn);
    }
    public  void  birdcollection (View view){
        Intent itn = new Intent(this,CollectionActivity.class);

        startActivity(itn);
    }
    public  void  openposition (View view){
        Intent itn = new Intent(this,MapsActivity.class);

        startActivity(itn);
    }

    /*-------*/
    public  void  virtualbird (View view){
        Intent itnb = new Intent(this,VirtualBirdActivity.class);

        startActivity(itnb);
    }
    public  void  photobird (View view){
        Intent itnb = new Intent(this,PhotoActivity.class);

        startActivity(itnb);
    }
    public  void home (View view){
        Intent itnhome = new Intent(this,MainActivity.class);

        startActivity(itnhome);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_keep) {
            Intent keepbird = new Intent(this,KeepbirdActivity.class);

            startActivity(keepbird);

            return true;
        }else if (id == R.id.menu_map){
            Intent map = new Intent(this,MapsActivity.class);

            startActivity(map);
        }else if (id == R.id.menu_birddata){
            Intent birddata = new Intent(this,BirdsDataActivity.class);

            startActivity(birddata);
        }

        return super.onOptionsItemSelected(item);
    }


}
