package uk.co.placona.tradesafe.adapters;

import android.widget.RelativeLayout;
import android.widget.TextView;

import io.realm.RealmViewHolder;
import uk.co.placona.tradesafe.R;

public class TradeViewHolder extends RealmViewHolder {

    public RelativeLayout container;

    public TextView tradeTextView;
    public TextView tradeDateTextView;

    public TradeViewHolder(RelativeLayout container) {
        super(container);
        this.container = container;
        this.tradeTextView = (TextView) container.findViewById(R.id.trade_text);
        this.tradeDateTextView = (TextView) container.findViewById(R.id.trade_date);
    }
}
