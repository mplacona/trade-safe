package uk.co.placona.tradesafe.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.text.SimpleDateFormat;

import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import uk.co.placona.tradesafe.models.Trade;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.view.EditActivity;

public class TradeRecyclerViewAdapter extends RealmBasedRecyclerViewAdapter<
        Trade, TradeViewHolder> {

    Context context;

    public TradeRecyclerViewAdapter(Context context,
            RealmResults<Trade> realmResults) {
        super(context, realmResults, true, true);
    }

    @Override
    public int getItemCount() {
        return realmResults.size();
    }

    @Override
    public TradeViewHolder onCreateRealmViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_trade, parent, false);
        context = parent.getContext();
        return new TradeViewHolder((RelativeLayout) v);
    }

    @Override
    public void onBindRealmViewHolder(TradeViewHolder viewHolder, int position) {
        final Trade tradeModel = realmResults.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm a");
        String dateString = sdf.format(tradeModel.getDate());

        viewHolder.tradeTextView.setText(tradeModel.getReference());
        viewHolder.tradeDateTextView.setText(dateString);

        viewHolder.itemView.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, EditActivity.class)
                            .putExtra("ID", tradeModel.getId()));
                }
            }
        );
    }

}