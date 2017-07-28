package ar.com.futbolapp.ui.main;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.com.futbolapp.domain.Team;
import ar.com.futbolapp.network.FutbolappService;
import ar.com.futbolapp.ui.BasePresenter;

import static ar.com.futbolapp.util.NetworkUtil.call;

public class UserDashboardPresenter extends BasePresenter<UserDashboardView> {

    private final FutbolappService service;
    private List<Team> teams;

    @Inject
    public UserDashboardPresenter(FutbolappService service) {
        this.service = service;
    }

    String getUsername() {
        return "Florencia Bosch";
    }

    void loadTeams() {
        checkViewAttached();
        addSubscription(call(service.getTeams())
                .subscribe(response -> {
                    teams = new ArrayList<>(response.values());
                    getMvpView().displayTeams(teams);
                }, throwable -> Log.i("Error", throwable.getMessage())));
    }

    void onTeamSelected(int index) {

    }
}
