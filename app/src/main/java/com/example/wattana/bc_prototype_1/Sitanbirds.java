package com.example.wattana.bc_prototype_1;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Sitanbirds extends AppCompatActivity {

    String arrData[][];
    TextView txtName,txtDesc,txtLocl;
    ImageView imgView_Bird;
    Integer picBird [] = {
            R.mipmap.bird11,
            R.mipmap.bird12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitanbirds);


        final Birddatabase BirdDb = new Birddatabase(this);

        arrData = BirdDb.SelectSithanData();


        // gridView1
        final GridView gView1 = (GridView)findViewById(R.id.gridView1);

        gView1.setAdapter(new ImageAdapter(this, arrData));

        // OnClick
        gView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                final Dialog dialog_ShowBird = new Dialog(Sitanbirds.this);
                dialog_ShowBird.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_ShowBird.setContentView(R.layout.show_bird);
                dialog_ShowBird.setCancelable(true);
                dialog_ShowBird.show();

                Button btnClose = (Button)dialog_ShowBird.findViewById(R.id.btnClose);
                txtName = (TextView)dialog_ShowBird.findViewById(R.id.txtName);
                txtDesc = (TextView)dialog_ShowBird.findViewById(R.id.txtDesc);
                txtLocl = (TextView)dialog_ShowBird.findViewById(R.id.txtLocal);
                imgView_Bird = (ImageView)dialog_ShowBird.findViewById(R.id.imaViewBird);

                txtName.setText(""+arrData[position][1].toString());
                txtDesc.setText(""+arrData[position][2].toString());
                txtLocl.setText(""+arrData[position][3].toString());

                imgView_Bird.setImageResource(picBird[position]);

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog_ShowBird.cancel();
                    }
                });

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
            // String strPath = "\\มหาวิทยาลัยขอนแก่น Galaxy S4 (Ga\\Phone\\birds00\\" + lis[position][4].toString();
            textView.setText(lis[position][1].toString());
            // Image Resource
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
            imageView.setImageResource(picBird[position]);



            return convertView;

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birds_data, menu);
        return true;
    }

    //------
    //คลิกเพื่อกลับหน้าหลัก
    public  void home (View view){
        Intent itnhome = new Intent(this,MainActivity.class);

        startActivity(itnhome);
    }

    //คลิกเพื่อไปยังหน้าจับนก
    public  void keepbird (View view){
        Intent itn = new Intent(this,KeepbirdActivity.class);

        startActivity(itn);
    }

    //คลิกเพื่อไปยังหน้าข้อมูลนก
    public  void  birddata (View view){
        Intent itn = new Intent(this,BirdsDataActivity.class);

        startActivity(itn);
    }

    //คลิกเพื่อไปยังหน้านกสะสม
    public  void  birdcollection (View view){
        Intent itn = new Intent(this,CollectionActivity.class);

        startActivity(itn);
    }

    //คลิกเพื่อไปยังหน้าแผนที่
    public  void  openposition (View view){
        Intent itn = new Intent(this,MapsActivity.class);

        startActivity(itn);
    }
}
