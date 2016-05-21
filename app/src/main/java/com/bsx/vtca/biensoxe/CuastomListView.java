package com.bsx.vtca.biensoxe;

import android.content.Context;
import android.content.Intent;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bsx.vtca.biensoxe.Data.DistrictItem;

import java.util.List;

/**
 * Created by danhhoang on 15/01/2016.
 */
public class CuastomListView extends ArrayAdapter<DistrictItem> {

    Context context;
    int resource;
    List<DistrictItem> object;

    public CuastomListView(Context context, int resource, List<DistrictItem> object) {
        super(context, resource, object);
        this.context = context;
        this.resource = resource;
        this.object = object;
    }

    private class ViewHoldel {
        TextView Id, Title, Html;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoldel holdel;
        if (convertView == null) {
            holdel = new ViewHoldel();
            convertView = View.inflate(context, resource, null);
            holdel.Id = (TextView) convertView.findViewById(R.id.txtId);
            holdel.Title = (TextView) convertView.findViewById(R.id.txtTitle);

            convertView.setTag(holdel);
        } else {
            holdel = (ViewHoldel) convertView.getTag();
        }

        DistrictItem item = object.get(position);

        final String title = item.getTitle().toString();
        final String html = item.getHtml().toString();
        String id = item.getId().toString();

        holdel.Id.setText(id);
        holdel.Title.setText(title);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Details.class);
                Bundle bundle = new Bundle();

                if (html != null) {
                    bundle.putString("title", title);
                    bundle.putString("html", html);
                    intent.putExtra("selectItem", bundle);

                    getContext().startActivity(intent);
                }
            }
        });

        return convertView;
    }
}
