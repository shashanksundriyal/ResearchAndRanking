package com.researchandranking.learnr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.researchandranking.learnr.ItemClick;
import com.researchandranking.learnr.R;
import com.researchandranking.learnr.model.SubModule;
import com.researchandranking.learnr.util.Util;

import java.util.List;

public class SubModuleAdapter extends RecyclerView.Adapter<SubModuleAdapter.SubModuleViewHolder> {

    private List<SubModule> subModuleList;
    private Context context;
    private ItemClick itemClick;

    public SubModuleAdapter(List<SubModule> subModuleList, Context context) {
        this.subModuleList = subModuleList;
        this.context = context;
    }

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public SubModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.submodule_item, parent, false);

        return new SubModuleViewHolder(view, itemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull SubModuleViewHolder holder, int position) {
        SubModule subModule = subModuleList.get(position);
        holder.heading.setText(subModule.getHeading());
        holder.subHeading.setText(subModule.getSubHeading());
        Util.loadImage(context, subModule.getImage(), holder.imageView);
    }

    @Override
    public int getItemCount() {
        return subModuleList.size();
    }

    public static class SubModuleViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView heading;
        TextView subHeading;

        public SubModuleViewHolder(@NonNull View itemView, ItemClick itemClick) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            heading = itemView.findViewById(R.id.heading);
            subHeading = itemView.findViewById(R.id.sub_heading);
            itemView.setOnClickListener(v -> itemClick.onClick(getAdapterPosition()));
        }
    }
}
