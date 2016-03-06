package appewtc.masterung.smileplant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Click1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView fruitImageView, bladeImageView,flowerImageView,rootImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click1);

        bindWidget();
        imageController();
    }

    private void imageController() {
        fruitImageView.setOnClickListener(this);
        bladeImageView.setOnClickListener(this);
        flowerImageView.setOnClickListener(this);
        rootImageView.setOnClickListener(this);
    }   // imageController
    private void bindWidget() {
        fruitImageView = (ImageView) findViewById(R.id.fruit);
        bladeImageView = (ImageView) findViewById(R.id.blade);
        flowerImageView = (ImageView) findViewById(R.id.flower);
        rootImageView = (ImageView) findViewById(R.id.root);
    }   //bindWidget

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fruit:
                startActivity(new Intent(Click1.this, Listview.class));
                break;
            case R.id.blade:
                startActivity(new Intent(Click1.this, Listview.class));
                break;
            case R.id.flower:
                startActivity(new Intent(Click1.this, Listview.class));
                break;
            case R.id.root:
                startActivity(new Intent(Click1.this, Listview.class));
                break;

        }   // switch
    }   // onClick
}
