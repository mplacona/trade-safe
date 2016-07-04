package uk.co.placona.tradesafe.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.RealmResults;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.adapters.TradeRecyclerViewAdapter;
import uk.co.placona.tradesafe.component.Injector;
import uk.co.placona.tradesafe.databinding.ActivityMainBinding;
import uk.co.placona.tradesafe.models.Trade;
import uk.co.placona.tradesafe.repository.TradeRepository;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1;
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private RealmRecyclerView realmRecyclerView;
    private TradeRecyclerViewAdapter tradeAdapter;

    @Inject
    TradeRepository tradeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        Injector.getApplicationComponent().inject(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakeVideoIntent();
            }
        });

        realmRecyclerView = (RealmRecyclerView) findViewById(R.id.list_trades);

        // load some data
        addFakeData();

        loadTrades();
    }

    private void addFakeData() {
        tradeRepository.clear();

        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        for (int i = 0; i < 10; i++) {
            Trade tradeModel = new Trade("tradez"+i, "uri"+i, "description"+i, new Date(mydate));
            tradeRepository.add(tradeModel);
        }

    }

    private void loadTrades() {
        RealmResults<Trade> tradeModels = tradeRepository.findAll();
        //MyApplication.realm.where(Trade.class).findAllSorted("reference", Sort.ASCENDING);
        tradeAdapter = new TradeRecyclerViewAdapter(getBaseContext(), tradeModels);
        realmRecyclerView.setAdapter(tradeAdapter);
    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            startActivity(new Intent(this, CreateActivity.class)
                    .setData(videoUri));
        }
    }
}
