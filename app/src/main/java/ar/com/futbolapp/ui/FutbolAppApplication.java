package ar.com.futbolapp.ui;

import android.app.Application;
import android.content.Context;

import com.auth0.core.Strategies;
import com.auth0.facebook.FacebookIdentityProvider;
import com.auth0.googleplus.GooglePlusIdentityProvider;
import com.auth0.lock.Lock;
import com.auth0.lock.LockProvider;

import ar.com.futbolapp.injection.component.ApplicationComponent;
import ar.com.futbolapp.injection.component.DaggerApplicationComponent;
import ar.com.futbolapp.injection.module.ApplicationModule;

public class FutbolAppApplication extends Application implements LockProvider {

    private ApplicationComponent applicationComponent;
    private Lock lock;

    public void onCreate() {
        super.onCreate();
        lock = new Lock.Builder()
                .loadFromApplication(this)
                .withIdentityProvider(Strategies.Facebook, new FacebookIdentityProvider(this))
                .withIdentityProvider(Strategies.GooglePlus, new GooglePlusIdentityProvider(this))
                /** Other configuration goes here */
                .closable(true)
                .build();
    }


    @Override
    public Lock getLock() {
        return lock;
    }

    public static FutbolAppApplication get(Context context) {
        return (FutbolAppApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return applicationComponent;
    }

}
