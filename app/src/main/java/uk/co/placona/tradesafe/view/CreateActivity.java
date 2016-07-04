package uk.co.placona.tradesafe.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.databinding.ActivityCreateBinding;

public class CreateActivity extends AppCompatActivity {

    private static final String TAG = "CreateActivity";
    private ActivityCreateBinding binding;
    private boolean bVideoIsBeingTouched = false;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create);

        Intent intent = getIntent();
        Uri videoUri = intent.getData();

        startVideo(videoUri);
    }

    private void startVideo(Uri videoUri) {
        binding.videoView.setVideoURI(videoUri);
        binding.videoView.start();

        binding.videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!bVideoIsBeingTouched) {
                    bVideoIsBeingTouched = true;
                    if (binding.videoView.isPlaying()) {
                        binding.videoView.pause();
                    } else {
                        binding.videoView.start();
                    }
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            bVideoIsBeingTouched = false;
                        }
                    }, 100);
                }
                return true;
            }
        });
    }
}
