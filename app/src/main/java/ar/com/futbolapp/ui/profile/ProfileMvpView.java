package ar.com.futbolapp.ui.profile;


import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.ui.MvpView;

public interface ProfileMvpView extends MvpView {
    void displayUserInfo(Player user);
}
