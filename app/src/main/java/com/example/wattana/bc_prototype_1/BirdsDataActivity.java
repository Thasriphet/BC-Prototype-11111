package com.example.wattana.bc_prototype_1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BirdsDataActivity extends AppCompatActivity {
    //List <String> ImageList;
    String arrData[][];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_data);

        final Birddatabase BirdDb = new Birddatabase(this);

       /* BirdDb.InsertData("1", "เหยี่ยวขาว", "เป็นกลุ่มนกที่ล่าสัตว์เป็นอาหาร ตาสีแดง ลำตัวสีเทา " +
                        "ลำตัวด้านล่างเป็นสีขาว ปลายปีกมีสีดำเข้มตัดกับลำตัว พบเห็นได้ตลอดปี โดยบพครั้งละตัวไม่รวมฝูง",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "bird01.png");
        BirdDb.InsertData("2","นกเด้าดินทุ่ง ", "ลำตัวสีน้ำตาล มีริ้วสีดำที่หน้าอก ใต้คอมีสีขาว คิ้วสีขาว ขาสีชมพู " +
                        "เวลาเดินหรือยืนจะกระดกหางขึ้นลง พบได้ตลอดปี มักพบว่าหากินเพียงลำพัง ",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "bird02.png");
        BirdDb.InsertData("3","นกจับแมลงสีน้ำตาล  ", "มีสีเทาน้ำตาลตลอดทั้งตัว ปลายปีกสีดำ มีวงตาสีขาว คอสีขาว ใต้ท้องสี" +
                        "ขาว หลังสีน้ำตาลเทา ปากสีดำโคนปากสีชมพูอ่อน เป็นนกอพยพในช่วงฤดูหนาว ",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "bird03.png");
        BirdDb.InsertData("4","นกยอดหญ้าหัวดำ  ", "ตัวผู้นั้นจะมีหัวถึงหน้าอกสีดำ ท้องสีน้ำตาลดำอ่อนๆ มีขลิบปีกสีขาว หลังมีสีน้ำตาลอ่อน " +
                        "หางดำ ตัวเมียหัวสีเทาน้ำตาล มีขลิบปีกสีขาว" +
                        "ตะโพกสีน้ำตาล ปลายหางสีดำ เป็นนกอพยพมาช่วงฤดูหนาว พบเป็นคู่ๆ",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "bird04.png");

        BirdDb.InsertData("5","นกยางควาย   ", "สีขาวตลอดทั้งตัว ปากสั้นและมีสีเหลือง ใต้คอจะมีลักษณะเหมือนเหนียงยาน ตรงกลางหัวมีขนสีน้ำตาลขึ้นเล็กน้อย " +
                        "แข้งสีดำ แต่ในช่วงฤดูผสมพันธุ์ตั้งแต่หัวถึงกลางหลังจะมีสีน้ำตาล ปากสีชมพูเข้ม แข้งสีแดง เป็นนกอพยพมาในช่วงฤดูหนาว",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "bird05.png");

//บ่อน้ำประมง
        BirdDb.InsertData("6","นกกระเต็นน้อยธรรมดา", "เป็นนกหากินตามแหล่งน้ำ ปากยาวมีสีดำ บริเวณหูมีสีน้ำตาลเหลืองและขาวเห็นได้ชัดเจน " +
                        "ลำตัวมีสีเขียวน้ำเงิน คอหอยสีขาว หลังและตะโพกและขนคลุมโคนหางมีสีน้ำเงินสด เป็นนกอพยพมาในช่วงฤดูหนาว",
                "บ่อน้ำประมง ", "bird06.png");
        BirdDb.InsertData("7","นกกระจี๊ดธรรมดา", "มีปากสั้น เรียว หัวมีสีเขียวน้ำตาล มีคาดตาสีดำ คิ้วขาว ปีกมีเส้นลายขาวสลับดำ " +
                        "สะโพกและขนโคนหางด้านบนจะมีสีเขียวอ่อนกว่าลำตัว เป็นนกอพยพมาช่วงฤดุหนาว ",
                "บ่อน้ำประมง ", "bird07.png");
        BirdDb.InsertData("8","นกหัวโตเล็กขาเหลือง", "มีสีน้ำตาลเทา อกมีแทบสีเทาน้ำตาล มีวงตาสีเหลืองขอบหางสีขาวชัดเจน " +
                        "เป็นนกอพยพมาช่วงฤดุหนาว",
                "บ่อน้ำประมง ", "bird08.png");
        BirdDb.InsertData("9", "นกอีแพรดแถบอกดำ", "มีหัวสีดำ คิ้วสีขาว หน้าอกมีแถบสีดำ คอและท้องสีขาว หลังมีสีน้ำตาลดำ " +
                        "หางสีดำและปลายหางสีขาว เป็นนกที่พบได้ตลอดปี ",
                "บ่อน้ำประมง ", "bird09.png");
        BirdDb.InsertData("10", "นกอุ้มบาตร", "หน้าผากสีขาว กระหม่อมถึงคอสีดำ หลังมีสีเทาดำ บริเวณปีกมีแถบสีขาว หางมีสีดำขอบหางสีขาว " +
                        "ขาสีขาว คอถึงหน้าอกมีแถบสีดำ ท้องสีขาว เป็นนกอพยพมาในช่วงฤดูหนาว ",
                "บ่อน้ำประมง ", "bird10.png");

//บึงสีฐาน
        BirdDb.InsertData("11", "เป็ดแดง", "บริเวณคอมีสีน้ำตาลแดง ปากแบน ลำตัวสีน้ำตาลเข้ม ไหล่และปีกเป็นสีน้ำตาลแดงเข้มกว่าบริเวณอื่น " +
                        "ขนปลายปีกมีสีดำ อพยพมาช่วงปลายฝนต้นหนาว ",
                "บึงสีฐาน ", "bird11.png");
        BirdDb.InsertData("12", "นกยางสายพันธุ์จีน", "มีสีน้ำตาลเขียวที่หัวและหน้าอก ปากมีสีดำยาว  ปีกและหลังสีน้ำตาล ในฤดูผสมพันธุ์หน้าและหน้าอกจะเปลี่ยนเป็นสีน้ำตาลแดงเข้ม " +
                        "ขาและเท้ามีสีแดง ปลังสีน้ำตาลดำเข้ม อพยพมาช่วงกลางฤดูฝน ",
                "บึงสีฐาน ", "bird12.png");*/


        arrData = BirdDb.SelectAllData();
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


    }//onCrea

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

    //intent to view
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
    public  void home (View view){
        Intent itnhome = new Intent(this,MainActivity.class);

        startActivity(itnhome);
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
