package ar.com.futbolapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setPlayers(List<Player> players, View view) {
        ListView list = (ListView) view.findViewById(R.id.list_view_bench_ranking);
        list.setAdapter(new BenchRankingAdapter(getActivity(), R.id.list_item, players));
    }
}
