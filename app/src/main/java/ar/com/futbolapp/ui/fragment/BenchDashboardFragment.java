package ar.com.futbolapp.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ar.com.futbolapp.R;
import ar.com.futbolapp.flows.BenchFlow;
import flowengine.annotations.flow.Flow;

/**
 * A simple {@link Fragment} subclass.
 */
public class BenchDashboardFragment extends BaseFragment {

    @Flow
    public BenchFlow benchFlow;

    public BenchDashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO: get this from bundle
        benchFlow.setCurrentBenchId(5l);
        View fragment = inflater.inflate(R.layout.fragment_bench_dashboard, container, false);
        Button eventsButton = (Button) fragment.findViewById(R.id.events_button);
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                benchFlow.viewEvents();
            }
        });
        Button historyButton = (Button) fragment.findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                benchFlow.viewHistory();
            }
        });
        Button statsButton = (Button) fragment.findViewById(R.id.stats_button);
        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                benchFlow.viewOverallStats();
            }
        });
        Button rankingButton = (Button) fragment.findViewById(R.id.ranking_button);
        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                benchFlow.viewRanking();
            }
        });
        return fragment;
    }
}
