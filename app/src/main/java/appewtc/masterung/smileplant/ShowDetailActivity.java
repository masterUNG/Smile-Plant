package appewtc.masterung.smileplant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView textView1, textView2, textView3, textView4,
            textView5, textView6, textView7, textView8, textView9,
            textView10, textView11, textView12, textView13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        //Bind Widget
        bindWidget();

        //Get Value From Intent
        getValueFromIntent();

    }   // Main Method

    private void getValueFromIntent() {
        textView1.setText(getIntent().getStringExtra(ManageTABLE.column_Nameth));
        textView2.setText(getIntent().getStringExtra(ManageTABLE.column_Nameeng));
        textView3.setText(getIntent().getStringExtra(ManageTABLE.column_HProduc));
        textView4.setText(getIntent().getStringExtra(ManageTABLE.column_HAge));
        textView5.setText(getIntent().getStringExtra(ManageTABLE.column_HSeason));
        textView6.setText(getIntent().getStringExtra(ManageTABLE.column_HPlant));
        textView7.setText(getIntent().getStringExtra(ManageTABLE.column_Data));
        textView8.setText(getIntent().getStringExtra(ManageTABLE.column_ground));
        textView9.setText(getIntent().getStringExtra(ManageTABLE.column_plant));
        textView10.setText(getIntent().getStringExtra(ManageTABLE.column_water));
        textView11.setText(getIntent().getStringExtra(ManageTABLE.column_compost));
        textView12.setText(getIntent().getStringExtra(ManageTABLE.column_protect));
        textView13.setText(getIntent().getStringExtra(ManageTABLE.column_Harvest));
    }

    private void bindWidget() {
        textView1 = (TextView) findViewById(R.id.textView2);
        textView2 = (TextView) findViewById(R.id.textView3);
        textView3 = (TextView) findViewById(R.id.textView4);
        textView4 = (TextView) findViewById(R.id.textView5);
        textView5 = (TextView) findViewById(R.id.textView8);
        textView6 = (TextView) findViewById(R.id.textView9);
        textView7 = (TextView) findViewById(R.id.textView10);
        textView8 = (TextView) findViewById(R.id.textView11);
        textView9 = (TextView) findViewById(R.id.textView12);
        textView10 = (TextView) findViewById(R.id.textView13);
        textView11 = (TextView) findViewById(R.id.textView14);
        textView12 = (TextView) findViewById(R.id.textView15);
        textView13 = (TextView) findViewById(R.id.textView16);
    }

}   //Main Class
