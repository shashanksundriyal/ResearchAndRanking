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

import com.researchandranking.learnr.R;
import com.researchandranking.learnr.model.LeaderboardUser;
import com.researchandranking.learnr.util.Util;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private Context context;
    private List<LeaderboardUser> leaderboardUserList;

    public LeaderboardAdapter(Context context, List<LeaderboardUser> leaderboardUserList){
        this.context = context;
        this.leaderboardUserList = leaderboardUserList;
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_item, parent, false);

        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        LeaderboardUser leaderboardUser = leaderboardUserList.get(position);
        holder.name.setText(leaderboardUser.getName());
        holder.points.setText(String.format("%d Points", leaderboardUser.getPoints()));
        holder.rank.setText(String.valueOf(leaderboardUser.getRank()));
        Util.loadImage(context, leaderboardUser.getDp(), holder.dp);
    }

    @Override
    public int getItemCount() {
        return leaderboardUserList.size();
    }

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        TextView rank;
        TextView name;
        TextView points;
        ImageView dp;

        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.rank);
            name = itemView.findViewById(R.id.name);
            points = itemView.findViewById(R.id.points);
            dp = itemView.findViewById(R.id.dp);
        }
    }
}
