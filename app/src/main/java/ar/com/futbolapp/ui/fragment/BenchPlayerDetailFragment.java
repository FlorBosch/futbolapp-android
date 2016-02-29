package ar.com.futbolapp.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import ar.com.futbolapp.R;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.flows.BenchFlow;
import ar.com.futbolapp.webservice.BenchWebService;
import ar.com.futbolapp.webservice.events.GetBenchPlayerSuccessEvent;
import flowengine.WebResponse;
import flowengine.annotations.flow.Flow;

public class BenchPlayerDetailFragment extends BaseFragment {

    public BenchWebService benchWebService;

    @Flow
    public BenchFlow flow;

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
        benchWebService.getPlayer(flow.getCurrentBenchId(), flow.getCurrentPlayerId(), new WebResponse(new GetBenchPlayerSuccessEvent()));
    }

    public void onEventMainThread(GetBenchPlayerSuccessEvent e) {
        Player player = e.get();
        ((TextView) getView().findViewById(R.id.player_name)).setText(player.getName());
        ((TextView) getView().findViewById(R.id.player_average)).setText(String.valueOf(player.getAverage()));
    }
}
