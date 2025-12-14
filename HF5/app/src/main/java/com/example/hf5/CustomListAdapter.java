package com.example.hf5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private final List<ListItem> dataSource;
    private final LayoutInflater inflater;
    private final Context context;

    public CustomListAdapter(Context context, List<ListItem> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override public int getCount() { return dataSource.size(); }
    @Override public Object getItem(int position) { return dataSource.get(position); }
    @Override public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        ListItem item = (ListItem) getItem(position);

        textView.setText(item.getText());

        textView.setTextColor(ContextCompat.getColor(context, item.getColorResId()));

        return convertView;
    }
}
