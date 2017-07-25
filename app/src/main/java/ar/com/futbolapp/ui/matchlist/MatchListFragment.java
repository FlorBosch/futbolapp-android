package ar.com.futbolapp.ui.matchlist;


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
import ar.com.futbolapp.ui.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class MatchListFragment extends BaseFragment implements MatchListMvpView {

    @BindView(R.id.match_list)
    RecyclerView matchList;

    @BindView(R.id.match_list_swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    @Inject
    MatchListPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_list, container, false);
        ButterKnife.bind(this, view);
        presenter.attachView(this);
        swipeRefresh.setOnRefreshListener(() -> presenter.loadMatches());
        matchList.setLayoutManager(new LinearLayoutManager(getActivity()));
        matchList.addItemDecoration(new DividerItemDecoration(matchList.getContext(), VERTICAL));
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
    public void displayMatches(List<Match> matches) {
        matchList.swapAdapter(new MatchListViewAdapter(matches), false);
    }

}
