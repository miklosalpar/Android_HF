package com.example.hf4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends BaseAdapter {

    private final Context context;
    private final List<Currency> dataSource;
    private final LayoutInflater inflater;

    public CurrencyAdapter(Context context, List<Currency> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_currency, parent, false);
            holder = new ViewHolder();
            holder.flagImageView = convertView.findViewById(R.id.image_flag);
            holder.codeTextView = convertView.findViewById(R.id.text_code);
            holder.nameTextView = convertView.findViewById(R.id.text_name);
            holder.buyingRateTextView = convertView.findViewById(R.id.text_buying_rate);
            holder.sellingRateTextView = convertView.findViewById(R.id.text_selling_rate);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Currency currency = (Currency) getItem(position);

        holder.flagImageView.setImageResource(currency.getFlagResId());
        holder.codeTextView.setText(currency.getCode());
        holder.nameTextView.setText(currency.getName());

        holder.buyingRateTextView.setText(currency.getBuyingRate() + " RON");
        holder.sellingRateTextView.setText(currency.getSellingRate() + " RON");

        return convertView;
    }

    static class ViewHolder {
        ImageView flagImageView;
        TextView codeTextView;
        TextView nameTextView;
        TextView buyingRateTextView;
        TextView sellingRateTextView;
    }
}
