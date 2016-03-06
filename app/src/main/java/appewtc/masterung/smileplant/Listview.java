package appewtc.masterung.smileplant;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.listView);
        createListView();
    }

    private void createListView() {

        //Get Value From SQLite
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ManageTABLE.plant_table, null);
        cursor.moveToFirst();

        final String[] namePlantStrings = new String[cursor.getCount()];


        final String[] strNameeng = new String[cursor.getCount()];
        final String[] strHProduc = new String[cursor.getCount()];
        final String[] strHAge = new String[cursor.getCount()];
        final String[] strHSeason = new String[cursor.getCount()];
        final String[] strHPlant = new String[cursor.getCount()];
        final String[] strData = new String[cursor.getCount()];
        final String[] strground = new String[cursor.getCount()];
        final String[] strplant = new String[cursor.getCount()];
        final String[] strwater = new String[cursor.getCount()];
        final String[] strcompost = new String[cursor.getCount()];
        final String[] strprotect = new String[cursor.getCount()];
        final String[] strHarvest = new String[cursor.getCount()];

        ArrayList<String> stringArrayList = new ArrayList<String>();
        for (int i = 0; i < cursor.getCount(); i++) {

            namePlantStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Nameth));

            strNameeng[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Nameeng));
            strHProduc[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_HPlant));
            strHAge[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_HAge));
            strHSeason[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_HSeason));
            strHPlant[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_HPlant));
            strData[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Data));
            strground[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_ground));
            strplant[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_plant));
            strwater[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_water));
            strcompost[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_compost));
            strprotect[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_protect));
            strHarvest[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Harvest));

            stringArrayList.add(namePlantStrings[i]);
            cursor.moveToNext();
        }   // for
        cursor.close();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(Listview.this,
                android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(stringArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Listview.this, ShowDetailActivity.class);
                intent.putExtra(ManageTABLE.column_Nameth, namePlantStrings[i]);
                intent.putExtra(ManageTABLE.column_Nameeng, strNameeng[i]);
                intent.putExtra(ManageTABLE.column_HProduc, strHProduc[i]);
                intent.putExtra(ManageTABLE.column_HAge, strHAge[i]);
                intent.putExtra(ManageTABLE.column_HSeason, strHSeason[i]);
                intent.putExtra(ManageTABLE.column_HPlant, strHPlant[i]);
                intent.putExtra(ManageTABLE.column_Data, strData[i]);
                intent.putExtra(ManageTABLE.column_ground, strground[i]);
                intent.putExtra(ManageTABLE.column_plant, strplant[i]);
                intent.putExtra(ManageTABLE.column_water, strwater[i]);
                intent.putExtra(ManageTABLE.column_compost, strcompost[i]);
                intent.putExtra(ManageTABLE.column_protect, strprotect[i]);
                intent.putExtra(ManageTABLE.column_Harvest, strHarvest[i]);
                startActivity(intent);


            }   // onItemClick
        });

    }   // createListView

}
