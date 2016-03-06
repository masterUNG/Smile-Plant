package appewtc.masterung.smileplant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Click2 extends AppCompatActivity implements View.OnClickListener {

    private ImageView shortImageView, mediumImageView,longImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click2);

        setContentView(R.layout.activity_click2);

        setContentView(R.layout.activity_click2);

        bindWidget();
        imageController();

    }

    private void imageController() {
        shortImageView.setOnClickListener(this);
        mediumImageView.setOnClickListener(this);
        longImageView.setOnClickListener(this);
    }   // imageController
    private void bindWidget() {
        shortImageView = (ImageView) findViewById(R.id.shortImageView);
        mediumImageView = (ImageView) findViewById(R.id.medium);
        longImageView = (ImageView) findViewById(R.id.longImageView);
    }   //bindWidget

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shortImageView:
                startActivity(new Intent(Click2.this, Listview.class));
                break;
            case R.id.medium:
                startActivity(new Intent(Click2.this, Listview.class));
                break;
            case R.id.longImageView:
                startActivity(new Intent(Click2.this, Listview.class));
                break;

        }   // switch
    }   // onClick

}
