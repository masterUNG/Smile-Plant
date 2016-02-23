package appewtc.masterung.smileplant;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ManageTABLE manageTABLE;
    private ImageView hub1ImageView, hub2ImageView,
            hub3ImageView, hub4ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Request Database
        manageTABLE = new ManageTABLE(this);

        //Delete All SQLite ==> ถ้าข้อมูลครับ 49 Record ก็ไม่ต้องลบแล้ว
        deleteAllSQLite();

        //Setup Data สำหรับข้อมูลที่ยังไม่สมบูรณ์
        forSetupData();

        //Image Controller
        imageController();

        //Long Click
        longclick();


    }   // Main Method

    private void longclick() {

        hub1ImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(MainActivity.this, "ข้อความที่ต้องการ", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

    } // lingclick

    private void imageController() {

        hub1ImageView.setOnClickListener(this);
        hub2ImageView.setOnClickListener(this);
        hub3ImageView.setOnClickListener(this);
        hub4ImageView.setOnClickListener(this);

    }   // imageController

    private void bindWidget() {

        hub1ImageView = (ImageView) findViewById(R.id.imageView);
        hub2ImageView = (ImageView) findViewById(R.id.imageView2);
        hub3ImageView = (ImageView) findViewById(R.id.imageView3);
        hub4ImageView = (ImageView) findViewById(R.id.imageView4);

    }   //bindWidget

    private void deleteAllSQLite() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(ManageTABLE.plant_table, null, null);

    }   // deleteAllSQLite

    private void forSetupData() {

        //Check emty Data
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ManageTABLE.plant_table, null);
        if (cursor.getCount() == 0) {
            //ไม่มีข้อมูล
            addFirstData();

        }   // if

    }   //forSetupData

    private void addFirstData() {

        //Tester Add Data
//        manageTABLE.addPlant("nameth", "nameen", "hprodoc", "hage", "hseason",
//                "hplant", "data", "ground", "plant", "water",
//                "compost", "protect", "harvest");

        String[] namethStrings = getResources().getStringArray(R.array.nameth);
        String[] nameenStrings = getResources().getStringArray(R.array.nameeng);
        String[] hprodocStrings = getResources().getStringArray(R.array.hproduc);
        String[] hageStrings = getResources().getStringArray(R.array.hage);
        String[] hseasonStrings = getResources().getStringArray(R.array.hseason);
        String[] hplantStrings = getResources().getStringArray(R.array.hplant);
        String[] dataStrings = getResources().getStringArray(R.array.data);
        String[] groundStrings = getResources().getStringArray(R.array.ground);
        String[] plantStrings = getResources().getStringArray(R.array.plant);
        String[] waterStrings = getResources().getStringArray(R.array.water);
        String[] compostStrings = getResources().getStringArray(R.array.compost);
        String[] protextStrings = getResources().getStringArray(R.array.protect);
        String[] harvestStrings = getResources().getStringArray(R.array.harvest);

        for (int i = 0; i < namethStrings.length; i++) {

            manageTABLE.addPlant(namethStrings[i],
                    nameenStrings[i],
                    hprodocStrings[i],
                    hageStrings[i],
                    hseasonStrings[i],
                    hplantStrings[i],
                    dataStrings[i],
                    groundStrings[i],
                    plantStrings[i],
                    waterStrings[i],
                    compostStrings[i],
                    protextStrings[i],
                    harvestStrings[i]);

        }   // for


    }   // addFirstData

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.imageView:
                startActivity(new Intent(MainActivity.this, Hub1Activity.class));
                break;
            case R.id.imageView2:
                startActivity(new Intent(MainActivity.this, Hub2Activity.class));
                break;
            case R.id.imageView3:
                startActivity(new Intent(MainActivity.this, Hub3Activity.class));
                break;
            case R.id.imageView4:
                startActivity(new Intent(MainActivity.this, Hub4Activity.class));
                break;

        }   // switch

    }   // onClick

}   // Main Class
