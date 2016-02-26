package appewtc.masterung.smileplant;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Searchview extends AppCompatActivity  {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);

        listView = (ListView) findViewById(R.id.list_view);
        createListView();

    }


    private void createListView() {

        //Get Value From SQLite
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ManageTABLE.plant_table, null);
        cursor.moveToFirst();
        String[] namePlantStrings = new String[cursor.getCount()];
        ArrayList<String> stringArrayList = new ArrayList<String>();
        for (int i=0;i<cursor.getCount();i++) {
            namePlantStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Nameth));
            stringArrayList.add(namePlantStrings[i]);
            cursor.moveToNext();
        }   // for
        cursor.close();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(Searchview.this,
                android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(stringArrayAdapter);

    }   // createListView

}
