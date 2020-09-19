package com.researchandranking.learnr.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.researchandranking.learnr.Adapter.DashboardModuleAdapter;
import com.researchandranking.learnr.Adapter.ModuleGridLayoutManager;
import com.researchandranking.learnr.ItemClick;
import com.researchandranking.learnr.R;
import com.researchandranking.learnr.activity.SubModuleActivity;
import com.researchandranking.learnr.decorator.ModuleItemDecorator;
import com.researchandranking.learnr.model.DashboardModule;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private RecyclerView moduleRecyclerView;
    private DashboardModuleAdapter moduleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moduleRecyclerView = view.findViewById(R.id.module_recyclerview);
        moduleAdapter = new DashboardModuleAdapter(getContext(), getModuleData());
        moduleAdapter.setItemClick(itemClick);
        moduleRecyclerView.setAdapter(moduleAdapter);
        moduleRecyclerView.setLayoutManager(new ModuleGridLayoutManager(getContext(), 3, RecyclerView.HORIZONTAL, false));
        moduleRecyclerView.addItemDecoration(new ModuleItemDecorator(3));
    }

    private List<DashboardModule> getModuleData(){

        List<DashboardModule> moduleList = new ArrayList<>();
        moduleList.add(new DashboardModule(R.drawable.moduel_1, "Learn with RNR", "Start now"));
        moduleList.add(new DashboardModule(R.drawable.module_3, "Blogs & Articles", "Read now"));
        moduleList.add(new DashboardModule(R.drawable.module_5, "Announcements", "Explore now"));
        moduleList.add(new DashboardModule(R.drawable.module_2, "Videos", "Watch now"));
        moduleList.add(new DashboardModule(R.drawable.module_4, "Monthly newsletter", "Explore now"));
        moduleList.add(new DashboardModule(R.drawable.module_6, "Monthly Research", "Explore now"));

        return moduleList;
    }

    private ItemClick itemClick = new ItemClick() {
        @Override
        public void onClick(int position) {
            if(position == 0){
                Intent intent = new Intent(getActivity(), SubModuleActivity.class);
                startActivity(intent);
            }
        }
    };
}
