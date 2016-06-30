package uk.co.placona.tradesafe.Adapters;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;
import uk.co.placona.tradesafe.Models.Trade;
import uk.co.placona.tradesafe.R;

public class TradeRecyclerViewAdapter extends RealmBasedRecyclerViewAdapter<
        Trade, TradeRecyclerViewAdapter.ViewHolder> {

    public TradeRecyclerViewAdapter(
            Context context,
            RealmResults<Trade> realmResults) {
        super(context, realmResults, true, true, true, "reference");
    }

    public class ViewHolder extends RealmViewHolder {

        public RelativeLayout container;

        public TextView tradeTextView;

        public ViewHolder(RelativeLayout container) {
            super(container);
            this.container = container;
            this.tradeTextView = (TextView) container.findViewById(R.id.trade_text);
        }
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.item_trade, viewGroup, false);
        return new ViewHolder((RelativeLayout) v);
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
        final Trade tradeModel = realmResults.get(position);
        viewHolder.tradeTextView.setText(tradeModel.getReference());
        viewHolder.tradeTextView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //asyncRemoveCountry(tradeModel.getId());
                    }
                }
        );
    }
}