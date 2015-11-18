package com.example.wattana.bc_prototype_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BungSriTan_Birds extends AppCompatActivity {

    String arrData[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bung_sri_tan__birds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Birddatabase BirdDb = new Birddatabase(this);

        arrData = BirdDb.SelectSithanData();
        /***
         *  [x][0] = GalleryID
         *  [x][1] = Name
         *  [x][2] = Path
         */

        // gridView1
        final GridView gView1 = (GridView)findViewById(R.id.gridView1);

        gView1.setAdapter(new ImageAdapter(this, arrData));

        // OnClick
        gView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(getApplicationContext(),
                        "Your selected : " + arrData[position][1].toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private String[][] lis;

        public ImageAdapter(Context c, String[][] li) {
            // TODO Auto-generated method stub
            context = c;
            lis = li;
        }

        public int getCount() {
            // TODO Auto-generated method stub
            return lis.length;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            if (convertView == null) {
                convertView = inflater.inflate(R.layout.showallbirds, null);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.textView1);
            String strPath = "/mnt/sdcard/picture/" + lis[position][2].toString();

            textView.setText(lis[position][1].toString());

            // Image Resource
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
            Bitmap bm = BitmapFactory.decodeFile(strPath);
            imageView.setImageBitmap(bm);


            return convertView;

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birds_data, menu);
        return true;
    }

}
