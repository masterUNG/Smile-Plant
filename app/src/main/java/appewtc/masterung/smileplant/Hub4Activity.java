package appewtc.masterung.smileplant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hub4Activity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub4);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("ส่วนของผลผลิต");     //C1
        listDataHeader.add("อายุการปลูก");       //C2
        listDataHeader.add("ฤดูกาลที่ปลูก");      //C3
        listDataHeader.add("วิธีการปลูก");        //C4

        // Adding child data
        List<String> C1 = new ArrayList<String>();
        C1.add("ผล");
        C1.add("ใบและลำต้น");
        C1.add("ดอก");
        C1.add("รากหรือหัว");

        List<String> C2 = new ArrayList<String>();
        C2.add("อายุสั้น");
        C2.add("อายุปานกลาง");
        C2.add("อายุยาว");

        List<String> C3 = new ArrayList<String>();
        C3.add("ฤดูร้อน");
        C3.add("ฤดูฝน");
        C3.add("ฤดูหนาว");
        C3.add("ปลูกได้ตลอดปี");

        List<String> C4 = new ArrayList<String>();
        C4.add("ปลูกด้วยเมล็ด");
        C4.add("การปักชำ");
        C4.add("การแตกหน่อ");

        listDataChild.put(listDataHeader.get(0), C1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), C2);
        listDataChild.put(listDataHeader.get(2), C3);
        listDataChild.put(listDataHeader.get(3), C4);
    }
}
