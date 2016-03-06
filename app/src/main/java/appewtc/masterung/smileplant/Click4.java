package appewtc.masterung.smileplant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Click4 extends AppCompatActivity implements View.OnClickListener {

    private ImageView seedImageView, cutImageView,spireImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click4);
        setContentView(R.layout.activity_click4);
        setContentView(R.layout.activity_click4);

        bindWidget();
        imageController();
    }

    private void imageController() {
        seedImageView.setOnClickListener(this);
        cutImageView.setOnClickListener(this);
        spireImageView.setOnClickListener(this);
    }   // imageController
    private void bindWidget() {
        seedImageView = (ImageView) findViewById(R.id.seed);
        cutImageView = (ImageView) findViewById(R.id.cut);
        spireImageView = (ImageView) findViewById(R.id.spire);
    }   //bindWidget

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.seed:
                startActivity(new Intent(Click4.this, Listview.class));
                break;
            case R.id.cut:
                startActivity(new Intent(Click4.this, Listview.class));
                break;
            case R.id.spire:
                startActivity(new Intent(Click4.this, Listview.class));
                break;

        }   // switch
    }   // onClick

}
