package com.researchandranking.learnr.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.researchandranking.learnr.fragments.CardViewPagerFragment;

import java.util.List;

public class CardPagerAdapter extends FragmentStatePagerAdapter {

    private List<CardViewPagerFragment> fragmentList;

    public CardPagerAdapter(@NonNull FragmentManager fm, int behavior, List<CardViewPagerFragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
