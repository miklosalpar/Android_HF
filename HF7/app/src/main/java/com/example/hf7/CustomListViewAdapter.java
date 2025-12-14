package com.example.hf7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomListViewAdapter extends RecyclerView.Adapter<CustomListViewAdapter.AnimalViewHolder> {

    private String[] names;
    private String[] infos;
    private Integer[] images;

    public CustomListViewAdapter(String[] names, String[] infos, Integer[] images) {
        this.names = names;
        this.infos = infos;
        this.images = images;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        String name = names[position];
        String info = infos[position];
        int imageId = images[position];

        holder.nev.setText(name);
        holder.leiras.setText(info);
        holder.kep.setImageResource(imageId);

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(),
                    "Állat neve: " + name,
                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        public ImageView kep;
        public TextView nev;
        public TextView leiras;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            kep = itemView.findViewById(R.id.image);
            nev = itemView.findViewById(R.id.name);
            leiras = itemView.findViewById(R.id.description);
        }
    }
}
