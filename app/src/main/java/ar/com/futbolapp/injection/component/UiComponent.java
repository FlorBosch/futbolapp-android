package ar.com.futbolapp.injection.component;


import javax.inject.Singleton;

import ar.com.futbolapp.injection.module.ActivityModule;
import ar.com.futbolapp.injection.module.NetworkModule;
import ar.com.futbolapp.ui.main.UserDashboardActivity;
import ar.com.futbolapp.ui.matchlist.MatchListFragment;
import dagger.Component;

@Singleton
@Component(modules = {ActivityModule.class, NetworkModule.class})
public interface UiComponent {

    void inject(UserDashboardActivity userDashboardActivity);
    void inject(MatchListFragment matchListFragment);

}