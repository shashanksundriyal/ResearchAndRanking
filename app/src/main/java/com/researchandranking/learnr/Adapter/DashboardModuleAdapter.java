package com.researchandranking.learnr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.researchandranking.learnr.ItemClick;
import com.researchandranking.learnr.R;
import com.researchandranking.learnr.model.DashboardModule;
import com.researchandranking.learnr.util.Util;

import java.util.List;

public class DashboardModuleAdapter extends RecyclerView.Adapter<DashboardModuleAdapter.ModuleViewHolder> {

    private Context context;
    private List<DashboardModule> moduleList;
    private ItemClick itemClick;

    public DashboardModuleAdapter(Context context, List<DashboardModule> moduleList){
        this.context = context;
        this.moduleList = moduleList;
    }

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_module, parent, false);

        return new ModuleViewHolder(view, itemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {

        DashboardModule module = moduleList.get(position);
        Util.loadImage(context, module.getImage(), holder.image);
        holder.heading.setText(module.getHeading());
        holder.subHeading.setText(module.getSubHeading());

    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    public static class ModuleViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView heading;
        TextView subHeading;

        public ModuleViewHolder(@NonNull View itemView, final ItemClick itemClick) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            heading = itemView.findViewById(R.id.heading);
            subHeading = itemView.findViewById(R.id.sub_heading);

            itemView.setOnClickListener(v -> itemClick.onClick(getAdapterPosition()));
        }
    }
}
