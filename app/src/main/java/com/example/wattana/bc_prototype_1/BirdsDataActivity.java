package com.example.wattana.bc_prototype_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

public class BirdsDataActivity extends AppCompatActivity {


    private GridView BirdGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_data);


    }//onCreate



    private  void bindWidget(){
        /*BirdGridView = (GridView) findViewById(R.id.gridView);*/
    }
    private void InsertValues(){

        //ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์
       /* objBirdData.addData("เหยี่ยวขาว", "เป็นกลุ่มนกที่ล่าสัตว์เป็นอาหาร ตาสีแดง ลำตัวสีเทา " +
                "ลำตัวด้านล่างเป็นสีขาว ปลายปีกมีสีดำเข้มตัดกับลำตัว พบเห็นได้ตลอดปี โดยบพครั้งละตัวไม่รวมฝูง",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "Bird001");
        objBirdData.addData("นกเด้าดินทุ่ง ", "ลำตัวสีน้ำตาล มีริ้วสีดำที่หน้าอก ใต้คอมีสีขาว คิ้วสีขาว ขาสีชมพู " +
                        "เวลาเดินหรือยืนจะกระดกหางขึ้นลง พบได้ตลอดปี มักพบว่าหากินเพียงลำพัง ",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "Bird02");
        objBirdData.addData("นกจับแมลงสีน้ำตาล  ", "มีสีเทาน้ำตาลตลอดทั้งตัว ปลายปีกสีดำ มีวงตาสีขาว คอสีขาว ใต้ท้องสี" +
                        "ขาว หลังสีน้ำตาลเทา ปากสีดำโคนปากสีชมพูอ่อน เป็นนกอพยพในช่วงฤดูหนาว ",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "Bird03");
        objBirdData.addData("นกยอดหญ้าหัวดำ  ", "ตัวผู้นั้นจะมีหัวถึงหน้าอกสีดำ ท้องสีน้ำตาลดำอ่อนๆ มีขลิบปีกสีขาว หลังมีสีน้ำตาลอ่อน " +
                        "หางดำ ตัวเมียหัวสีเทาน้ำตาล มีขลิบปีกสีขาว" +
                        "ตะโพกสีน้ำตาล ปลายหางสีดำ เป็นนกอพยพมาช่วงฤดูหนาว พบเป็นคู่ๆ",
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "Bird04");

        objBirdData.addData("นกยางควาย   ", "สีขาวตลอดทั้งตัว ปากสั้นและมีสีเหลือง ใต้คอจะมีลักษณะเหมือนเหนียงยาน ตรงกลางหัวมีขนสีน้ำตาลขึ้นเล็กน้อย " +
                        "แข้งสีดำ แต่ในช่วงฤดูผสมพันธุ์ตั้งแต่หัวถึงกลางหลังจะมีสีน้ำตาล ปากสีชมพูเข้ม แข้งสีแดง เป็นนกอพยพมาในช่วงฤดูหนาว" ,
                "ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ", "Bird05");

        //บ่อน้ำประมง
        objBirdData.addData("นกกระเต็นน้อยธรรมดา", "เป็นนกหากินตามแหล่งน้ำ ปากยาวมีสีดำ บริเวณหูมีสีน้ำตาลเหลืองและขาวเห็นได้ชัดเจน " +
                        "ลำตัวมีสีเขียวน้ำเงิน คอหอยสีขาว หลังและตะโพกและขนคลุมโคนหางมีสีน้ำเงินสด เป็นนกอพยพมาในช่วงฤดูหนาว",
                "บ่อน้ำประมง ", "Bird06");
        objBirdData.addData("นกกระจี๊ดธรรมดา", "มีปากสั้น เรียว หัวมีสีเขียวน้ำตาล มีคาดตาสีดำ คิ้วขาว ปีกมีเส้นลายขาวสลับดำ " +
                        "สะโพกและขนโคนหางด้านบนจะมีสีเขียวอ่อนกว่าลำตัว เป็นนกอพยพมาช่วงฤดุหนาว ",
                "บ่อน้ำประมง ", "Bird07");
        objBirdData.addData("นกหัวโตเล็กขาเหลือง", "มีสีน้ำตาลเทา อกมีแทบสีเทาน้ำตาล มีวงตาสีเหลืองขอบหางสีขาวชัดเจน " +
                        "เป็นนกอพยพมาช่วงฤดุหนาว",
                "บ่อน้ำประมง ", "Bird08");
        objBirdData.addData("นกอีแพรดแถบอกดำ", "มีหัวสีดำ คิ้วสีขาว หน้าอกมีแถบสีดำ คอและท้องสีขาว หลังมีสีน้ำตาลดำ " +
                        "หางสีดำและปลายหางสีขาว เป็นนกที่พบได้ตลอดปี ",
                "บ่อน้ำประมง ", "Bird09");
        objBirdData.addData("นกอุ้มบาตร", "หน้าผากสีขาว กระหม่อมถึงคอสีดำ หลังมีสีเทาดำ บริเวณปีกมีแถบสีขาว หางมีสีดำขอบหางสีขาว " +
                        "ขาสีขาว คอถึงหน้าอกมีแถบสีดำ ท้องสีขาว เป็นนกอพยพมาในช่วงฤดูหนาว ",
                "บ่อน้ำประมง ", "Bird10");

        //บึงสีฐาน
        objBirdData.addData("เป็ดแดง", "บริเวณคอมีสีน้ำตาลแดง ปากแบน ลำตัวสีน้ำตาลเข้ม ไหล่และปีกเป็นสีน้ำตาลแดงเข้มกว่าบริเวณอื่น " +
                        "ขนปลายปีกมีสีดำ อพยพมาช่วงปลายฝนต้นหนาว ",
                "บึงสีฐาน ", "Bird11");
        objBirdData.addData("นกยางสายพันธุ์จีน", "มีสีน้ำตาลเขียวที่หัวและหน้าอก ปากมีสีดำยาว  ปีกและหลังสีน้ำตาล ในฤดูผสมพันธุ์หน้าและหน้าอกจะเปลี่ยนเป็นสีน้ำตาลแดงเข้ม " +
                        "ขาและเท้ามีสีแดง ปลังสีน้ำตาลดำเข้ม อพยพมาช่วงกลางฤดูฝน ",
                "บึงสีฐาน ", "Bird12"); */


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
