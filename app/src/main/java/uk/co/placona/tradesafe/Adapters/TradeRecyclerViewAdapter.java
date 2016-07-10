package uk.co.placona.tradesafe.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

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
        public TextView tradeDateTextView;

        public ViewHolder(RelativeLayout container) {
            super(container);
            this.container = container;
            this.tradeTextView = (TextView) container.findViewById(R.id.trade_text);
            this.tradeDateTextView = (TextView) container.findViewById(R.id.trade_date);
        }
    }

    @Override
    public int getItemCount() {
        return realmResults.size();
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_trade, parent, false);
        context = parent.getContext();
        return new ViewHolder((RelativeLayout) v);
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
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