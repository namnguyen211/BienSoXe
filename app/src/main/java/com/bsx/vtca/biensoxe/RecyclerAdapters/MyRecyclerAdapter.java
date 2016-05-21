package com.bsx.vtca.biensoxe.RecyclerAdapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsx.vtca.biensoxe.Data.DistrictItem;
import com.bsx.vtca.biensoxe.Details;
import com.bsx.vtca.biensoxe.R;

import java.util.List;

/**
 * Created by danhhoang on 17/01/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<ListViewRowHolder> {

    private List<DistrictItem> itemList;
    private Context context;
    private int focusedItem = 0;

    public MyRecyclerAdapter(Context context, List<DistrictItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ListViewRowHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listview, null);
        ListViewRowHolder holder = new ListViewRowHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListViewRowHolder holder, int position) {
        DistrictItem item = itemList.get(position);
        holder.itemView.setSelected(focusedItem == position);
        holder.getLayoutPosition();

        final String title = item.getTitle().toString();
        final String html = item.getHtml().toString();
        String id = item.getId().toString();

        holder.id.setText(id);
        holder.title.setText(title);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                Bundle bundle = new Bundle();

                if (html != null) {
                    bundle.putString("title", title);
                    bundle.putString("html", html);
                    intent.putExtra("selectItem", bundle);

                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }
}
