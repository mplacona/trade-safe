package uk.co.placona.tradesafe.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;
import uk.co.placona.tradesafe.models.Trade;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.view.EditActivity;

public class TradeRecyclerViewAdapter extends RealmBasedRecyclerViewAdapter<
        Trade, TradeRecyclerViewAdapter.ViewHolder> {

    Context context;

    public TradeRecyclerViewAdapter(Context context,
            RealmResults<Trade> realmResults) {
        super(context, realmResults, true, true);
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
        context = viewGroup.getContext();
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
                        //Toast.makeText(context, tradeModel.getId().toString(), Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context, EditActivity.class)
                                .putExtra("ID", tradeModel.getId().toString()));
                    }
                }
        );
    }
}