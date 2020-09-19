package com.researchandranking.learnr.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.researchandranking.learnr.Adapter.CardPagerAdapter;
import com.researchandranking.learnr.R;
import com.researchandranking.learnr.fragments.CardViewPagerFragment;
import com.researchandranking.learnr.model.Chapter;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class ChapterActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView chapterNo, chapterName;
    private TabLayout tabLayout;
    private String dummyInfo = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. " +
            "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'," +
            " making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, " +
            "and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by " +
            "accident, sometimes on purpose (injected humour and the like).\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        viewPager = findViewById(R.id.view_pager);
        chapterName = findViewById(R.id.chapter_name);
        chapterNo = findViewById(R.id.chapter_no);
        tabLayout = findViewById(R.id.tablayout);
        findViewById(R.id.back).setOnClickListener(v -> finish());
        init();
    }

    private void init(){
        List<CardViewPagerFragment> cardFragments = new ArrayList<>();
        List<Chapter> chapterList = getChapters();
        for(Chapter chapter : chapterList){
            CardViewPagerFragment fragment = CardViewPagerFragment.getInstance(chapter);
            cardFragments.add(fragment);
        }
        CardPagerAdapter pagerAdapter = new CardPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, cardFragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(80, 0, 80, 0);
        viewPager.setPageMargin(20);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Chapter chapter = chapterList.get(position);
                chapterName.setText(chapter.getTitle());
                chapterNo.setText(String.format("Chapter %d/%d", position + 1, chapterList.size()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setupWithViewPager(viewPager, true);
    }



    private List<Chapter> getChapters(){
        List<Chapter> chapterList = new ArrayList<>();
        chapterList.add(new Chapter("Why invest?", R.drawable.card_1, dummyInfo));
        chapterList.add(new Chapter("Chapter 2", R.drawable.card_2, dummyInfo));
        chapterList.add(new Chapter("Chapter 3", R.drawable.card_3, dummyInfo));
        chapterList.add(new Chapter("Chapter 4", R.drawable.card_4, dummyInfo));
        chapterList.add(new Chapter("Chapter 5", R.drawable.card_5, dummyInfo));
        chapterList.add(new Chapter("Chapter 6", R.drawable.card_6, dummyInfo));
        return chapterList;
    }
}