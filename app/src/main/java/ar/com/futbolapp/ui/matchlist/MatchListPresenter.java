package ar.com.futbolapp.ui.matchlist;

import java.util.Arrays;

import javax.inject.Inject;

import ar.com.futbolapp.ui.BasePresenter;

public class MatchListPresenter extends BasePresenter<MatchListMvpView> {

    @Inject
    public MatchListPresenter() {
    }

    void restoreState() {
        loadMatches();
    }

    void loadMatches() {
        checkViewAttached();
        getMvpView().displayMatches(
                Arrays.asList("Match 1", "Match 2", "Match 3", "Match 4", "Match 5"));
    }
}
