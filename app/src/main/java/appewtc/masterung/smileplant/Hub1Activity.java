package appewtc.masterung.smileplant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Hub1Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView searchImageView, clickImageView,tickImageView;


    private void imageController() {

        searchImageView.setOnClickListener(this);
        clickImageView.setOnClickListener(this);
        tickImageView.setOnClickListener(this);
    }   // imageController

    private void bindWidget() {

        searchImageView = (ImageView) findViewById(R.id.search);
        clickImageView = (ImageView) findViewById(R.id.click);
        tickImageView = (ImageView) findViewById(R.id.tick);
    }   //bindWidget


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub1);

        bindWidget();

        imageController();

    }   // Main Method

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.search:
                startActivity(new Intent(Hub1Activity.this, Searchview.class));
                break;
            case R.id.click:
                startActivity(new Intent(Hub1Activity.this, Hub3Activity.class));
                break;
            case R.id.tick:
                startActivity(new Intent(Hub1Activity.this, Hub4Activity.class));
                break;
//            case R.id.imageView4:
//                startActivity(new Intent(MainActivity.this, Hub4Activity.class));
//                break;

        }   // switch

    }   // onClick

}   // Main Class
