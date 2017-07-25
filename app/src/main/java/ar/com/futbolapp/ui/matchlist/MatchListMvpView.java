package ar.com.futbolapp.ui.matchlist;


import java.util.List;

import ar.com.futbolapp.domain.Match;
import ar.com.futbolapp.ui.MvpView;

public interface MatchListMvpView extends MvpView {
    void displayMatches(List<Match> matches);
}
