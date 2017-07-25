package ar.com.futbolapp.ui.main;


import javax.inject.Inject;

import ar.com.futbolapp.ui.BasePresenter;

public class UserDashboardPresenter extends BasePresenter<UserDashboardView> {

    @Inject
    public UserDashboardPresenter() {
    }

    String getUsername() {
        return "Florencia Bosch";
    }

    String[] getTeams() {
        return new String[]{"Team 1", "Team 2", "Team 3"};
    }
}
