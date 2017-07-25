package ar.com.futbolapp.injection.component;


import ar.com.futbolapp.injection.PerActivity;
import ar.com.futbolapp.injection.module.ActivityModule;
import ar.com.futbolapp.ui.main.UserDashboardActivity;
import ar.com.futbolapp.ui.matchlist.MatchListFragment;
import dagger.Component;

@PerActivity
@Component(modules = ActivityModule.class)
public interface UiComponent {

    void inject(UserDashboardActivity userDashboardActivity);
    void inject(MatchListFragment matchListFragment);

}