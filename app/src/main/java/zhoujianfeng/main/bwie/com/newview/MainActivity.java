package zhoujianfeng.main.bwie.com.newview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zhoujianfeng.main.bwie.com.newview.view.WaterView;

public class MainActivity extends AppCompatActivity {


    private Context mContext;
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.but_water:
                    startActivity(new Intent(mContext, WaterActivity.class));
                    break;
                case R.id.but_line:
                    startActivity(new Intent(mContext, LineActivity.class));
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.but_water).setOnClickListener(clickListener);
        findViewById(R.id.but_line).setOnClickListener(clickListener);
    }

}
