package ar.com.futbolapp.injection.component;


import ar.com.futbolapp.injection.PerActivity;
import ar.com.futbolapp.injection.module.ActivityModule;
import ar.com.futbolapp.ui.main.UserDashboardActivity;
import dagger.Component;

@PerActivity
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(UserDashboardActivity userDashboardActivity);

}