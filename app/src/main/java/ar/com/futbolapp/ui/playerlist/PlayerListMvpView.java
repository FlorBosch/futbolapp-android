package ar.com.futbolapp.ui.playerlist;


import java.util.List;

import ar.com.futbolapp.domain.Match;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.ui.MvpView;

public interface PlayerListMvpView extends MvpView {
    void displayPlayers(List<Player> players);
}
