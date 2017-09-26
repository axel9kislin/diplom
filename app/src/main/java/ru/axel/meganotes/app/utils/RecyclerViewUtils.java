package ru.axel.meganotes.app.utils;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewUtils {
    public static RecyclerView initRecyclerView(LinearLayoutManager linearLayoutManager, RecyclerView recyclerView,
                                         RecyclerView.Adapter<?> adapter) {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }
}
