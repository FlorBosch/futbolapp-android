package ar.com.futbolapp.ui.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ar.com.futbolapp.R;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.flows.BenchFlow;
import ar.com.futbolapp.ui.adapter.BenchRankingAdapter;
import ar.com.futbolapp.webservice.BenchWebService;
import ar.com.futbolapp.webservice.events.GetBenchPlayersSuccessEvent;
import flowengine.WebResponse;
import flowengine.annotations.flow.Flow;

public class BenchRankingFragment extends BaseFragment {

    public BenchWebService benchWebService;

    @Flow
    protected BenchFlow benchFlow;

    public BenchRankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragment = inflater.inflate(R.layout.fragment_bench_ranking, container, false);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        benchWebService.getPlayers(benchFlow.getCurrentBenchId(), new WebResponse(new GetBenchPlayersSuccessEvent()));
    }

    public void onEventMainThread(GetBenchPlayersSuccessEvent getPlayersEvent) {
        setPlayers(getPlayersEvent.get(), getView());
    }

    private void setPlayers(List<Player> players, View view) {
        ListView list = (ListView) view.findViewById(R.id.list_view_bench_ranking);
        list.setAdapter(new BenchRankingAdapter(getActivity(), R.id.list_item, players));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Player player = (Player) parent.getItemAtPosition(position);
                benchFlow.viewPlayerDetail(player.getId());
            }
        });
    }
}
