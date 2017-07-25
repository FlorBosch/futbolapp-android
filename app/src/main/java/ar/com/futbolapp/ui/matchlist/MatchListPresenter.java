package ar.com.futbolapp.ui.matchlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ar.com.futbolapp.domain.Match;
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
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            matches.add(new Match("Match " + i, new Date()));
        }
        getMvpView().displayMatches(matches);
    }
}
