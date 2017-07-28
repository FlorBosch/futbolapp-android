package ar.com.futbolapp.ui.playerlist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import ar.com.futbolapp.R;
import ar.com.futbolapp.domain.Match;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.ui.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class PlayerListFragment extends BaseFragment implements PlayerListMvpView {

    @BindView(R.id.player_list)
    RecyclerView playerList;

    @BindView(R.id.player_list_swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    @Inject
    PlayerListPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);
        ButterKnife.bind(this, view);
        presenter.attachView(this);
        swipeRefresh.setOnRefreshListener(() -> presenter.loadPlayers());
        playerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        playerList.addItemDecoration(new DividerItemDecoration(playerList.getContext(), VERTICAL));
        swipeRefresh.setRefreshing(false);
        presenter.restoreState();
        return view;
    }

    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void displayPlayers(List<Player> players) {
        playerList.swapAdapter(new PlayerListViewAdapter(players), false);
    }

}
