package ar.com.futbolapp.ui.main;

import java.util.List;

import ar.com.futbolapp.domain.Team;
import ar.com.futbolapp.ui.MvpView;


public interface UserDashboardView extends MvpView {
    void displayTeams(List<Team> teams);
}
