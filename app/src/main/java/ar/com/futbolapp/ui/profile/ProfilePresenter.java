package ar.com.futbolapp.ui.profile;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.network.FutbolappService;
import ar.com.futbolapp.ui.BasePresenter;

import static ar.com.futbolapp.util.NetworkUtil.call;

public class ProfilePresenter extends BasePresenter<ProfileMvpView> {

    private final FutbolappService service;
    private List<Player> playerList;

    @Inject
    public ProfilePresenter(FutbolappService service) {
        this.service = service;
    }

    void restoreState() {
        loadUser();
    }

    void loadUser() {
        checkViewAttached();
        addSubscription(call(service.getPlayers())
                .subscribe(response -> {
                    playerList = new ArrayList<>(response.values());
                    getMvpView().displayUserInfo(playerList.get(0));
                }, throwable -> Log.i("Error", throwable.getMessage())));
    }

}
