package com.bytedance.clockapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bytedance.clockapplication.widget.Clock;

public class MainActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    static Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mClockView.setShowAnalog(mClockView.isShowAnalog());
            handler.postDelayed(runnable,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);

        handler.postDelayed(runnable,0);

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClockView.setShowAnalog(!mClockView.isShowAnalog());
            }
        });

    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}
