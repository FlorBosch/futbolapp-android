package ar.com.futbolapp.ui.matchlist;


import java.util.List;

import ar.com.futbolapp.ui.MvpView;

public interface MatchListMvpView extends MvpView {
    void displayMatches(List<String> matches);
}
