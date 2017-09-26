package ru.axel.meganotes.app.utils;

import android.support.v7.widget.GridLayout;
import android.view.View;

public class GridLayoutUtils {

    public static void addViewToGrid(GridLayout field, View view, int size) {
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();

        layoutParams.width = 0;
        layoutParams.height = size;
        layoutParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        layoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);

        field.addView(view, layoutParams);
    }
}
