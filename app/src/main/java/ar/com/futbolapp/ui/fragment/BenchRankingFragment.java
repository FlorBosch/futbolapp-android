package ar.com.futbolapp.ui.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ar.com.futbolapp.R;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.ui.adapter.BenchRankingAdapter;

public class BenchRankingFragment extends BaseFragment {

    public BenchRankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragment = inflater.inflate(R.layout.fragment_bench_ranking, container, false);
        ListView list = (ListView) fragment.findViewById(R.id.list_view_bench_ranking);
        list.setAdapter(new BenchRankingAdapter(getActivity(), R.id.list_item, getRanking() ));
        return fragment;
    }

    public List<Player> getRanking() {
        List<Player> players = new ArrayList<>();
        Player a = new Player();
        a.setName("Holis");
        a.setAverage(5);
        players.add(a);
        return players;
    }
}
