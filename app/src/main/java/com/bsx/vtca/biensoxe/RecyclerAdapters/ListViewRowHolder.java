package com.bsx.vtca.biensoxe.RecyclerAdapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bsx.vtca.biensoxe.R;

/**
 * Created by danhhoang on 17/01/2016.
 */
public class ListViewRowHolder extends RecyclerView.ViewHolder {

    protected TextView id;
    protected TextView title;
    protected CardView cardView;

    public ListViewRowHolder(View itemView) {
        super(itemView);

        this.id = (TextView) itemView.findViewById(R.id.txtId);
        this.title = (TextView) itemView.findViewById(R.id.txtTitle);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        itemView.setClickable(true);
    }
}
