package com.dmtaiwan.alexander.myapplication.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmtaiwan.alexander.myapplication.R;
import com.dmtaiwan.alexander.myapplication.models.MainItem;

import java.util.ArrayList;

/**
 * Created by Alexander on 9/25/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ArrayList<MainItem> items;

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        //get item
        MainItem item = items.get(position);
        //set description
        holder.listItemTextView.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }else return 0;
    }

    public void setData(ArrayList<MainItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        public TextView listItemTextView;

        public MainViewHolder(View itemView) {
            super(itemView);
            listItemTextView = (TextView) itemView.findViewById(R.id.list_item_text_view);
        }
    }
}
