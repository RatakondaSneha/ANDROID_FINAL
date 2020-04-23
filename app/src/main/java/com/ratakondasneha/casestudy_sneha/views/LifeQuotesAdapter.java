package com.ratakondasneha.casestudy_sneha.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.ratakondasneha.casestudy_sneha.R;
import com.ratakondasneha.casestudy_sneha.model.LifeQuotesInfo;

import java.util.ArrayList;

public class LifeQuotesAdapter extends ListAdapter<LifeQuotesInfo, LifeQuotesVewHolder> {
    private ArrayList<LifeQuotesInfo> data;
    private static final DiffUtil.ItemCallback<LifeQuotesInfo> DIFF_CALLBACK = new DiffUtil.ItemCallback<LifeQuotesInfo>() {
        @Override
        public boolean areItemsTheSame(@NonNull LifeQuotesInfo oldItem, @NonNull LifeQuotesInfo newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull LifeQuotesInfo oldItem, @NonNull LifeQuotesInfo newItem) {
            return oldItem.equals(newItem);
        }
    };

    public LifeQuotesAdapter(ArrayList<LifeQuotesInfo> data)
    {
        super(DIFF_CALLBACK);
        this.data = data;
        submitList(data);
    }

    @NonNull
    @Override
    public LifeQuotesVewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_quotes_recyclerview,parent,false);
        return new LifeQuotesVewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LifeQuotesVewHolder holder, int position) {
        holder.populate(data.get(position));
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }



}
