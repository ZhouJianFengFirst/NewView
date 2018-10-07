package zhoujianfeng.main.bwie.com.newview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import zhoujianfeng.main.bwie.com.newview.view.WaterView;

public class WaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        WaterView waterView = findViewById(R.id.waterview);
        final ImageView iamge = findViewById(R.id.tou);
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iamge.getLayoutParams();
        waterView.setLisener(new WaterView.AnimalLisener() {
            @Override
            public void getHeight(int y) {
                layoutParams.setMargins(0, 0, 0, y);
                iamge.setLayoutParams(layoutParams);
            }
        });
    }
}
