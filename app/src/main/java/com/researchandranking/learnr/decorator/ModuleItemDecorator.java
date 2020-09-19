package com.researchandranking.learnr.decorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModuleItemDecorator extends RecyclerView.ItemDecoration {

    private int spanCount;

    public ModuleItemDecorator(int spanCount){
        this.spanCount = spanCount;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        for(int i = 0; i < parent.getChildCount(); i++){

            View child = parent.getChildAt(i);
            int width = parent.getWidth();
            int height = parent.getHeight();
            int heightTakenByChildren = child.getMeasuredHeight() * spanCount;
            int widthTakenByChildren = child.getMeasuredWidth() * (parent.getChildCount() / spanCount);

            int spaceRemainingInWidth = width - widthTakenByChildren;
            int spaceRemainingInHeight = height - heightTakenByChildren;
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            if(spaceRemainingInWidth > 0){
                if(i < spanCount){
                    params.rightMargin = (spaceRemainingInWidth / spanCount ) / 2;
                    params.leftMargin = spaceRemainingInWidth / spanCount;
                } else {
                    params.leftMargin = (spaceRemainingInWidth / spanCount ) / 2;
                    params.rightMargin = spaceRemainingInWidth / spanCount;
                }
            }

            if(spaceRemainingInHeight > 0){
                params.topMargin = spaceRemainingInHeight / spanCount;
            }
            child.setLayoutParams(params);
        }
    }

}
