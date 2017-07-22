package ar.com.futbolapp.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.futbolapp.R;

public class BenchPlayerDetailFragment extends BaseFragment {

    public BenchPlayerDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bench_player_detail, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
