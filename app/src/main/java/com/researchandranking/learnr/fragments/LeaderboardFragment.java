package com.researchandranking.learnr.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.researchandranking.learnr.Adapter.LeaderboardAdapter;
import com.researchandranking.learnr.R;
import com.researchandranking.learnr.model.LeaderboardUser;
import com.researchandranking.learnr.util.Util;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment {

    private ImageView firstUserDp;
    private TextView firstUserName;
    private TextView firstUserPoints;
    private ImageView secondUserDp;
    private TextView secondUserName;
    private TextView secondUserPoints;
    private ImageView thirdUserDp;
    private TextView thirdUserName;
    private TextView thirdUserPoints;
    private RecyclerView recyclerView;
    private LeaderboardAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_leaderboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        List<LeaderboardUser> leaderboardUserList = getLeaderBoardUser();
        setTopThreeUser(firstUserDp, firstUserName, firstUserPoints, leaderboardUserList);
        setTopThreeUser(secondUserDp, secondUserName, secondUserPoints, leaderboardUserList);
        setTopThreeUser(thirdUserDp, thirdUserName, thirdUserPoints, leaderboardUserList);

        adapter = new LeaderboardAdapter(getContext().getApplicationContext(), leaderboardUserList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void initViews(View view){
        firstUserDp = view.findViewById(R.id.first_user_dp);
        firstUserName = view.findViewById(R.id.first_user_name);
        firstUserPoints = view.findViewById(R.id.first_user_points);
        secondUserDp = view.findViewById(R.id.second_user_dp);
        secondUserName = view.findViewById(R.id.second_user_name);
        secondUserPoints = view.findViewById(R.id.second_user_points);
        thirdUserDp = view.findViewById(R.id.third_user_dp);
        thirdUserName = view.findViewById(R.id.third_user_name);
        thirdUserPoints = view.findViewById(R.id.third_user_points);
        recyclerView = view.findViewById(R.id.leaderboard_recyclerview);
    }

    private List<LeaderboardUser> getLeaderBoardUser(){
        List<LeaderboardUser> userList = new ArrayList<>();
        userList.add(new LeaderboardUser(1, R.drawable.leaderboard_img_1, 2000, "Divya"));
        userList.add(new LeaderboardUser(2, R.drawable.leaderboard_img_2, 1700, "Sharang"));
        userList.add(new LeaderboardUser(3, R.drawable.leaderboard_img_3, 1600, "Abhijit"));
        userList.add(new LeaderboardUser(4, R.drawable.leaderboard_img_4, 1521, "Anjali"));
        userList.add(new LeaderboardUser(5, R.drawable.leaderboard_img_5, 1221, "Akansha"));
        userList.add(new LeaderboardUser(6, R.drawable.leaderboard_img_6, 1210, "Soni"));
        userList.add(new LeaderboardUser(7, R.drawable.leaderboard_img_7, 1021, "Deepa"));
        userList.add(new LeaderboardUser(8, R.drawable.leaderboard_img_8, 521, "Gautam"));
        userList.add(new LeaderboardUser(9, R.drawable.leaderboard_img_9, 121, "Manjeet"));

        return userList;
    }

    private void setTopThreeUser(ImageView img, TextView name, TextView points, List<LeaderboardUser> userList){

        LeaderboardUser user = userList.get(0);
        Util.loadImage(getContext().getApplicationContext(), user.getDp(), img);
        name.setText(user.getName());
        points.setText(String.format("%d Points", user.getPoints()));
        userList.remove(0);
    }
}
