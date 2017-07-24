package ar.com.futbolapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.futbolapp.R;

public class BenchRankingFragment extends BaseFragment {

    public BenchRankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_bench_ranking, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
