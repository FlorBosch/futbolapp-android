package ar.com.futbolapp.ui.matchlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ar.com.futbolapp.domain.Match;
import ar.com.futbolapp.network.FutbolappService;
import ar.com.futbolapp.ui.BasePresenter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MatchListPresenter extends BasePresenter<MatchListMvpView> {

    private final FutbolappService service;

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

    public Subscription getCityList() {

        return service.getMatches()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(Observable::error)
                .subscribe(matches -> {

                }, throwable -> {

                });
    }


}
