package am.aca.first.aca_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class AdViewHolder extends RecyclerView.ViewHolder {
    public TextView ad;

    public AdViewHolder(View itemView) {
        super(itemView);
        ad = itemView.findViewById(R.id.content_view_ad_item);
    }
}
