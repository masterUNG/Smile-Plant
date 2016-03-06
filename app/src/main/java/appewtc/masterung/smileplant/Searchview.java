package appewtc.masterung.smileplant;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Searchview extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ListView listView;
    private SearchView mSearchView;
//    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);

        listView = (ListView) findViewById(R.id.list_view);
        createListView();

        mSearchView = (SearchView) findViewById(R.id.search_view);
//        mListView = (ListView) findViewById(R.id.list_view);
//        mListView.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                mStrings));
        setupSearchView();

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

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Search Here");
    }

    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            listView.clearTextFilter();
        } else {
            listView.setFilterText(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

}
