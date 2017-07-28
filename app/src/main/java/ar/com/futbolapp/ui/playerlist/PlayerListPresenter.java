package ar.com.futbolapp.ui.playerlist;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.network.FutbolappService;
import ar.com.futbolapp.ui.BasePresenter;

import static ar.com.futbolapp.util.NetworkUtil.call;

public class PlayerListPresenter extends BasePresenter<PlayerListMvpView> {

    private final FutbolappService service;
    private List<Player> playerList;

    @Inject
    public PlayerListPresenter(FutbolappService service) {
        this.service = service;
    }

    void restoreState() {
        loadPlayers();
    }

    void loadPlayers() {
        checkViewAttached();
        addSubscription(call(service.getPlayers())
                .subscribe(response -> {
                    playerList = new ArrayList<>(response.values());
                    getMvpView().displayPlayers(playerList);
                }, throwable -> Log.i("Error", throwable.getMessage())));
    }

}
