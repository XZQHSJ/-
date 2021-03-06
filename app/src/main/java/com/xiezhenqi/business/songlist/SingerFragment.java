package com.xiezhenqi.business.songlist;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.xiezhenqi.R;
import com.xiezhenqi.base.list.fragment.BaseListFragment;
import com.xiezhenqi.business.search.SearchActivity;
import com.xiezhenqi.widget.divider.DividerItemDecoration;

import java.util.Arrays;
import java.util.List;

/**
 * SingerFragment
 * Created by Tse on 2016/10/30.
 */

public class SingerFragment extends BaseListFragment implements SongAdapter.OnHolderClickListener {

    private SongAdapter mAdapter = new SongAdapter(this);

    @Override
    protected void initRecyclerView(RecyclerView recyclerView, ViewGroup container) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.drawable.divider_common_horizontal)));
    }

    @Override
    protected void loadData(boolean loadFirstPage) {
        List<String> list =
                Arrays.asList(getActivity().getResources().getStringArray(R.array.singer_list));
        showNormal();
        mAdapter.setData(list);
    }

    @Override
    public void onItemClick(String s, int pos) {
        SearchActivity.start(getActivity(), s);
    }

    public static String getPageTitle() {
        return "歌手";
    }
}




