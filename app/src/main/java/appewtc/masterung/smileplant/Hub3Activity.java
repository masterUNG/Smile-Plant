package appewtc.masterung.smileplant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Hub3Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView productImageView, ageImageView,seasonImageView,plantImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub3);

        setContentView(R.layout.activity_hub3);
        bindWidget();
        imageController();

    }


    private void imageController() {
        productImageView.setOnClickListener(this);
        ageImageView.setOnClickListener(this);
        seasonImageView.setOnClickListener(this);
        plantImageView.setOnClickListener(this);
    }   // imageController
    private void bindWidget() {
        productImageView = (ImageView) findViewById(R.id.product);
        ageImageView = (ImageView) findViewById(R.id.age);
        seasonImageView = (ImageView) findViewById(R.id.season);
        plantImageView = (ImageView) findViewById(R.id.plant);
    }   //bindWidget

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.product:
                startActivity(new Intent(Hub3Activity.this, Click1.class));
                break;
            case R.id.age:
                startActivity(new Intent(Hub3Activity.this, Click2.class));
                break;
            case R.id.season:
                startActivity(new Intent(Hub3Activity.this, Click3.class));
                break;
            case R.id.plant:
                startActivity(new Intent(Hub3Activity.this, Click4.class));
                break;

        }   // switch
    }   // onClick

}
