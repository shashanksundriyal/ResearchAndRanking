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

import com.researchandranking.learnr.R;
import com.researchandranking.learnr.model.Chapter;
import com.researchandranking.learnr.util.Util;

public class CardViewPagerFragment extends Fragment {

    private ImageView cardImage;
    private TextView info;

    private Chapter chapter;

    public static CardViewPagerFragment getInstance(Chapter chapter){
        CardViewPagerFragment cardViewPagerFragment = new CardViewPagerFragment();
        if(chapter != null){
            Bundle bundle = new Bundle();
            bundle.putParcelable("chapter", chapter);
            cardViewPagerFragment.setArguments(bundle);
        }
        return cardViewPagerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            chapter = getArguments().getParcelable("chapter");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chapter_card_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardImage = view.findViewById(R.id.img);
        info = view.findViewById(R.id.info);

        if(chapter != null){
            Util.loadImage(getActivity(), chapter.getImage(), cardImage);
            info.setText(chapter.getInformation());
        }
    }
}
