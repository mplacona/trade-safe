package uk.co.placona.tradesafe.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import javax.inject.Inject;

import uk.co.placona.tradesafe.CustomApplication;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.databinding.ActivityEditBinding;
import uk.co.placona.tradesafe.models.Trade;
import uk.co.placona.tradesafe.repository.TradeRepository;

public class EditActivity extends AppCompatActivity {
    private static final String TAG = "EditActivity";
    private ActivityEditBinding binding;
    private Trade trade;
    private boolean bVideoIsBeingTouched = false;
    private Handler mHandler = new Handler();
    private Uri videoUri;

    @Inject
    TradeRepository tradeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit);

        ((CustomApplication) getApplication())
                .getOrCreateApplicationComponent()
                .inject(this);

        Intent intent = getIntent();

        loadTrade(intent.getExtras().getString("ID"));
    }

    private void loadTrade(String id) {
        trade = tradeRepository.find(id);

        binding.descriptionTxt.setText(trade.getDescription());
        binding.referenceTxt.setText(trade.getReference());

        videoUri = Uri.parse(trade.getUri());
        startVideo(videoUri);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                editEntry();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    private void editEntry() {
        String referenceText = binding.referenceTxt.getText().toString();
        String descriptionText = binding.descriptionTxt.getText().toString();

        Trade cTrade = new Trade();
        cTrade.setId(trade.getId());
        cTrade.setReference(referenceText);
        cTrade.setDescription(descriptionText);
        cTrade.setUri(trade.getUri());
        cTrade.setDate(trade.getDate());

        tradeRepository.upsert(cTrade);

        // we're done here
        finish();
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
