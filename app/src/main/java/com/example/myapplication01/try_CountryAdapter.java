package com.example.myapplication01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class try_CountryAdapter extends RecyclerView.Adapter<try_CountryAdapter.CountryHolder> {

    List<try_Country> list_country;
    public try_CountryAdapter(List<try_Country> list_country) {
        this.list_country = list_country;
    }

    @Override
    public CountryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.try_country_row_layout, parent, false);
        return new CountryHolder(view);
    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
//
//    }


    @Override
    public void onBindViewHolder(CountryHolder holder, int position) {
        try_Country country = list_country.get(position);
        holder.title.setText(country.getTitle());
        holder.subtitle.setText(country.getSubtitle());

    }

    @Override
    public int getItemCount() {
        return list_country.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;

        public CountryHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_textView);
            subtitle = itemView.findViewById(R.id.subtitle_textView);
        }
    }
}
