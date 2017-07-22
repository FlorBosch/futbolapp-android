package ar.com.futbolapp.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ar.com.futbolapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BenchDashboardFragment extends BaseFragment {

    public BenchDashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_bench_dashboard, container, false);
        return fragment;
    }
}
