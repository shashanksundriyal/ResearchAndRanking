package com.researchandranking.learnr.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.researchandranking.learnr.Adapter.SubModuleAdapter;
import com.researchandranking.learnr.ItemClick;
import com.researchandranking.learnr.R;
import com.researchandranking.learnr.decorator.ModuleItemDecorator;
import com.researchandranking.learnr.decorator.SubModuleItemDecorator;
import com.researchandranking.learnr.model.SubModule;

import java.util.ArrayList;
import java.util.List;

public class SubModuleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SubModuleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_module);

        recyclerView = findViewById(R.id.sub_module_recyclerview);
        adapter = new SubModuleAdapter(getSubModuleList(), getApplicationContext());
        adapter.setItemClick(itemClick);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SubModuleItemDecorator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        findViewById(R.id.back).setOnClickListener(v -> finish());
    }

    private ItemClick itemClick = new ItemClick() {
        @Override
        public void onClick(int position) {
            if(position == 0){
                Intent intent = new Intent(SubModuleActivity.this, ChapterActivity.class);
                startActivity(intent);
            }
        }
    };

    private List<SubModule> getSubModuleList(){
        List<SubModule> subModuleList = new ArrayList<>();
        subModuleList.add(new SubModule("Why invest?", "Why you should invest in stock market?", R.drawable.submodule_1));
        subModuleList.add(new SubModule("Basics of stock market.", "What you should know before investing", R.drawable.submodule_2));
        subModuleList.add(new SubModule("finding great companies", "Where you should invest", R.drawable.submodule_3));
        subModuleList.add(new SubModule("Your investing life?", "Everything you should know about investing", R.drawable.submodule_4));
        subModuleList.add(new SubModule("Getting started.", "How you should start investing?", R.drawable.submodule_5));

        return subModuleList;
    }
}