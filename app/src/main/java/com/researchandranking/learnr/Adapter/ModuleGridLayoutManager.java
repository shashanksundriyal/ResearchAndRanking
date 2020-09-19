package com.researchandranking.learnr.Adapter;


import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ModuleGridLayoutManager extends GridLayoutManager {

    public ModuleGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ModuleGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public ModuleGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return spanLayoutSize(super.generateDefaultLayoutParams());
    }

    @Override
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        return spanLayoutSize(super.generateLayoutParams(c, attrs));
    }

    @Override
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return spanLayoutSize(super.generateLayoutParams(lp));
    }

    @Override
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return super.checkLayoutParams(lp);
    }

    private RecyclerView.LayoutParams spanLayoutSize(RecyclerView.LayoutParams layoutParams){
        if(getOrientation() == HORIZONTAL){
//            layoutParams.width = (int) Math.round(getHorizontalSpace() / Math.ceil(getItemCount() / getSpanCount()));

            int width = (int) Math.round(getHorizontalSpace() / Math.ceil(getItemCount() / getSpanCount()));
            int height = (int) Math.round(getVerticalSpace() / Math.ceil(getSpanCount()));
            layoutParams.width = layoutParams.height = Math.min(width, height) - 20;

        }
        else if(getOrientation() == VERTICAL){
            layoutParams.height = (int) Math.round(getVerticalSpace() / Math.ceil(getItemCount() / getSpanCount()));
        }
        return layoutParams;
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
    @Override
    public boolean canScrollHorizontally() {
        return false;
    }

    private int getHorizontalSpace() {
        return getWidth() - getPaddingRight() - getPaddingLeft();
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }
}