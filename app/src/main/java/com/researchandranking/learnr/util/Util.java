package com.researchandranking.learnr.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.researchandranking.learnr.R;

public class Util {

    public static void loadImage(Context context, int drawable, ImageView imageView){
        Glide.with(context)
                .load(drawable)
                .into(imageView);
    }
}
