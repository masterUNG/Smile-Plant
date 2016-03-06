package appewtc.masterung.smileplant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Click3 extends AppCompatActivity implements View.OnClickListener {

    private ImageView hotImageView, rainImageView,coldImageView,overImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click3);
        setContentView(R.layout.activity_click3);
        setContentView(R.layout.activity_click3);
        setContentView(R.layout.activity_click3);
        bindWidget();
        imageController();

    }

    private void imageController() {
        hotImageView.setOnClickListener(this);
        rainImageView.setOnClickListener(this);
        coldImageView.setOnClickListener(this);
        overImageView.setOnClickListener(this);
    }   // imageController
    private void bindWidget() {
        hotImageView = (ImageView) findViewById(R.id.hot);
        rainImageView = (ImageView) findViewById(R.id.rain);
        coldImageView = (ImageView) findViewById(R.id.cold);
        overImageView = (ImageView) findViewById(R.id.over);
    }   //bindWidget

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hot:
                startActivity(new Intent(Click3.this, Listview.class));
                break;
            case R.id.rain:
                startActivity(new Intent(Click3.this, Listview.class));
                break;
            case R.id.cold:
                startActivity(new Intent(Click3.this, Listview.class));
                break;
            case R.id.over:
                startActivity(new Intent(Click3.this, Listview.class));
                break;

        }   // switch
    }   // onClick

}
