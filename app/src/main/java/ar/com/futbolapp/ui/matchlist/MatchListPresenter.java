package ar.com.futbolapp.ui.matchlist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ar.com.futbolapp.domain.Match;
import ar.com.futbolapp.network.FutbolappService;
import ar.com.futbolapp.ui.BasePresenter;

import static ar.com.futbolapp.util.NetworkUtil.call;

public class MatchListPresenter extends BasePresenter<MatchListMvpView> {

    private final FutbolappService service;
    private List<Match> matchList;

    @Inject
    public MatchListPresenter(FutbolappService service) {
        this.service = service;
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

    public void getMatches() {
        addSubscription(call(service.getMatches())
                .subscribe(response -> {
                    matchList = new ArrayList<>(response.values());
                    getMvpView().displayMatches(matchList);
                }, throwable -> Log.i("Error", throwable.getMessage())));
    }


}
